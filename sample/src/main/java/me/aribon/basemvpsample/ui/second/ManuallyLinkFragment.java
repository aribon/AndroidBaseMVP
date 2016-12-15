package me.aribon.basemvpsample.ui.second;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import me.aribon.basemvpsample.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ManuallyLinkFragment extends Fragment implements ManuallyLinkView {

    private ManuallyLinkPresenter presenter;

    private TextView tvName, tvRole;
    private Button button;

    public ManuallyLinkFragment() {
        //Manually presenter creation
        presenter = new ManuallyLinkPresenter();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        presenter = new ManuallyLinkPresenter();
        presenter.onAttachView(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_second, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        tvName = (TextView) view.findViewById(R.id.second_name);
        tvRole = (TextView) view.findViewById(R.id.second_role);
        button = (Button) view.findViewById(R.id.second_button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onButtonClick();
            }
        });
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        //Manually view link
        presenter.onAttachView(this);
        presenter.onCreate();
    }

    @Override
    public void onDetach() {
        presenter.onDetachView();
        super.onDetach();
    }

    @Override
    public void onDestroy() {
        presenter.onDestroy();
        super.onDestroy();
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
