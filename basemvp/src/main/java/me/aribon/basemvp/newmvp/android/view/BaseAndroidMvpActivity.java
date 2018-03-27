package me.aribon.basemvp.newmvp.android.view;

import android.os.Bundle;
import android.support.annotation.Nullable;

import me.aribon.basemvp.newmvp.android.base.BaseActivity;
import me.aribon.basemvp.newmvp.android.presenter.AndroidMvpPresenter;
import me.aribon.basemvp.utils.exeption.PresenterInitializationException;

/**
 * @Author: aribon
 * @Date: 24/03/2018
 */

public abstract class BaseAndroidMvpActivity<P extends AndroidMvpPresenter> extends BaseActivity
    implements AndroidMvpView<P> {

  private P mPresenter;

  @Override
  public void setMvpPresenter(P mvpPresenter) {
    this.mPresenter = mvpPresenter;
  }

  @Override
  public P getMvpPresenter() {
    return mPresenter;
  }

  @Override
  public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    initializePresenter();
    checkIfPresenterInitialized();
  }

  public void initializePresenter() {

  }

  private void checkIfPresenterInitialized() {
    if (mPresenter == null) {
      throw new PresenterInitializationException();
    }
  }

  @Override
  protected void onDestroy() {
    super.onDestroy();
    mPresenter.detachMvpView();
  }
}
