package com.fridonium.toothpickexperiments;

import android.util.Log;

import javax.inject.Inject;

import toothpick.Toothpick;

public class SomeView2 implements ISomeView2 {

    @Inject
    ISomePresenter presenter;

    @Inject
    public SomeView2() {
    }

    public ISomeView2 initView() {
        Toothpick.inject(this, Toothpick.openScope("Main"));
        return this;
    }

    @Override
    public void click() {
        presenter.actionClick();
    }

    @Override
    public void clicked() {
        Log.d("!!!", "ACTION ON SOME VIEW 2");
    }
}
