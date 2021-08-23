package org.techtown.picker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.util.Pair;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.datepicker.MaterialPickerOnPositiveButtonClickListener;

public class MainActivity extends AppCompatActivity {

    private Button mDatePickerBtn;

    private TextView mSelectDateText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDatePickerBtn = findViewById(R.id.button);
        mSelectDateText = findViewById(R.id.textView);

        // MaterialDatePicker
       /* // 날짜 선택
        MaterialDatePicker.Builder builder = MaterialDatePicker.Builder.datePicker();*/

        // 날짜 선택 기간 표시
        MaterialDatePicker.Builder<Pair<Long, Long>> builder = MaterialDatePicker.Builder.dateRangePicker();

        builder.setTitleText("SELECT A DATE");
        MaterialDatePicker materialDatePicker = builder.build();

        mDatePickerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                materialDatePicker.show(getSupportFragmentManager(), "DATE_PICKER");

            }
        });

  /*      // 선택한 날짜 텍스트 뷰에 출력
        materialDatePicker.addOnPositiveButtonClickListener(new MaterialPickerOnPositiveButtonClickListener() {
            @Override
            public void onPositiveButtonClick(Object selection) {

                mSelectDateText.setText("Selected Date : " + materialDatePicker.getHeaderText());
            }
        });*/
    }
}