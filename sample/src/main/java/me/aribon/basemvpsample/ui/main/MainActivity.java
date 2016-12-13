package me.aribon.basemvpsample.ui.main;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import me.aribon.basemvp.view.BaseActivity;
import me.aribon.basemvpsample.R;

/**
 * Created on 19/03/2016
 *
 * @author Anthony
 */
public class MainActivity extends BaseActivity<MainPresenter> {

    private static final String TAG = MainActivity.class.getSimpleName();

    private TextView mainText;
    private Button mainBtn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainText = (TextView) findViewById(R.id.main_text);
        mainBtn = (Button) findViewById(R.id.main_btn);

        mainBtn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        getPresenter().showHello();
                    }
                }
        );
    }

    public String getMainText() {
        return mainText.getText().toString();
    }

    public void setMainText(String mainText) {
        this.mainText.setText(mainText);
    }

}
