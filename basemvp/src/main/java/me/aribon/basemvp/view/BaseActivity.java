package me.aribon.basemvp.view;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import me.aribon.basemvp.presenter.BasePresenter;

/**
 * Created on 19/03/2016
 *
 * @author Anthony
 */
public abstract class BaseActivity<P extends BasePresenter> extends Activity implements BaseView {

    private static final String TAG = BaseActivity.class.getSimpleName();

    protected P mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = initPresenter();
        if (mPresenter != null) {
            mPresenter.onCreate();
        } else {
            Log.e(TAG, "Error onCreate: Not attached view exception. Please use the " + BasePresenter.class.getName() + "::onAttachView() method.");
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

    protected abstract P initPresenter();
}
