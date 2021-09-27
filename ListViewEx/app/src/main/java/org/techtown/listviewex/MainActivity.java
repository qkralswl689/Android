package org.techtown.listviewex;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private TextView text1, text2,test3,test4;
    private Button listButton;
    private ListViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.custom_listview);
        text1 = (TextView) findViewById(R.id.listview_item_text1);
        text2 = (TextView) findViewById(R.id.listview_item_text2);
        test3 = (TextView) findViewById(R.id.listview_item_text3);
        test4  = (TextView) findViewById(R.id.listview_item_text4);
        listButton = (Button) findViewById(R.id.listview_item_button);

        adapter = new ListViewAdapter();
        listView.setAdapter(adapter);

        for (int i = 0; i < 10; i++) {
            adapter.add_item(i+1+"번째 아이템",i+1+"번째 속성","두번째","마지막");
        }
    }
}