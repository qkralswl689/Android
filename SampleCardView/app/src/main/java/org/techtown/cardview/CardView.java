package org.techtown.cardview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class CardView extends LinearLayout {

    ImageView imageView;
    TextView textView;
    TextView textView2;
    
    public CardView(Context context) {
        super(context);
        init(context);
    }

    public CardView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private void init(Context context) {
        // 인플레이션 진행하기
        // 시스템 서비스로 제공되므로 getSystemService 메서드를 호출하면서 파라미터로 LAYOUT_INFLATER_SERVICE 상수를 전달하면 객체가 반환된다
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.layout1, this,true);

        // XML 레이아웃에서 정의했던 뷰 참조하기
        imageView = findViewById(R.id.imageView);
        textView = findViewById(R.id.textView);
        textView2 = findViewById(R.id.textView2);
    }

    // 뷰에 데이터 설정
    public void setImage(int resId){
        imageView.setImageResource(resId);
    }
    public void setName(String name){
        textView.setText(name);
    }
    public void setMobile(String mobile){
        textView2.setText(mobile);
    }
}
