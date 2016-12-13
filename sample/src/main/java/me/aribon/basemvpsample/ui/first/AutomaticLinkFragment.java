package me.aribon.basemvpsample.ui.first;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import me.aribon.basemvp.view.BaseSupportFragment;
import me.aribon.basemvpsample.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class AutomaticLinkFragment extends BaseSupportFragment<AutomaticLinkPresenter> {

    private TextView tvName, tvRole;
    private Button button;

    public AutomaticLinkFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_automatic_link, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        tvName = (TextView) view.findViewById(R.id.automatic_link_name);
        tvRole = (TextView) view.findViewById(R.id.automatic_link_role);
        button = (Button) view.findViewById(R.id.automatic_link_button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getPresenter().onButtonClick();
            }
        });
    }

    public void displayName(String name) {
        tvName.setText(name);
    }

    public void displayRole(String role) {
        tvRole.setText(role);
    }
}
