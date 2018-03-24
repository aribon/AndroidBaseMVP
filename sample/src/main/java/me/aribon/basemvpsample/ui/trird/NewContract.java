package me.aribon.basemvpsample.ui.trird;

import me.aribon.basemvp.newmvp.android.presenter.AndroidMvpPresenter;
import me.aribon.basemvp.newmvp.android.view.AndroidMvpView;

/**
 * @Author: aribon
 * @Date: 17/01/2018
 */

public interface NewContract {

  interface View extends AndroidMvpView<Presenter> {

    void displayName(String name);

    void displayRole(String role);
  }

  interface Presenter extends AndroidMvpPresenter<View> {

    void onButtonClick();
  }
}
