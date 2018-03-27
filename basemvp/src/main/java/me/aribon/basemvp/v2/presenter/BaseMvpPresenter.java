package me.aribon.basemvp.v2.presenter;

import android.support.annotation.CallSuper;
import me.aribon.basemvp.AndroidLifecycle;
import me.aribon.basemvp.v2.view.MvpView;

/**
 * Created by anthony.ribon on 15/05/2017.
 */

public abstract class BaseMvpPresenter<V extends MvpView>
    implements MvpPresenter<V>, AndroidLifecycle {

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

  @CallSuper
  @Override
  public boolean hasAttachedView() {
    return this.view != null;
  }

  public V getView() {
    return view;
  }

}
