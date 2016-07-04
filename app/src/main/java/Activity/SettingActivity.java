package activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import just_tao.mobilesafe.R;
import view.SettingItemView;

/**
 * Created by JT on 2016/7/3.
 */
public class SettingActivity extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        initUI();
        initUpdate();
    }

    private void initUpdate() {
        final SettingItemView autoUpdate = (SettingItemView)findViewById(R.id.auto_update);
        autoUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isCheck = autoUpdate.isChecked();
                autoUpdate.setCheck(!isCheck);
            }
        });
    }

    private void initUI() {
    }
}
