package me.aribon.basemvp;

import android.os.Bundle;

/**
 * Created on 27/06/2016
 *
 * @author aribon
 */
public interface AndroidLifecycle {

    void onCreate(Bundle savedInstanceState);

    void onResume();

    void onStart();

    void onStop();

    void onPause();

    void onDestroy();

}
