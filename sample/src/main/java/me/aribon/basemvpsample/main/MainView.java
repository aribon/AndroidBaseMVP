package me.aribon.basemvpsample.main;

import me.aribon.basemvp.view.BaseActivity;

/**
 * Created on 28/06/2016
 *
 * @author aribon
 */
public abstract class MainView extends BaseActivity<MainPresenter> {

    public abstract void displayName(String name);

    public abstract void showName();

    public abstract void hideName();

    public abstract boolean isNameVisible();

    public abstract void displayRole(String role);

    public abstract void showRole();

    public abstract void hideRole();

    public abstract boolean isRoleVisible();

    public abstract void showButton();

    public abstract void hideButton();

}
