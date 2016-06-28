package me.aribon.basemvpsample.main;

import android.os.Bundle;
import android.widget.TextView;

import me.aribon.basemvp.view.BaseActivity;
import me.aribon.basemvpsample.R;

/**
 * Created on 19/03/2016
 *
 * @author Anthony
 */
public class MainActivity extends BaseActivity {

    private TextView tvName, tvRole;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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

    public void displayName(String name) {
        tvName.setText(name);
    }

    public void displayRole(String role) {
        tvRole.setText(role);
    }

    @Override
    public MainPresenter createPresenter() {
        return new MainPresenter();
    }
}
