package org.techtowndata;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


public class Fragment_1 extends Fragment {

    private View view;
    private Button btn;
    EditText edit;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_1, container, false);

        /*Button button = rootView.findViewById(R.id.btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle result = new Bundle();
                result.putString("bundleKey","result");
                getParentFragmentManager().setFragmentResult("requestKey",result);
            }
        });*/

        edit = rootView.findViewById(R.id.edit);
        btn = rootView.findViewById(R.id.btn);


        btn.setOnClickListener(new View.OnClickListener() { // 프래그먼트2로 이동
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle(); // 번들을 통해 값 전달
                bundle.putString("name",edit.getText().toString());//번들에 넘길 값 저장
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                Fragment_2 fragment2 = new Fragment_2();//프래그먼트2 선언
                fragment2.setArguments(bundle);//번들을 프래그먼트2로 보낼 준비
                transaction.replace(R.id.frame, fragment2);
                transaction.commit();
            }
        });
        return rootView;
    }


}