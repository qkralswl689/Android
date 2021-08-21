package org.techtown.pager;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ViewPager pager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pager.setCurrentItem(1);
            }
        });

        pager = findViewById(R.id.pager);
        pager.setOffscreenPageLimit(3);

        MyPagerAdapter adapter = new MyPagerAdapter(getSupportFragmentManager());

        Fragment1 fragment1 = new Fragment1();
        adapter.addItem(fragment1);

        Fragment2 fragment2 = new Fragment2();
        adapter.addItem(fragment2);

        Fragment3 fragment3 = new Fragment3();
        adapter.addItem(fragment3);

        pager.setAdapter(adapter);
    }

    // 뷰 페이지에 보여줄 각 프래그먼트를 관리하는 역할
    // 뷰 페이저에 설정하면 서로 장호작용하면서 화면에 표시해주게 된다
    class MyPagerAdapter extends FragmentStatePagerAdapter{
        // ArrayList : 프래그먼트들을 담아둔다
        ArrayList<Fragment> items = new ArrayList<Fragment>();
        public MyPagerAdapter(FragmentManager fm){
            super(fm);
        }

        // ArrayList안에 프래그먼트를 추가할 수 있는 메소드
        public void addItem(Fragment item){
            items.add(item);
        }

        @NonNull
        @Override
        // 프래그먼트를 가져갈 수 있는 메소드
        public Fragment getItem(int position) {
            return items.get(position);
        }

        @Override
        // 프래그먼트의 개수확인 메소드
        public int getCount() {
            return items.size();
        }

        @Nullable
        @Override
        // 타이틀스트립 : 전체 아이템의 개수와 현재 보고있는 아이템이 어떤 것인지 보여주기 위해 사용
        public CharSequence getPageTitle(int position) {
            return "페이지" + position;
        }
    }
    
    
}