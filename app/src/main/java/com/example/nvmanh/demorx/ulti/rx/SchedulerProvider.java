package com.example.nvmanh.demorx.ulti.rx;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class SchedulerProvider implements BaseSchedulerProvider {

    private static SchedulerProvider sIntance;

    private SchedulerProvider(){}

    public static SchedulerProvider getIntance(){
        if(sIntance == null){
            sIntance = new SchedulerProvider();
        }
        return sIntance;
    }

    @Override
    public Scheduler computation() {
        return Schedulers.computation();
    }

    @Override
    public Scheduler io() {
        return Schedulers.io();
    }

    @Override
    public Scheduler ui() {
        return AndroidSchedulers.mainThread();
    }
}
