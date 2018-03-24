package me.aribon.basemvp.newmvp.presenter;

import me.aribon.basemvp.newmvp.view.MvpView;

/**
 * @Author: aribon
 * @Date: 24/03/2018
 */

public interface MvpPresenter<V extends MvpView> {

  V getMvpView();
}
