package skmagic.mes.pda.View.Common;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import skmagic.mes.pda.R;

public class PDA_WM_LISTVIEW_ADAPTER_2 extends BaseAdapter {

    Context mContext = null;
    LayoutInflater mLayoutInflater = null;
    private ArrayList<PDA_WM_LISTVIEWITEM> listViewItem = new ArrayList<PDA_WM_LISTVIEWITEM>();

    // 생성자
    public PDA_WM_LISTVIEW_ADAPTER_2() {

    }

    public PDA_WM_LISTVIEW_ADAPTER_2(Context context, ArrayList<PDA_WM_LISTVIEWITEM> data) {
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
            convertView = inflater.inflate(R.layout.listview_wm_2, parent, false);


        }
        // 화면에 표시될 View(Layout이 inflate된)으로부터 위젯에 대한 참조 획득

        TextView maid = (TextView) convertView.findViewById(R.id.list_material_value_2);
        TextView pddef = (TextView) convertView.findViewById(R.id.list_productdef_value_2);
        TextView qty = (TextView) convertView.findViewById(R.id.list_qty_value);


        // Data Set(PDA_WM_LISTVIEWITEM)에서 position에 위치한 데이터 참조 획득
        PDA_WM_LISTVIEWITEM listviewitem = listViewItem.get(position);

        // 아이템 내 위젯에 데이터 반영

        maid.setText(listviewitem.getMaterial());
        pddef.setText(listviewitem.getProductdef());
        qty.setText(listviewitem.getQty());


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
    public void addItem(String material, String prodect, String qty) {
        PDA_WM_LISTVIEWITEM item = new PDA_WM_LISTVIEWITEM();

        item.setMaterial(material);
        item.setProductdef(prodect);
        item.setQty(qty);

        listViewItem.add(item);
    }


}
