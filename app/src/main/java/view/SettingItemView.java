package view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import android.widget.TextView;

import just_tao.mobilesafe.R;

/**
 * Created by JT on 2016/7/4.
 */
public class SettingItemView extends RelativeLayout{
    private CheckBox cb;
    private TextView tv_des;
    public SettingItemView(Context context) {
        this(context,null);
    }

    public SettingItemView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public SettingItemView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        View.inflate(context, R.layout.setting_item,this);

        TextView tv_title = (TextView)findViewById(R.id.tv_title);
        tv_des = (TextView)findViewById(R.id.tv_des);
        cb = (CheckBox) findViewById(R.id.cb_box);
    }

    public boolean isChecked(){
        return cb.isChecked();
    }
    public void setCheck(boolean check){
        cb.setChecked(check);
        if(isChecked()){
            tv_des.setText("自动更新已开启");
        }else {
            tv_des.setText("自动更新已关闭");
        }
    }
}
