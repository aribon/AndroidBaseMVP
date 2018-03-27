package me.aribon.basemvp.v1.presenter;

import android.support.annotation.CallSuper;

import me.aribon.basemvp.AndroidLifecycle;
import me.aribon.basemvp.v1.view.BaseView;

/**
 * Created on 19/03/2016
 *
 * @author Anthony
 */
public class BasePresenter<V extends BaseView> implements Presenter<V>, AndroidLifecycle {

    private V view;

    @CallSuper
    @Override
    public void onAttachView(V view) {
        this.view = view;
    }

    @Override
    public void onCreate() {

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

    @CallSuper
    @Override
    public void onDestroy() {
        onDetachView();
    }

    @CallSuper
    @Override
    public void onDetachView() {
        this.view = null;
    }

    @Override
    public boolean hasAttachedView() {
        return this.view != null;
    }

    public V getView() {
        return view;
    }

}
