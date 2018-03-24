package me.aribon.basemvp.newmvp.android.presenter;

import me.aribon.basemvp.newmvp.android.view.AndroidMvpView;
import me.aribon.basemvp.newmvp.presenter.MvpPresenter;

/**
 * @Author: aribon
 * @Date: 24/03/2018
 */

public interface AndroidMvpPresenter<V extends AndroidMvpView> extends MvpPresenter<V> {

  void attachMvpView(V mvpView);

  void detachMvpView();
}
