package me.aribon.basemvpsample.main;

import android.os.Bundle;

import me.aribon.basemvpsample.model.User;
import me.aribon.basemvp.presenter.BasePresenter;

/**
 * Created on 19/03/2016
 *
 * @author Anthony
 */
public class MainPresenter<P extends MainActivity> extends BasePresenter<P> {

    private User userModel;

    @Override
    public void onAttachView(P view) {
        super.onAttachView(view);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        userModel = new User();
    }

    @Override
    public void onResume() {
        super.onResume();
        view.displayName(userModel.getFullname());
        view.displayRole(userModel.getRole());
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
