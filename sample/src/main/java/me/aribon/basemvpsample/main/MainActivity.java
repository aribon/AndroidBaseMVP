package me.aribon.basemvpsample.main;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import me.aribon.basemvpsample.R;

/**
 * Created on 19/03/2016
 *
 * @author Anthony
 */
public class MainActivity extends MainView {

    private TextView tvName, tvRole;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvName = (TextView) findViewById(R.id.main_name);
        tvRole = (TextView) findViewById(R.id.main_role);
        button = (Button) findViewById(R.id.main_button);

        initializeClick();
    }

    protected void initializeClick() {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getPresenter().onButtonClick();
            }
        });
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
    public void displayName(String name) {
        tvName.setText(name);
    }

    @Override
    public void showName() {
        alphaVisibility(tvName, 1.0f, 500);
    }

    @Override
    public void hideName() {
        alphaVisibility(tvName, 0.0f, 500);
    }

    @Override
    public boolean isNameVisible() {
        return tvName.getAlpha() > 0.2f;
    }

    @Override
    public void displayRole(String role) {
        tvRole.setText(role);
    }

    @Override
    public void showRole() {
        alphaVisibility(tvRole, 1.0f, 500);
    }

    @Override
    public void hideRole() {
        alphaVisibility(tvRole, 0.0f, 500);
    }

    @Override
    public boolean isRoleVisible() {
        return tvRole.getAlpha() > 0.2f;
    }

    @Override
    public void showButton() {
        alphaVisibility(button, 1.0f, 500, new AnimatorListenerAdapter() {
            @Override
            public void onAnimationStart(Animator animation) {
                super.onAnimationEnd(animation);
                button.setClickable(true);
            }
        });
    }

    @Override
    public void hideButton() {
        alphaVisibility(button, 0.0f, 500, new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                button.setClickable(false);
            }
        });
    }

    @Override
    public MainPresenter createPresenter() {
        return new MainPresenter();
    }

    private void alphaVisibility(View view, float alpha, int duration) {
        view.animate().alpha(alpha).setDuration(duration);
    }

    private void alphaVisibility(View view, float alpha, int duration, AnimatorListenerAdapter listener) {
        view.animate().alpha(alpha).setDuration(duration).setListener(listener);
    }
}
