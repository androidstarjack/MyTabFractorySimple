package drg.yyh.cn.mytabfractorysimple;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;

import drg.yyh.cn.designtab_layout.YyhWebVew;
import drg.yyh.cn.mytabfractorysimple.adapter.SimpleFragmentPagerAdapter;

public class MainActivity extends AppCompatActivity {
    private ViewPager viewPager;
    private SimpleFragmentPagerAdapter pagerAdapter;
    private TabLayout tabLayout;
    private YyhWebVew wv_test;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        wv_test = (YyhWebVew) findViewById(R.id.wv_test);
        wv_test.loadLoaclUrl("https://www.baidu.com");
        /*//初始化ViewPager
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        // 设置适配器
        pagerAdapter = new SimpleFragmentPagerAdapter(getSupportFragmentManager(), this);
        viewPager.setAdapter(pagerAdapter);
        // 初始化TabLayout
        tabLayout = (TabLayout) findViewById(R.id.sliding_tabs);
        // 为TabLayout设置ViewPager
        tabLayout.setupWithViewPager(viewPager);
        for (int i = 0; i < tabLayout.getTabCount(); i++) {
            TabLayout.Tab tab = tabLayout.getTabAt(i);
            tab.setCustomView(pagerAdapter.getTabView(i));
        }*/
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        return  wv_test.onBack(keyCode,event,this);
    }
}
