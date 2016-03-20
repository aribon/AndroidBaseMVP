package me.aribon.basemvp.view;

import android.app.Fragment;

import me.aribon.basemvp.presenter.BasePresenter;

/**
 * Created on 19/03/2016
 *
 * @author Anthony
 */
public abstract class BaseFragment<P extends BasePresenter> extends Fragment implements BaseView<P> {

}
