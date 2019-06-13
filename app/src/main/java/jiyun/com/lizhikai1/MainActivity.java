package jiyun.com.lizhikai1;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;

import jiyun.com.lizhikai1.adapter.VpAdapter;
import jiyun.com.lizhikai1.fragment.SchoolFragment;
import jiyun.com.lizhikai1.fragment.AttentionFragment;

public class MainActivity extends AppCompatActivity {

    private TabLayout tab;
    private ViewPager vp;
    private ArrayList<Fragment> list;
    private VpAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        tab = (TabLayout) findViewById(R.id.tab);
        vp = (ViewPager) findViewById(R.id.vp);
        //集合添加fragment
        list = new ArrayList<>();
        list.add(new SchoolFragment());
        list.add(new AttentionFragment());
        //创建适配器
        adapter = new VpAdapter(getSupportFragmentManager(), list);
        vp.setAdapter(adapter);
        //tab的标题
        tab.addTab(tab.newTab().setText("校门"));
        tab.addTab(tab.newTab().setText("关注"));
        //tab和viewpage绑定
        tab.addOnTabSelectedListener(new TabLayout.BaseOnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                vp.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        vp.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tab));
    }
}
