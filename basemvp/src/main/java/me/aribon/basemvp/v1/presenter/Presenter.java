package me.aribon.basemvp.v1.presenter;


import me.aribon.basemvp.v1.view.View;

/**
 * Created on 27/06/2016
 *
 * @author aribon
 */
interface Presenter<V extends View> {

    void onAttachView(V view);

    void onDetachView();

    boolean hasAttachedView();

}
