package org.techtown.diary;

import static java.sql.DriverManager.println;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
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

    // 현재 위치를 담고있을 변수
    Location currentLocation;
    
    // 위치정보를 수신할 변수
    GPSListener gpsListener;
    
    // 위치를 확인한 후 위치 요청을 취소할 수 있도록 위치 정보를 확인한 횟수
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

    // Fragment2 클래스에서 호출할 것
    @Override
    public void onRequest(String command) {

        if(command != null){
            if(command.equals("getCurrentLocation")){
                getCurrentLocation();
            }
        }
    }

    // 위치 확인 시작
    private void getCurrentLocation() {
        // 현재 일자 확인후
        currentDate = new Date();
        currentDateString = AppConstants.dateFormat3.format(currentDate);
        // fragment2 에 설정후
        if(fragment2 != null){
            fragment2.setDateString(currentDateString);
        }
        
        LocationManager manager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

         try {

             // LocationManager객체에게 현재 위치를 요청
             currentLocation = manager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
             if(currentLocation != null){
                 Double latitude = currentLocation.getLatitude();
                 Double longitude = currentLocation.getLongitude();
                 String message = "Last Location -> Latitude : " + latitude + "\nLongitude:" + longitude;
                 println(message);

                 // 위치가 확인되면 getCurrentWeather,getCurrentAddress 메서드 호출

                 // 현재 위치를 이용해 날씨 확인
                 getCurrentWeather();
                 // 현재 위치를 이용해 주소 확인인
                getCurrentAddress();
             }
             
             gpsListener = new GPSListener();
             long minTime = 10000;
             float mindistance = 0;

             manager.requestLocationUpdates(LocationManager.GPS_PROVIDER,minTime,mindistance,gpsListener);
             println("Current location requested.");
             
         }catch (SecurityException e){
             e.printStackTrace();
         }
    }
    public void stopLocationService(){
        LocationManager manager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        
        try{
            manager.removeUpdates(gpsListener);
            println("Current location requested.");
        }catch (SecurityException e){
            e.printStackTrace();
        }
    }
    // 요청된 위치를 수신하기위해 만든것
    class GPSListener implements LocationListener{

        @Override
        public void onLocationChanged(@NonNull Location location) {
            
        }

        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {
            
        }

        @Override
        public void onProviderEnabled(@NonNull String provider) {

        }

        @Override
        public void onProviderDisabled(@NonNull String provider) {

        }
    }
}
