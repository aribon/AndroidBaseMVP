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
public abstract class BaseActivity<P extends BasePresenter<BaseView>> extends Activity implements BaseView<P> {

    private static final String TAG = BaseActivity.class.getSimpleName();

    protected P presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = createPresenter();
        presenter.onAttachView(this);

        //TODO Verification to improve
        if (presenter.hasAttachedView())
            presenter.onCreate(savedInstanceState);
        else
            Log.e(TAG, "onCreate: NotAttachedView. Please call Presenter::onAttachView()");
    }

//    public void createPresenter() {
//        presenter = initPresenter();
//
//        if (presenter == null)
//            throw new NullPointerException();
//
//
//
////        if (!presenter.hasAttachedView())
////            throw new NotAttachedViewException();
//
//        presenter.onCreate();
//
//    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.onResume();
    }

    @Override
    protected void onStart() {
        super.onStart();
        presenter.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
        presenter.onStop();
    }

    @Override
    protected void onPause() {
        super.onPause();
        presenter.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.onDestroy();
    }
}
