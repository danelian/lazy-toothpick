package com.fridonium.toothpickexperiments;

import android.util.Log;

import javax.inject.Inject;

import toothpick.Toothpick;

public class SomeView1 implements ISomeView1 {

    @Inject
    ISomePresenter presenter;

    public ISomeView1 initView() {
        Toothpick.inject(this, Toothpick.openScope("Main"));
        return this;
    }

    @Override
    public void click() {
        presenter.actionClick();
    }

    @Override
    public void clicked() {
        Log.d("!!!", "ACTION ON SOME VIEW 1");
    }

}
