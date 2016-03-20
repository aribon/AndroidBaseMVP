package me.aribon.basemvpsample.main;

import me.aribon.basemvpsample.model.User;
import me.aribon.basemvp.presenter.BasePresenter;

/**
 * Created on 19/03/2016
 *
 * @author Anthony
 */
public class MainPresenter extends BasePresenter<MainActivity> {

    private User userModel;

    @Override
    public void onCreate() {
        super.onCreate();
        userModel = new User();
    }

    @Override
    public void onAttachView(MainActivity view) {
        super.onAttachView(view);
    }

    @Override
    public void onResume() {
        super.onResume();
        mView.displayName(userModel.getFullname());
        mView.displayRole(userModel.getRole());
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onDetachView() {
        super.onDetachView();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
