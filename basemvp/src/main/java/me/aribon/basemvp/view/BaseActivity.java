package me.aribon.basemvp.view;

import android.app.Activity;
import android.os.Bundle;

import me.aribon.basemvp.presenter.BasePresenter;

/**
 * Created on 19/03/2016
 *
 * @author Anthony
 */
public abstract class BaseActivity<P extends BasePresenter> extends Activity implements BaseView<P> {

    protected P mPresenter;

    Class<P> pClass;

    protected P getInstanceOfP(Class<P> pClass) {
        try {
            return pClass.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
            return null;
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = getInstanceOfP(pClass);
        mPresenter.onCreate();
        mPresenter.onAttachView(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mPresenter.onResume();
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

    @Override
    public void setPresenter(P presenter) {
        this.mPresenter.onDetachView();
        this.mPresenter = presenter;
        this.mPresenter.onAttachView(this);
    }
}
