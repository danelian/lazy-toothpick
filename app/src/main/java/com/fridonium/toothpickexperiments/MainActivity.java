package com.fridonium.toothpickexperiments;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import toothpick.Scope;
import toothpick.Toothpick;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Scope scope = Toothpick.openScope("Main");
        scope.installModules(new SimpleModule());


        scope.getInstance(ISomeView1.class)
                .initView()
                .click();

        scope.getInstance(ISomeView2.class)
                .initView()
                .click();

    }

//    public static class A {
//
//        @Inject
//        ISomePresenter foo1;
//
//        @Inject
//        ISomePresenter foo2;
//
//        @Inject
//        ISomeView1 bar1;
//
//        @Inject
//        ISomeView1 bar2;
//
//    }

}
