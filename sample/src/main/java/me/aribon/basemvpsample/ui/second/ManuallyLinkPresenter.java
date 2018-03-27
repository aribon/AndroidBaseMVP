package me.aribon.basemvpsample.ui.second;

import me.aribon.basemvp.v1.presenter.BasePresenter;
import me.aribon.basemvpsample.model.User;


/**
 * Created by aribon from Insign Mobility
 * on 28/11/2016
 */
class ManuallyLinkPresenter extends BasePresenter<ManuallyLinkView> {

    private User userModel;

//    SecondPresenter() {
//        userModel = new User();
//    }

    @Override
    public void onCreate() {
        super.onCreate();
        userModel = new User();
    }

    void onButtonClick() {
        getView().displayName(userModel.getFullname());
        getView().displayRole(userModel.getRole());
    }
}
