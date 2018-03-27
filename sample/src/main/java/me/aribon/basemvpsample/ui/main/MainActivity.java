package me.aribon.basemvpsample.ui.main;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import me.aribon.basemvp.v1.view.BaseActivity;
import me.aribon.basemvpsample.R;
import me.aribon.basemvpsample.ui.first.AutomaticLinkFragment;
import me.aribon.basemvpsample.ui.second.ManuallyLinkFragment;
import me.aribon.basemvpsample.ui.thirth.HybridLinkFragment;

/**
 * Created on 19/03/2016
 *
 * @author Anthony
 */
public class MainActivity extends BaseActivity<MainPresenter> implements MainView {

    private static final String TAG = MainActivity.class.getSimpleName();

    private TextView mainText;
    private Button strictAutomaticBtn;
    private Button manuallyBtn;
    private Button freeAutomaticBtn;

    private boolean hasFragment = false;

    private enum MvpMode {
        STRICT_AUTOMATIC("strict_automatic"),
        FREE_AUTOMATIC("free_automatic"),
        MANUALLY("manually"),
        NONE("");

        String value;

        MvpMode(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        public static MvpMode find(String value) {
            if (value.equals(STRICT_AUTOMATIC.value))
                return STRICT_AUTOMATIC;
            if (value.equals(FREE_AUTOMATIC.value))
                return FREE_AUTOMATIC;
            if (value.equals(MANUALLY.value))
                return MANUALLY;
            return NONE;
        }

        public static String getString(MvpMode mode) {
            switch (mode) {
                case STRICT_AUTOMATIC:
                    return "strict_automatic";

                case FREE_AUTOMATIC:
                    return "free_automatic";

                case MANUALLY:
                    return "manually";

                default:
                    return null;
            }
        }
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainText = (TextView) findViewById(R.id.main_text);

        strictAutomaticBtn = (Button) findViewById(R.id.strict_automatic_btn);
        manuallyBtn = (Button) findViewById(R.id.manually_btn);
        freeAutomaticBtn = (Button) findViewById(R.id.free_automatic_btn);

        strictAutomaticBtn.setOnClickListener(
            new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    switchFragment(MvpMode.STRICT_AUTOMATIC);
                }
            }
        );

        freeAutomaticBtn.setOnClickListener(
            new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    switchFragment(MvpMode.FREE_AUTOMATIC);
                }
            }
        );

        manuallyBtn.setOnClickListener(
            new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    switchFragment(MvpMode.MANUALLY);
                }
            }
        );
    }

    @Override
    public void setMainText(String mainText) {
        this.mainText.setText(mainText);
    }

    private void switchFragment(MvpMode mode) {
        Fragment fragment = null;

        switch (mode) {
            case STRICT_AUTOMATIC:
                fragment = new AutomaticLinkFragment();
                break;
            case FREE_AUTOMATIC:
                fragment = new HybridLinkFragment();
                break;
            case MANUALLY:
                fragment = new ManuallyLinkFragment();
                break;
        }

        if (fragment == null)
            return;

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();

        if (hasFragment) {
            ft.replace(R.id.fragment_container, fragment, MvpMode.getString(mode));
        } else {
            hasFragment = true;
            ft.add(R.id.fragment_container, fragment, MvpMode.getString(mode));
        }

        ft.commit();
    }
}
