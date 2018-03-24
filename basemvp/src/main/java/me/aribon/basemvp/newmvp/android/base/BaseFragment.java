package me.aribon.basemvp.newmvp.android.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public abstract class BaseFragment extends Fragment {

  @Override
  public void onAttach(Context context) {
    super.onAttach(context);
    initializePresenter();
  }

  @Nullable
  @Override
  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                           @Nullable Bundle savedInstanceState) {
    return inflater.inflate(getLayoutResource(), container, false);
  }

  @Override
  public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    findView(view);
    initializeData();
    initializeView();
  }

  public abstract int getLayoutResource();

  public void findView(View view) {

  }

  public void initializePresenter() {

  }

  public void initializeData() {

  }

  public void initializeView() {

  }
}