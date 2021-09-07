package skmagic.mes.pda.View.Common;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import skmagic.mes.pda.R;

public class EDITTEXT_LISTVIEW_ADAPTER extends BaseAdapter {

    Context mContext = null;
    LayoutInflater mLayoutInflater = null;
    private ArrayList<EDITTEXT_LISTVIEWITEM> listViewItem = new ArrayList<EDITTEXT_LISTVIEWITEM>();

    // 생성자
    public EDITTEXT_LISTVIEW_ADAPTER() {

    }

    public EDITTEXT_LISTVIEW_ADAPTER(Context context, ArrayList<EDITTEXT_LISTVIEWITEM> data) {
        mContext = context;
        listViewItem = data;
        mLayoutInflater = LayoutInflater.from(mContext);
    }


    // Adapter에 사용되는 데이터의 개수를 리턴. : 필수 구현
    @Override
    public int getCount() {
        return listViewItem.size();
    }

    // position에 위치한 데이터를 화면에 출력하는데 사용될 View를 리턴. : 필수 구현
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        final int pos = position;
        final Context context = parent.getContext();


        // "listview_item" Layout을 inflate하여 convertView 참조 획득.
        if (convertView == null) {

            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.edittext_listview, parent, false);


        }
        // 화면에 표시될 View(Layout이 inflate된)으로부터 위젯에 대한 참조 획득
        TextView woid = (TextView) convertView.findViewById(R.id.material_value);
        TextView maid = (TextView) convertView.findViewById(R.id.quantity_value);


        // Data Set(PDA_WM_LISTVIEWITEM)에서 position에 위치한 데이터 참조 획득
        EDITTEXT_LISTVIEWITEM listviewitem = listViewItem.get(position);

        // 아이템 내 위젯에 데이터 반영
        woid.setText(listviewitem.getMaterial());
        maid.setText(listviewitem.getQuantity());



        return convertView;
    }

    // 지정한 위치(position)에 있는 데이터와 관계된 아이템(row)의 ID를 리턴. : 필수 구현
    @Override
    public long getItemId(int position) {
        return position;
    }

    // 지정한 위치(position)에 있는 데이터 리턴 : 필수 구현
    @Override
    public Object getItem(int position) {
        return listViewItem.get(position);
    }


    // 아이템 데이터 추가를 위한 함수. 개발자가 원하는대로 작성 가능.
    public void addItem(String material, String quantity) {
        EDITTEXT_LISTVIEWITEM item = new EDITTEXT_LISTVIEWITEM();

        item.setMaterial(material);
        item.setQuantity(quantity);

        listViewItem.add(item);
    }


    public void remove(Object item) {
        listViewItem.remove(item);
    }
}
