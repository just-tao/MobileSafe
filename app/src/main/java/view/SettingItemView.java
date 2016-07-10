package view;

import android.content.Context;
import android.content.pm.PackageManager;
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
    private String mTitle;
    private String mDescon;
    private String mDescoff;
    private final String NAMESPACE = "http://schemas.android.com/apk/res-auto";
    private int resourceId;
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
        mTitle = attrs.getAttributeValue(NAMESPACE,"title");
        mDescon = attrs.getAttributeValue(NAMESPACE,"descon");
        mDescoff = attrs.getAttributeValue(NAMESPACE,"descoff");
        tv_title.setText(mTitle);
        tv_des.setText(mDescoff);
    }

    public boolean isChecked(){
        return cb.isChecked();
    }
    public void setCheck(boolean check){
        cb.setChecked(check);
        if(isChecked()){
            tv_des.setText(mDescon);
        }else {
            tv_des.setText(mDescoff);
        }
    }
}
