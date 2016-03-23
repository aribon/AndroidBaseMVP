package me.aribon.basemvpsample.main;

import android.os.Bundle;
import android.widget.TextView;

import me.aribon.basemvpsample.R;
import me.aribon.basemvp.view.BaseActivity;

/**
 * Created on 19/03/2016
 *
 * @author Anthony
 */
public class MainActivity extends BaseActivity<MainPresenter> {

    private TextView tvName, tvRole;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mPresenter.onAttachView(this);
        tvName = (TextView) findViewById(R.id.main_name);
        tvRole = (TextView) findViewById(R.id.main_role);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public MainPresenter getPresenter() {
        return super.getPresenter();
    }

    @Override
    public void setPresenter(MainPresenter presenter) {
        super.setPresenter(presenter);
    }

    @Override
    protected MainPresenter initPresenter() {
        return new MainPresenter();
    }

    public void displayName(String name) {
        tvName.setText(name);
    }

    public void displayRole(String role) {
        tvRole.setText(role);
    }
}
