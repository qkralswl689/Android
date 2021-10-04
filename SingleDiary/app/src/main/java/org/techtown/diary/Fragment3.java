package org.techtown.diary;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;


public class Fragment3 extends Fragment {

    PieChart chart;
    BarChart chart2;
    LineChart chart3;


    @Override

    public View onCreateView(LayoutInflater inflater,  ViewGroup container, Bundle savedInstanceState) {
                                        // LayoutInflater 객체의 inflate 메서드 호출
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment3,container,false);

        initUI(rootView);

        return rootView;
    }

    // 인플레이션 후 xml 레이아웃 안에 들어있는 위젯 OR 레이아웃을 찾아 변수에 할당하는 코드들을 넣기 위해 만들어 둔것
    private void initUI(ViewGroup rootView){

/*        chart = rootView.findViewById(R.id.chart1);
        chart.setUsePercentValues(true);
        chart.getDescription().setEnabled(false);*/
    }
}
