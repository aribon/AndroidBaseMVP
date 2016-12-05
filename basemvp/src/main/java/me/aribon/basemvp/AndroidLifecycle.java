package me.aribon.basemvp;

/**
 * Created on 27/06/2016
 *
 * @author aribon
 */
public interface AndroidLifecycle {

    void onCreate();

    void onResume();

    void onStart();

    void onStop();

    void onPause();

    void onDestroy();

}
