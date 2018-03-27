package me.aribon.basemvpsample.ui.thirth;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import me.aribon.basemvp.v2.view.MvpSupportFragment;
import me.aribon.basemvpsample.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class HybridLinkFragment extends MvpSupportFragment<HybridLinkPresenter> implements HybridLinkView {

  private TextView tvName, tvRole;
  private Button button;

  public HybridLinkFragment() {
    // Required empty public constructor
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    return inflater.inflate(R.layout.fragment_hybrid_link, container, false);
  }

  @Override
  public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);

    tvName = (TextView) view.findViewById(R.id.hybrid_link_name);
    tvRole = (TextView) view.findViewById(R.id.hybrid_link_role);
    button = (Button) view.findViewById(R.id.hybrid_link_button);

    button.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        getPresenter().onButtonClick();
      }
    });
    getPresenter().foo();
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
