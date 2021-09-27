package org.techtown.listviewex;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.TextView;

import java.util.ArrayList;

public class ListViewAdapter extends BaseAdapter {

    ArrayList<ItemData> listview_data = new ArrayList<ItemData>();

    @Override
    public int getCount() {
        return listview_data.size();
    }

    @Override
    public Object getItem(int position) {
        return listview_data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final Context context = parent.getContext();

        if(convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.listview_item, parent, false);
        }

        TextView item_num = (TextView) convertView.findViewById(R.id.listview_item_text4);
        TextView item_atb = (TextView) convertView.findViewById(R.id.listview_item_text2);
        TextView three = (TextView) convertView.findViewById(R.id.listview_item_text3);
        TextView test = (TextView) convertView.findViewById(R.id.listview_item_text1);

        ItemData itemData = listview_data.get(position);

        item_num.setText(itemData.getItemOne());
        item_atb.setText(itemData.getItenTwo());
        three.setText(itemData.getItemThree());
        test.setText(itemData.getTest());

        return convertView;
    }

    public void add_item(String num, String atb,String three,String test) {
        ItemData m_item = new ItemData();

        m_item.setItemOne(num);
        m_item.setItenTwo(atb);
        m_item.setItemThree(three);
        m_item.setTest(test);


        listview_data.add(m_item);
    }
}