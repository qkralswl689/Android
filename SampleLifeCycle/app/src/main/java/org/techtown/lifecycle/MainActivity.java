package org.techtown.lifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText nameInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

/*
        Toast.makeText(this,"onCreate 호출됨",Toast.LENGTH_LONG).show();
*/
        println("onCreate 호출됨");
    }

    @Override
    protected void onStart() {
        super.onStart();

/*
        Toast.makeText(this,"onStart 호출됨",Toast.LENGTH_LONG).show();
*/
        println("onStart 호출됨");

    }

    @Override
    protected void onStop() {
        super.onStop();

/*
        Toast.makeText(this,"onStop 호출됨",Toast.LENGTH_LONG).show();
*/
        println("onStop 호출됨");
    }

    @Override
    protected void onResume() {
        super.onResume();

/*
        Toast.makeText(this,"onResume 호출됨",Toast.LENGTH_LONG).show();
*/
        println("onResume 호출됨");

        // 설정 정보에 저장된 데이터를 복원
        restoreState();
    }

    @Override
    protected void onPause() {
        super.onPause();

/*
        Toast.makeText(this,"onPause 호출됨",Toast.LENGTH_LONG).show();
*/
        println("onPause 호출됨");

        // 현재 입력상자에 입력된 데이터를 저장
        saveState();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

/*
        Toast.makeText(this,"onDestroy 호출됨",Toast.LENGTH_LONG).show();
*/
        println("onDestroy 호출됨");
    }

    public void println(String data){
        Toast.makeText(this,data,Toast.LENGTH_LONG).show();
        Log.d("Main",data);
    }

    // 설정 정보에 저장된 데이터를 가져와 토스트 메시지로 보여준다
    protected void restoreState(){
        SharedPreferences pref = getSharedPreferences("pref", Activity.MODE_PRIVATE);

        if((pref != null) && (pref.contains("name"))){

            String name = pref.getString("name","");
            nameInput.setText(name);
        }
    }

    // 현재 입력상자에 입력된 데이터 저장
    protected void saveState(){
        // pref 문자열을 저장소의 이름으로 사용
        // getSharedPreferences : SharedPreferences 객체를 사용하기 위해 사용
        SharedPreferences pref = getSharedPreferences("pref",Activity.MODE_PRIVATE);
        
        // SharedPreferences.Editor : 데이터를 저장할 수 있도록 edit 메서드를 제공하는 객체
        SharedPreferences.Editor editor = pref.edit();
        editor.putString("name",nameInput.getText().toString());
        
        // 저장후 commit() 메서드를 호출해야 실제로 저장된다
        editor.commit();
    }

    protected void clearState(){
        SharedPreferences pref = getSharedPreferences("pref",Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.clear();
        editor.commit();
    }
}