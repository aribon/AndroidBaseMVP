package me.aribon.basemvp.view;

import android.app.Fragment;
import android.os.Bundle;

import me.aribon.basemvp.presenter.BasePresenter;

/**
 * Created on 19/03/2016
 *
 * @author Anthony
 */
public abstract class BaseFragment<P extends BasePresenter<BaseView>> extends Fragment implements BaseView<P> {

    private static final String TAG = BaseFragment.class.getSimpleName();

    protected P mPresenter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = createPresenter();
        mPresenter.onAttachView(this);
        mPresenter.onCreate(savedInstanceState);

//        try {
//            createPresenter();
//
//        } catch (NotAttachedViewException | NullPointerException e) {
//            // TODO: 21/06/2016 Do anything
//            Log.e(TAG, e.getMessage());
//
//        } finally {
//            Log.d(TAG, "finish");
//            //TODO: 21/06/2016 Do something
//        }
    }

//    public void createPresenter() throws NotAttachedViewException, NullPointerException {
//        presenter = initPresenter();
//
//        if (presenter == null)
//            throw new NullPointerException();
//
//        presenter.onAttachView(this);
//
//        if (!presenter.hasAttachedView())
//            throw new NotAttachedViewException();
//
//        presenter.onCreate();
//
//    }

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
}
