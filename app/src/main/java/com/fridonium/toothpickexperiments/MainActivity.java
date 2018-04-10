package com.fridonium.toothpickexperiments;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import javax.inject.Inject;
import javax.inject.Provider;

import toothpick.Scope;
import toothpick.Toothpick;

public class MainActivity extends AppCompatActivity {

    @Inject
    Provider<ISomeView1> view1;

    @Inject
    Provider<ISomeView1> view2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Scope scope = Toothpick.openScope("Main");
        scope.installModules(new SimpleModule());
        Toothpick.inject(this, scope);
    }

    public void onClick(View view) {
        view1.get().initView().click();
        view2.get().initView().click();
    }
}
