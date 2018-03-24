package me.aribon.basemvpsample.ui.trird;


import me.aribon.basemvp.newmvp.android.presenter.BaseAndroidMvpPresenter;
import me.aribon.basemvpsample.model.User;

/**
 * Created by aribon from Insign Mobility
 * on 28/11/2016
 */
class NewMvpPresenter extends BaseAndroidMvpPresenter<NewContract.View>
    implements NewContract.Presenter {

  private User userModel;

  public NewMvpPresenter(NewContract.View mvpView) {
    super(mvpView);
    userModel = new User();
  }

  @Override
  public void onButtonClick() {
    getMvpView().displayName(userModel.getFullname());
    getMvpView().displayRole(userModel.getRole());
  }
}
