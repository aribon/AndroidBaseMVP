package me.aribon.basemvp.newmvp.android.view;

import me.aribon.basemvp.newmvp.android.presenter.AndroidMvpPresenter;
import me.aribon.basemvp.newmvp.view.MvpView;

/**
 * @Author: aribon
 * @Date: 24/03/2018
 */

public interface AndroidMvpView<P extends AndroidMvpPresenter> extends MvpView<P> {

  void setMvpPresenter(P mvpPresenter);

  P getMvpPresenter();
}
