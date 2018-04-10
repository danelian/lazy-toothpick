package com.fridonium.toothpickexperiments;

import android.util.Log;

import javax.inject.Inject;
import javax.inject.Provider;

import toothpick.config.Module;

class SimpleModule extends Module {

    SimpleModule() {
        Log.d("!!!", "new SimpleModule()");

        bind(ISomeView1.class).toProviderInstance(new Provider<ISomeView1>() {
            @Override
            public ISomeView1 get() {
                Log.d("!!!", "new SomeView1()");
                return new SomeView1();
            }
        }).providesSingletonInScope();

        bind(ISomeView2.class).toProviderInstance(new Provider<ISomeView2>() {
            @Override
            public ISomeView2 get() {
                Log.d("!!!", "new SomeView2()");
                return new SomeView2();
            }
        }).providesSingletonInScope();

        bind(ISomePresenter.class)
                .toProvider(SomePresenterProvider.class)
                .providesSingletonInScope();
    }

    public static class SomePresenterProvider implements Provider<ISomePresenter> {

        private final ISomeView1 view1;
        private final ISomeView2 view2;

        @Inject
        SomePresenterProvider(ISomeView1 view1, ISomeView2 view2) {
            this.view1 = view1;
            this.view2 = view2;
        }

        @Override
        public ISomePresenter get() {
            Log.d("!!!", "new SomePresenter(v1, v2)");
            return new SomePresenter(view1, view2);
        }

    }

}
