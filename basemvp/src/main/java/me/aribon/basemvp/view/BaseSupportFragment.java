package me.aribon.basemvp.view;

import android.support.v4.app.Fragment;

import me.aribon.basemvp.presenter.BasePresenter;

/**
 * Created on 19/03/2016
 *
 * @author Anthony
 */
public abstract class BaseSupportFragment<P extends BasePresenter> extends Fragment implements BaseView<P> {

}
