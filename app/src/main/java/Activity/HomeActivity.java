package Activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import just_tao.mobilesafe.R;

/**
 * Created by taojiang on 6/30/2016.
 */
public class HomeActivity extends Activity implements AdapterView.OnItemClickListener{
    private GridView gv_home;
    private final String IMAGE = "image";
    private final String NAME = "name";
    private String[] gv_name = new String[]{
        "手机防盗","通讯卫士","软件管理","进程管理","流量统计","手机杀毒","缓存清理","高级工具","设置中心"
    };
    private int[] gv_image = new int[]{
        R.drawable.home_safe,R.drawable.home_callmsgsafe,R.drawable.home_apps,R.drawable.home_taskmanager,
            R.drawable.home_netmanager,R.drawable.home_trojan,R.drawable.home_sysoptimize,R.drawable.home_tools,R.drawable.home_settings
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        gv_home = (GridView)findViewById(R.id.gv_home);
        SimpleAdapter simpleAdapter_gv = new SimpleAdapter(this,getGridViewData(),R.layout.gridview_item,new String[]{IMAGE,NAME},new int[]{R.id.gv_image,R.id.gv_text});
        gv_home.setAdapter(simpleAdapter_gv);
        gv_home.setOnItemClickListener(this);
    }
    private List<HashMap<String,Object>> getGridViewData(){
        List<HashMap<String,Object>> hashMapList = new ArrayList<HashMap<String,Object>>();
        for (int i=0;i<9;i++){
            HashMap<String,Object> hashMap = new HashMap<String, Object>();
            hashMap.put(gv_name[i],gv_image[i]);
            hashMapList.add(hashMap);
        }
        return hashMapList;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }
}

