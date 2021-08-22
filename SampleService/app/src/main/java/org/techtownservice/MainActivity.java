package org.techtownservice;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    
    EditText editText;

   @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        editText = findViewById(R.id.editText);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = editText.getText().toString();

                // 인텐트 객체 만들고 부가데이터 넣기
                Intent intent = new Intent(getApplicationContext(), MyService.class);
                
                // command : 서비스 쪽으로 전달한 인텐트 객체의 데이터가 어떤 목적으로 사용되는지를 구별하기 위해 넣은것
                intent.putExtra("command","show");
                
                // name : 입력상자에서 가져온 문자열을 전달하기 위한것
                intent.putExtra("name",name);
                
                // 서비스 시작학
                startService(intent);
            }
        });

        // 액티비티가 새로 만들어질 때 전달된 인텐트 처리하기
       Intent passedIntent = getIntent();
       processIntent(passedIntent);

    }

    @Override
    protected void onNewIntent(Intent intent) {

       // 액티비티가 이미 만들어져 있을 때 전달된 인텐트 처리

        processIntent(intent);

        super.onNewIntent(intent);
    }

    private void processIntent(Intent intent){
       if(intent != null){
           String command = intent.getStringExtra("command");
           String name = intent.getStringExtra("name");

           Toast.makeText(this,"command : " + command + ", name : " + name,Toast.LENGTH_LONG).show();
       }
    }
}