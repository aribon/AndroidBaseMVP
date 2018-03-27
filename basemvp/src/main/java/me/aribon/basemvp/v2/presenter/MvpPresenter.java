package me.aribon.basemvp.v2.presenter;

import me.aribon.basemvp.AndroidLifecycle;
import me.aribon.basemvp.v2.view.MvpView;

/**
 * Created by anthony.ribon on 15/05/2017.
 */

public interface MvpPresenter<V extends MvpView> extends AndroidLifecycle {

    void onAttachView(V view);

    void onDetachView();

    boolean hasAttachedView();

}
