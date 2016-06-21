package me.aribon.basemvp.view;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;

import me.aribon.basemvp.exception.NotAttachedViewException;
import me.aribon.basemvp.presenter.BasePresenter;

/**
 * Created on 19/03/2016
 *
 * @author Anthony
 */
public abstract class BaseSupportFragment<P extends BasePresenter<BaseView>> extends Fragment implements BaseView {

    private static final String TAG = BaseSupportFragment.class.getSimpleName();

    protected P mPresenter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
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
