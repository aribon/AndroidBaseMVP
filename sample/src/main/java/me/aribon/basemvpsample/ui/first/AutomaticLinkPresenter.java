package me.aribon.basemvpsample.ui.first;

import me.aribon.basemvp.v1.presenter.BasePresenter;
import me.aribon.basemvpsample.model.User;


/**
 * Created by aribon from Insign Mobility
 * on 28/11/2016
 */
class AutomaticLinkPresenter extends BasePresenter<AutomaticLinkFragment> {

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
