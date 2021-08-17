package org.techtown.diary;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity implements OnTabItemSelectedListener{

    Fragment1 fragment1;
    Fragment2 fragment2;
    Fragment3 fragment3;

    BottomNavigationView bottomNavigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 각각 객체로 만들어 변수에 할당
        fragment1 = new Fragment1();
        fragment2 = new Fragment2();
        fragment3 = new Fragment3();

        // FragmentManager 객체를 이용해 첫 번째 프레임 레이아웃 안에 추가되도록 함
        getSupportFragmentManager().beginTransaction().replace(R.id.container,fragment1).commit();

        bottomNavigation = findViewById(R.id.bottom_navigation);
        bottomNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            // 하단 탭에 들어 있는 각가의 버턴을 눌렀을 때 onNavigationItemSelected메서드가 자동으로 호출 되므로 그안에서 메뉴 아이템의 id값으로 버튼을 구분한 후 토스트 메시지를 띄운다
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.tab1:
                        Toast.makeText(getApplicationContext(),"첫 번째 탭 선택됨",Toast.LENGTH_LONG).show();
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,fragment1).commit();

                        return true;

                    case R.id.tab2:
                        Toast.makeText(getApplicationContext(),"두 번째 탭 선택됨",Toast.LENGTH_LONG).show();
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,fragment2).commit();

                        return true;

                    case R.id.tab3:
                        Toast.makeText(getApplicationContext(),"세 번째 탭 선택됨",Toast.LENGTH_LONG).show();
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,fragment3).commit();

                        return true;
                }
                return false;
            }
        });


    }

    @Override
    public void onTabSelected(int position) {

    }
}