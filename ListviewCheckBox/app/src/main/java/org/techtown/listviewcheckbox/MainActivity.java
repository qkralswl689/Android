package org.techtown.listviewcheckbox;


import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ListView;

public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 找到listview
        ListView listView = (ListView) findViewById(R.id.list);
        // 加载数据
        String[] strings = getResources().getStringArray(R.array.list);
        // arrayadapter适配器

        // ArrayAdapter<String> adapter = new ArrayAdapter<String>(
        // MainActivity.this, R.layout.list_item_1, strings);
        // listView.setAdapter(adapter);
        //

        // simpleadapter适配器
        /*
         * List<Map<String, String>> objList = new ArrayList<Map<String,
         * String>>(); Map<String, String> map = new HashMap<String, String>();
         * map.put("id", "1"); map.put("name", "zhansan"); map.put("sex", "男");
         *
         * Map<String, String> map1 = new HashMap<String, String>();
         * map1.put("id", "2"); map1.put("name", "hua"); map1.put("sex", "女");
         *
         * objList.add(map);
         *
         * objList.add(map1);
         *
         * SimpleAdapter simpleAdapter = new SimpleAdapter(MainActivity.this,
         * objList, R.layout.list_item_2, new String[] { "id", "name", "sex" },
         * new int[] { R.id.id, R.id.name, R.id.sex });
         * listView.setAdapter(simpleAdapter);
         */
        // 自定义Adapter
        final CheckBox box = (CheckBox) findViewById(R.id.idcheck);
        final List<Student> students = new ArrayList<Student>();
        final MyAdapter adapter2 = new MyAdapter(MainActivity.this, students);
        students.add(new Student("1", "aa", "男", false));
        students.add(new Student("2", "bb", "男", false));
        students.add(new Student("3", "cc", "女", false));
        Button addButton = (Button) findViewById(R.id.btn_add);
        addButton.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                students.add(new Student((students.size() + 1) + "", "aa", "男",
                        false));
                // 通知适配器更新数据
                adapter2.notifyDataSetChanged();
            }
        });
        listView.setAdapter(adapter2);
        listView.setSelection(students.size() - 1);
        box.setOnCheckedChangeListener(new OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView,
                                         boolean isChecked) {
                // 全选
                for (Student student : students) {
                    student.setState(isChecked);
                }
                // 通知适配器更新数据
                adapter2.notifyDataSetChanged();

            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

}