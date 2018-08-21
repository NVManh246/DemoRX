package com.example.nvmanh.demorx.screen.main;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.EditText;

import com.example.nvmanh.demorx.R;
import com.example.nvmanh.demorx.data.model.Hero;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MainContact.View {

    private MainContact.Presenter mPresenter;
    private RecyclerView mRecyclerHero;
    private EditText mEditSearch;
    private HeroAdapter mHeroAdapter;
    private List<Hero> mHeroes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerHero = findViewById(R.id.recycler_hero);
        mEditSearch = findViewById(R.id.eidt_hero);

        setupRecycler();
        searchHeros();
        mPresenter = new MainPresenter(this);
        mPresenter.getHeros();
    }

    @Override
    public void showHeros(List<Hero> heroes) {
        mHeroes.clear();
        mHeroes.addAll(heroes);
        mHeroAdapter.notifyDataSetChanged();
    }

    @Override
    public void showErros() {

    }

    private void setupRecycler(){
        mHeroes = new ArrayList<>();
        mHeroAdapter = new HeroAdapter(this, mHeroes);
        mRecyclerHero.setAdapter(mHeroAdapter);
        mRecyclerHero.hasFixedSize();
        mRecyclerHero.setLayoutManager(new LinearLayoutManager(this));
    }

    private void searchHeros(){
        mEditSearch.addTextChangedListener(new OnTextChange() {
            @Override
            public void searchHeros(String key) {
                mPresenter.searchHero(key);
            }
        });
    }
}
