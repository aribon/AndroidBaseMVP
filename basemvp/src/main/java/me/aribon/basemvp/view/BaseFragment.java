package me.aribon.basemvp.view;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;

import java.lang.reflect.ParameterizedType;

import me.aribon.basemvp.utils.exeption.NotAttachedViewException;
import me.aribon.basemvp.presenter.BasePresenter;

/**
 * Created on 19/03/2016
 *
 * @author Anthony
 */
public abstract class BaseFragment<P extends BasePresenter> extends Fragment implements BaseView {

    private static final String TAG = BaseFragment.class.getSimpleName();

    protected P mPresenter;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

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

    public P getPresenter() {
        return mPresenter;
    }

}
