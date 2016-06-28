package me.aribon.basemvp.presenter;

import android.os.Bundle;

import me.aribon.basemvp.AndroidLifecycle;
import me.aribon.basemvp.view.BaseView;

/**
 * Created on 19/03/2016
 *
 * @author Anthony
 */
public class BasePresenter<V extends BaseView> implements Presenter<V>, AndroidLifecycle {

    protected V view;

    @Override
    public void onAttachView(V view) {
        this.view = view;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {

    }

    @Override
    public void onResume() {

    }

    @Override
    public void onStart() {

    }

    @Override
    public void onStop() {

    }

    @Override
    public void onPause() {

    }

    @Override
    public void onDestroy() {
        onDetachView();
    }

    @Override
    public void onDetachView() {
        this.view = null;
    }

    @Override
    public boolean hasAttachedView() {
        return this.view != null;
    }
}
