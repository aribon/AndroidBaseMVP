package me.aribon.basemvp.newmvp.android.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * @Author: aribon
 * @Date: 24/03/2018
 */

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(getLayoutResource());
    }

  @Override
  protected void onPostCreate(@Nullable Bundle savedInstanceState) {
    super.onPostCreate(savedInstanceState);
    findView();
    initializeData();
    initializeView();
  }

  public abstract int getLayoutResource();

    public void findView() {

    }

    public void initializeData() {

    }

    public void initializeView() {

    }
}
