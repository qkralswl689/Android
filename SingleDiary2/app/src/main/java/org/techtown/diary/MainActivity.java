package org.techtown.diary;

import static java.sql.DriverManager.println;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.Date;

public class MainActivity extends AppCompatActivity implements OnTabItemSelectedListener,OnRequestListener{

    private static final String TAG = "Mainactivity";

    Fragment1 fragment1;
    Fragment2 fragment2;
    Fragment3 fragment3;

    BottomNavigationView bottomNavigation;

    Location currentLocation;
    GPSListener gpsListener;
    int locationCount = 0;
    String currentWeather;
    String currentAddress;
    String currentDateString;
    Date currentDate;

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

    // 지도
    @Override
    public void onRequest(String command) {

        if(command != null){
            if(command.equals("getCurrentLocation")){
                getCurrentLocation();
            }
        }
    }

    private void getCurrentLocation() {
        currentDate = new Date();
        currentDateString = AppConstants.dateFormat3.format(currentDate);
        if(fragment2 != null){
            fragment2.setDateString(currentDateString);
        }
        LocationManager manager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

         try {

             currentLocation = manager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
             if(currentLocation != null){
                 Double latitude = currentLocation.getLatitude();
                 Double longitude = currentLocation.getLongitude();
                 String message = "Last Location -> Latitude : " + latitude + "\nLongitude:" + longitude;
                 println(message);

                 getCurrentWeather();
                 getCurrentAddress();
             }
         }catch (SecurityException e){
             e.printStackTrace();
         }
    }
}