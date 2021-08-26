package org.techtown.fragment;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.Toolbar;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    // 로그캣 사용 준비
    private static final String TAG = "MainActivity";

    // 객체 선언
    Toolbar toolbar;
    TabLayout tabs;
    Fragment1 fragment1;
    Fragment2 fragment2;
    Fragment3 fragment3;

    Fragment selected = null;

    // main bundle
    Bundle mBundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

     /*   // 툴바 설정
        toolbar = findViewById(R.id.toolbar);

        // 액션바 설정
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.hide();*/

        // 프래그먼트 초기화
        fragment1 = new Fragment1();
        fragment2 = new Fragment2();
        fragment3 = new Fragment3();

        Button button = findViewById(R.id.fragment);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 프래그먼트 넣기(바꾸기)
                getSupportFragmentManager().beginTransaction().replace(R.id.container,fragment1).commit();
            }
        });


/*

        // 탭 만들기(동적)
        tabs = findViewById(R.id.tabs);
        tabs.addTab(tabs.newTab().setText("통화 기록"));
        tabs.addTab(tabs.newTab().setText("스팸 기록"));
        tabs.addTab(tabs.newTab().setText("연락처"));

        // 탭이 선택되었을때 작동하는 메서드
        tabs.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();
                Log.d(TAG,"선택된 탭 : " + position);


            }
*/

          /*  @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });*/
    }
    public void onFragmentChange(int index){

        if(index == 0){
            // .addToBackStack(null) : 프래그먼트에서 뒤로가기 할때 
            getSupportFragmentManager().beginTransaction().replace(R.id.container,fragment1).addToBackStack(null).commit();

        }else if(index == 1){
            getSupportFragmentManager().beginTransaction().replace(R.id.container,fragment2).addToBackStack(null).commit();

        }else if(index == 2) {
            getSupportFragmentManager().beginTransaction().replace(R.id.container,fragment3).addToBackStack(null).commit();

        }
    }

  /*  // 뒤로가기 버튼을 뺏어올 리스너 등록
    public interface onKeyBackPressedListener{
        void onBackKey();
    }
    private onKeyBackPressedListener mOnKeyBackPressedListener;
    public void setmOnKeyBackPressedListener(onKeyBackPressedListener listener){
        mOnKeyBackPressedListener = listener;
    }

    @Override
    public void onBackPressed() {
        if(mOnKeyBackPressedListener != null){
            mOnKeyBackPressedListener.onBackKey();
        }else {
            // 쌓인 BackStack 여부에 따라 Toast를 띄울지, 뒤로갈지
            if(getSupportFragmentManager().getBackStackEntryCount() == 0){
                Toast.makeText(this,"종료하려면 한번 더 누르세요 ",Toast.LENGTH_LONG).show();
            }else{
                super.onBackPressed();
            }
        }

    }*/
}