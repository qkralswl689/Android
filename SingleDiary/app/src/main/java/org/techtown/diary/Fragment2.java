package org.techtown.diary;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

public class Fragment2 extends Fragment {

    Context context;
    OnTabItemSelectedListener listener;
   
    @Override
                       
    public View onCreateView(LayoutInflater inflater,  ViewGroup container, Bundle savedInstanceState) {
                                        // LayoutInflater 객체의 inflate 메서드 호출
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment2,container,false);

        initUI(rootView);

        return rootView;
    }

    // 인플레이션 후 xml 레이아웃 안에 들어있는 위젯 OR 레이아웃을 찾아 변수에 할당하는 코드들을 넣기 위해 만들어 둔것
    private void initUI(ViewGroup rootView){
        Button saveButton = rootView.findViewById(R.id.saveButton);
       saveButton.setOnClickListener(new View.OnclickListener(){
          
       }
                                     
       Button deleteButton = rootView.findViewById(R.id.deleteButton);
       deleteButton.setOnClickListener(new View.OnclickListener(){
          
       }
                                       
       Button closeButton = rootView.findViewById(R.id.closeButton);
       closeButton.setOnClickListener(new View.OnclickListener(){
          
       }
                                      
     
    }
}
