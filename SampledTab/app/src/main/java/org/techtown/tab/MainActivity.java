package org.techtown.tab;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.util.Log;

import com.google.android.material.tabs.TabLayout;


public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;

    Fragment1 fragment1;
    Fragment2 fragment2;
    Fragment3 fragment3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // getSupportActionBar() : 액티비티에 디폴트로 만들어진 액션바가 없을 경우에만 동작
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowTitleEnabled(false);

        // 변수에 객체 할당
        fragment1 = new Fragment1();
        fragment2 = new Fragment2();
        fragment3 = new Fragment3();

        // 첫번째 프래그 먼트가 화면에 보이도록 설정
        getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment1).commit();

        TabLayout tabs = findViewById(R.id.tabs);
        // addTa() : 탭 버튼 추가 
        tabs.addTab(tabs.newTab().setText("통화기록"));
        tabs.addTab(tabs.newTab().setText("스팸기록"));
        tabs.addTab(tabs.newTab().setText("연락처"));

        // OnTabSelectedListener : 탭 버튼이 선택될 때마다 그 리스너 안에 있는 onTabSelected메서드가 호출되로독 한다
        tabs.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();
                Log.d("MainActivity","선택된 탭 : " + position);

                Fragment selected = null;
                if(position == 0){
                    selected = fragment1;
                }else if (position == 1) {
                    selected = fragment2;
                }else if (position == 2) {
                    selected = fragment3;
                }
                
                // 각각의 탭 버튼을 눌렀을 때 container라는 id를 가진 FrameLayout 안에 각가의 탭 버튼에 해당하는 프래그먼트 화면이 보이도록 한다
                getSupportFragmentManager().beginTransaction().replace(R.id.container,selected).commit();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }
}