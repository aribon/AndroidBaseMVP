package me.aribon.basemvp.view;

import android.os.Bundle;
import android.app.Fragment;

import me.aribon.basemvp.presenter.BasePresenter;

/**
 * Created on 19/03/2016
 *
 * @author Anthony
 */
public abstract class BaseFragment<P extends BasePresenter> extends Fragment implements BaseView {

    protected P mPresenter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = initPresenter();
        mPresenter.onAttachView(this);
        mPresenter.onCreate();
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.onResume();
    }

    @Override
    public void onStart() {
        super.onStart();
        mPresenter.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
        mPresenter.onStop();
    }

    @Override
    public void onPause() {
        super.onPause();
        mPresenter.onPause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mPresenter.onDestroy();
    }

    protected abstract P initPresenter();
}
