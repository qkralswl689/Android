package org.techtowndata;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //프래그먼트1 연결
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        Fragment_1 fragment1 = new Fragment_1();
        transaction.replace(R.id.frame, fragment1);
        transaction.commit();
    }
}