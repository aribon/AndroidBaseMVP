package me.aribon.basemvp.newmvp.android.presenter;

import me.aribon.basemvp.newmvp.android.view.AndroidMvpView;

/**
 * @Author: aribon
 * @Date: 24/03/2018
 */

public class BaseAndroidMvpPresenter<V extends AndroidMvpView> implements AndroidMvpPresenter<V> {

  private V mvpView;

  public BaseAndroidMvpPresenter(V mvpView) {
    attachMvpView(mvpView);
  }

  @Override
  public V getMvpView() {
    return mvpView;
  }

  @Override
  public void attachMvpView(V mvpView) {
    this.mvpView = mvpView;
    this.mvpView.setMvpPresenter(this);
  }

  @Override
  public void detachMvpView() {
    this.mvpView = null;
  }
}
