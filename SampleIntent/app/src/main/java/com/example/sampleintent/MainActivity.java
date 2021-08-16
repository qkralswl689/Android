package com.example.sampleintent;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // 새 액티비티를 띄울 때 보낼 요청 코드드
   public static final int REQUEST_CODE_MENU = 101;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),MenuActivity.class);
                startActivityForResult(intent,REQUEST_CODE_MENU);

            }
        });
    }

    // 새로 띄었던 메뉴 액티비티가 응답을 보내오면 그 응답을 처리하는 역할을 한다
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == REQUEST_CODE_MENU){
            Toast.makeText(getApplicationContext(),"onActivityResult 메서드 호출됨. 요청 코드 : " + resultCode + ", 결과 코드 : " + resultCode, Toast.LENGTH_LONG).show();
        }

        if(requestCode == RESULT_OK){
            String name = data.getStringExtra("name");
            Toast.makeText(getApplicationContext(),"응답으로 전달된 name : " + name, Toast.LENGTH_LONG).show();
        }
    }
}