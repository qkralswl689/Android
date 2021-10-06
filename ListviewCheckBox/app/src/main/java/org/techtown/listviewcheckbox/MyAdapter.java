package org.techtown.listviewcheckbox;
import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.CompoundButton.OnCheckedChangeListener;

public class MyAdapter extends BaseAdapter {
    private List<Student> list = null;
    private LayoutInflater inflater = null;
    private View view = null;

    public MyAdapter(Context context, List<Student> list) {
        this.list = list;
        inflater = LayoutInflater.from(context);
    }

    // 返回listView数据的条数
    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        // 获取布局
        view = inflater.inflate(R.layout.list_item_2, null);
        TextView id = (TextView) view.findViewById(R.id.id);
        TextView name = (TextView) view.findViewById(R.id.name);
        TextView sexTextView = (TextView) view.findViewById(R.id.sex);
        final CheckBox box = (CheckBox) view.findViewById(R.id.check);
        final Student student = list.get(position);
        box.setOnCheckedChangeListener(new OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView,
                                         boolean isChecked) {
                student.setState(isChecked);
            }
        });
        // 控件和数据的匹配
        id.setText(student.getId());
        name.setText(student.getName());
        sexTextView.setText(student.getSexString());
        box.setChecked(student.isState());
        return view;
    }

}