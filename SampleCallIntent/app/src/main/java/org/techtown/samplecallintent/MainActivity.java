package org.techtown.samplecallintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

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
                // 입력상자에 입력된 전화번호 확인
                String data = editText.getText().toString();

                // 전화걸기 화면을 보여줄 인텐트 객체 생성
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(data));

                // 액티비티 띄우기
                startActivity(intent);
            }
        });

        Button button2 = findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();

                // 컴포넌트 이름을 지정할 수 있는 객체 생성
                ComponentName name = new ComponentName("org.techtown.samplecallintent","org.techtown.samplecallintent.MenuActivity");

                // 인텐트 객체에 컴포넌트 지정
                intent.setComponent(name);

                // 액티비티 띄우기
                startActivityForResult(intent,101);
            }
        });
    }
}