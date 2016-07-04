package activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import just_tao.mobilesafe.R;

/**
 * Created by taojiang on 6/30/2016.
 */
public class HomeActivity extends Activity implements AdapterView.OnItemClickListener{
    private GridView gridViewHome;
    private final String IMAGE = "image";
    private final String NAME = "name";
    private String[] gridViewName = new String[]{
        "手机防盗","通讯卫士","软件管理","进程管理","流量统计","手机杀毒","缓存清理","高级工具","设置中心"
    };
    private int[] gridViewImage = new int[]{
        R.drawable.home_safe,R.drawable.home_callmsgsafe,R.drawable.home_apps,R.drawable.home_taskmanager,
            R.drawable.home_netmanager,R.drawable.home_trojan,R.drawable.home_sysoptimize,R.drawable.home_tools,R.drawable.home_settings
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        initUI();

    }
    private List<HashMap<String,Object>> getGridViewData(){
        List<HashMap<String,Object>> hashMapList = new ArrayList<HashMap<String,Object>>();
        for (int i=0;i<9;i++){
            HashMap<String,Object> hashMap = new HashMap<String, Object>();
            hashMap.put(IMAGE,gridViewImage[i]);
            hashMap.put(NAME,gridViewName[i]);
            hashMapList.add(hashMap);
        }
        return hashMapList;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        switch(position){
            case 8:
                Intent intent = new Intent(getApplicationContext(),SettingActivity.class);
                startActivity(intent);
                break;
        }
    }

    private void initUI(){
        gridViewHome = (GridView)findViewById(R.id.gv_home);
        //SimpleAdapter simpleAdapter_gv = new SimpleAdapter(this,getGridViewData(),R.layout.gridview_item,new String[]{IMAGE,NAME},new int[]{R.id.gv_image,R.id.gv_text});
        //gridViewHome.setAdapter(simpleAdapter_gv);
        gridViewHome.setAdapter(new GridViewAdapter());
        gridViewHome.setOnItemClickListener(this);
    }
    class GridViewAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return gridViewImage.length;
        }

        @Override
        public Object getItem(int position) {
            return gridViewName[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = View.inflate(getApplicationContext(),R.layout.gridview_item,null);
            //View view = LayoutInflater.from(getApplicationContext()).inflate(R.layout.gridview_item,null);
            TextView gvName = (TextView) view.findViewById(R.id.gv_text);
            ImageView gvImage = (ImageView) view.findViewById(R.id.gv_image);
            gvName.setText(gridViewName[position]);
            gvImage.setImageResource(gridViewImage[position]);
            return view;
        }
    }
}

