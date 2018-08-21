package com.example.nvmanh.demorx.screen.main;
import com.example.nvmanh.demorx.data.HerosRepository;
import com.example.nvmanh.demorx.data.api.ApiUtils;
import com.example.nvmanh.demorx.data.model.Hero;
import com.example.nvmanh.demorx.data.source.remote.HerosRemoteDataSource;
import com.example.nvmanh.demorx.ulti.rx.BaseSchedulerProvider;
import com.example.nvmanh.demorx.ulti.rx.SchedulerProvider;

import java.util.List;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

public class MainPresenter implements MainContact.Presenter {

    private MainContact.View mView;
    private HerosRepository mRepository;
    private BaseSchedulerProvider mSchedulerProvider;

    private CompositeDisposable mCompositeDisposable;

    public MainPresenter(MainContact.View view) {
        mView = view;
        mRepository = HerosRepository.getInstance(HerosRemoteDataSource.getInstance(ApiUtils.getApi()));
        mSchedulerProvider = SchedulerProvider.getIntance();
        mCompositeDisposable = new CompositeDisposable();
    }

    @Override
    public void getHeros() {
        Disposable disposable = mRepository.getHeros()
                .observeOn(mSchedulerProvider.ui())
                .subscribeOn(mSchedulerProvider.io())
                .subscribe(new Consumer<List<Hero>>() {
                    @Override
                    public void accept(List<Hero> heroes) throws Exception {
                        if (heroes != null) {
                            mView.showHeros(heroes);
                        }
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        mView.showErros();
                    }
                });
        mCompositeDisposable.add(disposable);
    }

    @Override
    public void searchHero(String key) {
        Disposable disposable = mRepository.searchHero(key)
                .observeOn(mSchedulerProvider.ui())
                .subscribeOn(mSchedulerProvider.io())
                .subscribe(new Consumer<List<Hero>>() {
                    @Override
                    public void accept(List<Hero> heroes) throws Exception {
                        if(heroes != null){
                            mView.showHeros(heroes);
                        }
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        mView.showErros();
                    }
                });
        mCompositeDisposable.add(disposable);
    }
}
