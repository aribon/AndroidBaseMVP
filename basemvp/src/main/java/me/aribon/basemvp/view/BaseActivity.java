package me.aribon.basemvp.view;

import android.app.Activity;
import android.os.Bundle;

import me.aribon.basemvp.exeption.NotAttachedViewException;
import me.aribon.basemvp.presenter.BasePresenter;

/**
 * Created on 19/03/2016
 *
 * @author Anthony
 */
public abstract class BaseActivity<P extends BasePresenter> extends Activity implements BaseView<P> {

    private static final String TAG = BaseActivity.class.getSimpleName();

    private P mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = createPresenter();
        mPresenter.onAttachView(this);

        if (mPresenter.hasAttachedView())
            mPresenter.onCreate();
        else {
            throw new NotAttachedViewException("onCreate: no view has attached. Please call Presenter::onAttachView()");
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        mPresenter.onResume();
    }

    @Override
    protected void onStart() {
        super.onStart();
        mPresenter.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mPresenter.onStop();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mPresenter.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.onDestroy();
    }

    @Override
    public P getPresenter() {
        return mPresenter;
    }

}
