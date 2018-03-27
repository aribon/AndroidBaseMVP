package me.aribon.basemvp.newmvp.android.view;

import android.content.Context;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import me.aribon.basemvp.newmvp.android.base.BaseFragment;
import me.aribon.basemvp.newmvp.android.presenter.AndroidMvpPresenter;
import me.aribon.basemvp.utils.exeption.PresenterInitializationException;

/**
 * @Author: aribon
 * @Date: 24/03/2018
 */

public abstract class BaseAndroidMvpFragment<P extends AndroidMvpPresenter> extends BaseFragment
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
    //TODO get arguments setting config
  }

  @Nullable
  @Override
  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    initializePresenter();
    checkIfPresenterInitialized();
    return super.onCreateView(inflater, container, savedInstanceState);
  }

  public void initializePresenter() {

  }

  private void checkIfPresenterInitialized() {
    if (mPresenter == null) {
      throw new PresenterInitializationException();
    }
  }

  @Override
  public void onDetach() {
    mPresenter.detachMvpView();
    super.onDetach();
  }
}
