package me.aribon.basemvpsample.ui.second;

import me.aribon.basemvp.view.BaseView;


/**
 * Created by aribon from Insign Mobility
 * on 28/11/2016
 */
interface ManuallyLinkView extends BaseView<ManuallyLinkPresenter> {

    void displayName(String name);

    void displayRole(String role);

}
