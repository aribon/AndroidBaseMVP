package me.aribon.basemvp.view;

import android.app.Activity;
import android.os.Bundle;

import java.lang.reflect.ParameterizedType;

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

        Class<P> persistentClass = (Class<P>) ((ParameterizedType) getClass()
                .getGenericSuperclass()).getActualTypeArguments()[0];
        try {
            mPresenter = persistentClass.newInstance();

            mPresenter.onAttachView(this);

            if (mPresenter.hasAttachedView())
                mPresenter.onCreate();
            else {
                throw new NotAttachedViewException("onCreate: no view has attached. Please call Presenter::onAttachView()");
            }
        } catch (Exception e) {
            e.printStackTrace();
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
