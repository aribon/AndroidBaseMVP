package me.aribon.basemvpsample.main;

import android.os.Bundle;

import me.aribon.basemvpsample.model.User;
import me.aribon.basemvp.presenter.BasePresenter;

/**
 * Created on 19/03/2016
 *
 * @author Anthony
 */
public class MainPresenter extends BasePresenter<MainActivity> {

    private User userModel;

    private int counter;

    @Override
    public void onAttachView(MainActivity view) {
        super.onAttachView(view);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        userModel = new User();
        counter = 1;
    }

    @Override
    public void onResume() {
        super.onResume();
        getView().showButton();
        getView().displayName(userModel.getFullname());
        getView().displayRole(userModel.getRole());
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

    public void onButtonClick() {

        if (counter%10 == 0)
            getView().hideButton();

        if (getView().isNameVisible())
            getView().hideName();
        else
            getView().showName();

        if (getView().isRoleVisible())
            getView().hideRole();
        else
            getView().showRole();

        counter++;
    }
}
