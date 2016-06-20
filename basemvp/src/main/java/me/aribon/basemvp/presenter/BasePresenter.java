package me.aribon.basemvp.presenter;

import me.aribon.basemvp.view.BaseView;

/**
 * Created on 19/03/2016
 *
 * @author Anthony
 */
public class BasePresenter<V extends BaseView> {

    protected V mView;

    public void onAttachView(V view) {
        this.mView = view;
    }

    public void onCreate() {

    }

    public void onResume() {

    }

    public void onStart() {

    }

    public void onStop() {

    }

    public void onPause() {

    }

    public void onDestroy() {
        onDetachView();
    }

    public void onDetachView() {
        this.mView = null;
    }
}
