package org.techtown.diary;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.github.channguyen.rsv.RangeSliderView;

public class Fragment2 extends Fragment {
    private static final String TAG = "Fragment2";
   

    Context context;
    OnTabItemSelectedListener listener;
    OnRequestListener requestListener;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        this.context = context;


        if (context instanceof OnTabItemSelectedListener) {
            listener = (OnTabItemSelectedListener) context;
        }
        if(context instanceof OnRequestListener){
            requestListener = (OnRequestListener) context;
           
        }
    }


    @Override
    public void onDetach() {
        super.onDetach();

        if (context != null) {
            context = null;
            listener = null;
            requestListener = null;
        }
    }

    @Override

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // LayoutInflater 객체의 inflate 메서드 호출
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment2, container, false);

        initUI(rootView);

        if(requestListener != null){{
            requestListener.onRequest("getCrrentcation");
        }}
        return rootView;
    }

    // 인플레이션 후 xml 레이아웃 안에 들어있는 위젯 OR 레이아웃을 찾아 변수에 할당하는 코드들을 넣기 위해 만들어 둔것
    private void initUI(ViewGroup rootView) {
        Button saveButton = rootView.findViewById(R.id.saveButton);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.onTabSelected(0);
                }
            }
        });


        Button deleteButton = rootView.findViewById(R.id.deleteButton);
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.onTabSelected(0);
                }
            }
        });

        Button closeButton = rootView.findViewById(R.id.closeButton);
        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.onTabSelected(0);
                }
            }
        });

        RangeSliderView sliderView = rootView.findViewById(R.id.sliderView);
        sliderView.setOnSlideListener(new RangeSliderView.OnSlideListener() {
            @Override
            public void onSlide(int index) {
                Toast.makeText(context, "moodIndex Changed to" + index, Toast.LENGTH_LONG).show();
            }
        });
        sliderView.setInitialIndex(2);
    }
}
