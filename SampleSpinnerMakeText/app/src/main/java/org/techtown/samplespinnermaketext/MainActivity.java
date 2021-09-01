package org.techtown.samplespinnermaketext;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

        TextView textView;

        //데이터를 배열에 넣어서 준비
        String[] items = {"fish", "turtle", "seal"};

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            Spinner spinner = findViewById(R.id.spinner);
            textView = findViewById(R.id.textView);

            ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                    //API에 만들어져 있는 R.layout.simple_spinner...를 씀
                    this,android.R.layout.simple_spinner_item, items
            );
            //미리 정의된 레이아웃 사용
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
            // 스피너 객체에다가 어댑터를 넣어줌
            spinner.setAdapter(adapter);
            spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                // 선택되면
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    textView.setText(items[position]);
                }

                // 아무것도 선택되지 않은 상태일 때
                @Override
                public void onNothingSelected(AdapterView<?> parent) {
                    textView.setText("선택: ");
                }
            });

        }
}