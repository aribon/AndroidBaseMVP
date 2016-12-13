package me.aribon.basemvpsample.ui.main;

import me.aribon.basemvp.presenter.BasePresenter;

/**
 * Created on 19/03/2016
 *
 * @author Anthony
 */
public class MainPresenter extends BasePresenter<MainActivity> {

    public void showHello() {
        getView().setMainText("Hello");
    }
}
