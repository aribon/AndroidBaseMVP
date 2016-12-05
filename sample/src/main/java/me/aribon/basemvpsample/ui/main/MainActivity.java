package me.aribon.basemvpsample.ui.main;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import me.aribon.basemvpsample.R;

/**
 * Created on 19/03/2016
 *
 * @author Anthony
 */
public class MainActivity extends AppCompatActivity implements MainView {

    MainPresenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public MainPresenter createPresenter() {
        return new MainPresenter();
    }

    @Override
    public MainPresenter getPresenter() {
        return presenter;
    }
}
