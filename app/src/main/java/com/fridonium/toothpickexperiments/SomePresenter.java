package com.fridonium.toothpickexperiments;

import javax.inject.Inject;

public class SomePresenter implements ISomePresenter {

    private final ISomeView1 view1;
    private final ISomeView2 view2;

    @Inject
    public SomePresenter(ISomeView1 view1, ISomeView2 view2) {
        this.view1 = view1;
        this.view2 = view2;
    }

    @Override
    public void actionClick() {
        view1.clicked();
        view2.clicked();
    }

}
