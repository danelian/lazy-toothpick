package com.fridonium.toothpickexperiments;

import toothpick.Lazy;
import toothpick.config.Module;

class SimpleModule extends Module {

    private final SomeView1 view1;
    private final SomeView2 view2;

    SimpleModule() {

        bind(ISomePresenter.class).toProviderInstance(new Lazy<ISomePresenter>() {
            @Override
            public ISomePresenter get() {
                return new SomePresenter(view1, view2);
            }
        });

        view1 = new SomeView1();
        view2 = new SomeView2();


        bind(ISomeView1.class).toInstance(view1);
        bind(ISomeView2.class).toInstance(view2);
    }

}
