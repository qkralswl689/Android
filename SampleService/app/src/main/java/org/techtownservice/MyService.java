package org.techtownservice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {

    private static final String TAG = "MyService";

    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG,"onCreate() 호출됨");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        Log.d(TAG,"onStartCommand() 호출됨");

        // 인텐트 객체가 null이 아니면 processCommand()메서드 호출
        if(intent == null){
            return Service.START_STICKY;
        }else {
            processCommand(intent);
        }
        return super.onStartCommand(intent, flags, startId);
    }

    private void processCommand(Intent intent){
        // 인텐트에서 부가 데이터 가져오기
        String command = intent.getStringExtra("command");
        String name = intent.getStringExtra("name");

        Log.d(TAG,"command : " + command + ", name : " + name);

        // 5초 동안 1초에 한번씩 로그 출력
        for(int i = 0; i < 5; i++){
            try {
                Thread.sleep(1000);
            }catch (Exception e){};

            Log.d(TAG,"waiting" + i + "seconds");
        }

        // 액티비티를 띄우기 위한 인텐트 객체 만들기
        Intent showIntent = new Intent(getApplicationContext(),MainActivity.class);

        // 인텐트에 플래그 추가하기
        showIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK |
                            Intent.FLAG_ACTIVITY_SINGLE_TOP |
                            Intent.FLAG_ACTIVITY_CLEAR_TOP);
        showIntent.putExtra("command","show");
        showIntent.putExtra("name", name + "from service");
        startActivity(showIntent);


    }
}