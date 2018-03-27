package me.aribon.basemvpsample.ui.thirth;

import me.aribon.basemvp.v2.presenter.BaseMvpPresenter;
import me.aribon.basemvpsample.model.User;

/**
 * Created by anthony.ribon on 22/05/2017.
 */

public class HybridLinkPresenter extends BaseMvpPresenter<HybridLinkView> {

  private User userModel;

  @Override
  public void onCreate() {
    super.onCreate();
    userModel = new User();
  }

  void onButtonClick() {
    getView().displayName(userModel.getFullname());
    getView().displayRole(userModel.getRole());
  }

  void foo() {

  }
}
