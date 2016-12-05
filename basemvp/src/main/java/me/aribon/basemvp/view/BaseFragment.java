package me.aribon.basemvp.view;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;

import me.aribon.basemvp.exeption.NotAttachedViewException;
import me.aribon.basemvp.presenter.BasePresenter;

/**
 * Created on 19/03/2016
 *
 * @author Anthony
 */
public abstract class BaseFragment<P extends BasePresenter> extends Fragment implements BaseView<P> {

    private static final String TAG = BaseFragment.class.getSimpleName();

    protected P mPresenter;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mPresenter = createPresenter();
        mPresenter.onAttachView(this);
        mPresenter.onCreate();

        if (mPresenter.hasAttachedView())
            mPresenter.onCreate();
        else {
            throw new NotAttachedViewException("onCreate: no view has attached. Please call Presenter::onAttachView()");
        }
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

    @Override
    public P getPresenter() {
        return mPresenter;
    }

}
