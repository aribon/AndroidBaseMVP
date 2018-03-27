package me.aribon.basemvpsample.ui.trird;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import me.aribon.basemvp.newmvp.android.view.BaseAndroidMvpFragment;
import me.aribon.basemvpsample.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class NewMvpFragment extends BaseAndroidMvpFragment<NewContract.Presenter>
    implements NewContract.View {

  private TextView tvName, tvRole;
  private Button button;

  @Override
  public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);

    tvName = view.findViewById(R.id.second_name);
    tvRole = view.findViewById(R.id.second_role);
    button = view.findViewById(R.id.second_button);

    button.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        getMvpPresenter().onButtonClick();
      }
    });
  }

  @Override
  public int getLayoutResource() {
    return R.layout.fragment_second;
  }

  @Override
  public void initializePresenter() {
    super.initializePresenter();
    new NewMvpPresenter(this);
  }

  @Override
  public void displayName(String name) {
    tvName.setText(name);
  }

  @Override
  public void displayRole(String role) {
    tvRole.setText(role);
  }
}
