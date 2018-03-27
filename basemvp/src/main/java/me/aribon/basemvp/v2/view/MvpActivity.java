package me.aribon.basemvp.v2.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import java.lang.reflect.ParameterizedType;
import me.aribon.basemvp.exeption.NotAttachedViewException;
import me.aribon.basemvp.v2.presenter.MvpPresenter;
import me.aribon.basemvp.v1.view.BaseActivity;

/**
 * Created by Benoit.deguine on 15/05/2017.
 */

public abstract class MvpActivity<P extends MvpPresenter>
    extends AppCompatActivity
    implements MvpView {

  private static final String TAG = BaseActivity.class.getSimpleName();

  private P mPresenter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    Class<P> presenterClass = (Class<P>) ((ParameterizedType) getClass()
        .getGenericSuperclass()).getActualTypeArguments()[0];

    try {
      mPresenter = presenterClass.newInstance();

      mPresenter.onAttachView(this);

      if (mPresenter.hasAttachedView())
        mPresenter.onCreate();
      else {
        throw new NotAttachedViewException("onCreate: no view has attached. Please call Presenter::onAttachView()");
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Override
  protected void onResume() {
    super.onResume();
    mPresenter.onResume();
  }

  @Override
  protected void onStart() {
    super.onStart();
    mPresenter.onStart();
  }

  @Override
  protected void onStop() {
    super.onStop();
    mPresenter.onStop();
  }

  @Override
  protected void onPause() {
    super.onPause();
    mPresenter.onPause();
  }

  @Override
  protected void onDestroy() {
    super.onDestroy();
    mPresenter.onDestroy();
  }

  public P getPresenter() {
    return mPresenter;
  }

}
