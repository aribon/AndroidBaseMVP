package me.aribon.basemvp.view;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import me.aribon.basemvp.exception.NotAttachedViewException;
import me.aribon.basemvp.presenter.BasePresenter;

/**
 * Created on 19/03/2016
 *
 * @author Anthony
 */
public abstract class BaseActivity<P extends BasePresenter<BaseView>> extends Activity implements BaseView {

    private static final String TAG = BaseActivity.class.getSimpleName();

    protected P mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        try {
            preparePresenter();

        } catch (NotAttachedViewException | NullPointerException e) {
            // TODO: 21/06/2016 Do anything
            Log.e(TAG, e.getMessage());

        } finally {
            Log.d(TAG, "finish");
            //TODO: 21/06/2016 Do something
        }
    }

    public void preparePresenter() throws NotAttachedViewException, NullPointerException {
        mPresenter = initPresenter();

        if (mPresenter == null)
            throw new NullPointerException();

        mPresenter.onAttachView(this);

        if (!mPresenter.hasAttachedView())
            throw new NotAttachedViewException();

        mPresenter.onCreate();

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
