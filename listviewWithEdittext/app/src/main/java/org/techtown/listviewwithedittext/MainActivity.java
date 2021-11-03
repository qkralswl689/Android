package org.techtown.listviewwithedittext;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListAdapter adapter;
    private Button add;
    private Button remove;
    private Button result;
    private ListView listView;
    private int num;

    public ArrayList<EditText> find = new ArrayList<>();
    public ArrayList<ListItem> listViewItemList = new ArrayList<ListItem>(); //리스트뷰
    private ArrayList<ListItem> filteredItemList = listViewItemList; //리스트뷰 임시저장소
    public ArrayList<String> find2 = new ArrayList<>();

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        num = 0;

        add = (Button) findViewById(R.id.add);
        remove = (Button) findViewById(R.id.remove);
        result = (Button) findViewById(R.id.result);
        listView = (ListView) findViewById(R.id.listview);

        adapter = new ListAdapter();

        listView.setAdapter(adapter);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, num + "추가되었습니다.", Toast.LENGTH_SHORT).show();
                adapter.addItem(num + "", "", "", num);
                adapter.notifyDataSetChanged();
                num++;
            }
        });

        remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "삭제되었습니다.", Toast.LENGTH_SHORT).show();
                adapter.delItem();
                adapter.notifyDataSetChanged();
                num--;
            }
        });

        result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "입력되었습니다.", Toast.LENGTH_SHORT).show();
                System.out.println(adapter.getItem(0).toString());

                for (int i = 0; i < listViewItemList.size(); i++) {
                    System.out.println(listViewItemList.get(i).getName());
                    System.out.println(listViewItemList.get(i).getCount());
                    System.out.println(listViewItemList.get(i).getPrice());
                }
            }
        });
    }
    //어뎁터 시작
    public class ListAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return filteredItemList.size();
        }

        @Override
        public Object getItem(int position) {
            return filteredItemList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            final int pos = filteredItemList.get(position).getNum();
            final Context context = parent.getContext();
            final ViewHolder holder;

            // "listview_item" Layout을 inflate하여 convertView 참조 획득.
            if (convertView == null) {
                holder = new ViewHolder();
                LayoutInflater inflater =
                        (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                convertView = inflater.inflate(R.layout.lyt_listview_list, parent, false);
                holder.editText1 = (EditText)convertView.findViewById(R.id.editText1);
                holder.editText2 = (EditText)convertView.findViewById(R.id.editText2);
                holder.editText3 = (EditText)convertView.findViewById(R.id.editText3);

                convertView.setTag(holder);
            }else{
                holder = (ViewHolder)convertView.getTag();
            }

            holder.ref = position;

            // 화면에 표시될 View(Layout이 inflate된)으로부터 위젯에 대한 참조 획득
            final EditText editText1 = (EditText)convertView.findViewById(R.id.editText1);

            // Data Set(filteredItemList)에서 position에 위치한 데이터 참조 획득
            final ListItem listViewItem = filteredItemList.get(position);

            holder.editText1.setText(listViewItem.getName());
            holder.editText2.setText(listViewItem.getCount());
            holder.editText3.setText(listViewItem.getPrice());

            holder.editText1.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {

                }

                @Override
                public void afterTextChanged(Editable s) {
                    filteredItemList.get(holder.ref).setName(s.toString());
                }
            });

            holder.editText2.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {

                }

                @Override
                public void afterTextChanged(Editable s) {
                    filteredItemList.get(holder.ref).setCount(s.toString());
                }
            });

            holder.editText3.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {

                }

                @Override
                public void afterTextChanged(Editable s) {
                    filteredItemList.get(holder.ref).setPrice(s.toString());
                    find2.add(holder.editText3.getText().toString());
                }
            });

            return convertView;
        }

        public void addItem(String name, String count, String price, int num) {
            ListItem item = new ListItem();
            item.setName(name);
            item.setCount(count);
            item.setPrice(price);
            item.setNum(num);

            listViewItemList.add(item);
        }

        public void delItem() {
            if (listViewItemList.size() < 1) {
            } else {
                listViewItemList.remove(listViewItemList.size() - 1);
            }
        }
    }
}
