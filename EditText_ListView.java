package skmagic.mes.pda.View.Common;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Phaser;

import skmagic.mes.pda.R;

public class EditText_ListView extends Fragment {

    PDA_COMMON_MAIN mainVIew;
    EditText insert;

    ListView listView;
    // 데이터를 저장할 리스트
    ArrayList<EDITTEXT_LISTVIEWITEM> list = new ArrayList<EDITTEXT_LISTVIEWITEM>();

    TextView material_value;

    ArrayAdapter<String> mAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mainVIew = (PDA_COMMON_MAIN) getActivity();

        ViewGroup rootview = (ViewGroup) inflater.inflate(R.layout.edittext_listview_main, container, false);


        return rootview;

    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        listView = (ListView) mainVIew.findViewById(R.id.list);
        final EDITTEXT_LISTVIEW_ADAPTER adapter = new EDITTEXT_LISTVIEW_ADAPTER();
        listView.setAdapter(adapter);

        SwipeDismissListViewTouchListener touchListener =
                new SwipeDismissListViewTouchListener(listView, new SwipeDismissListViewTouchListener.DismissCallbacks() {
                            @Override
                            public boolean canDismiss(int position) {
                                return true;
                            }

                            @Override
                            public void onDismiss(ListView listView, int[] reverseSortedPositions) {
                                for (int position : reverseSortedPositions) {
                                    adapter.remove(adapter.getItem(position));
                                }
                                adapter.notifyDataSetChanged();
                            }
                        });
        listView.setOnTouchListener(touchListener);
        listView.setOnScrollListener(touchListener.makeScrollListener());


        insert = (EditText) mainVIew.findViewById(R.id.listview_insert);


        insert.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent keyEvent) {

                switch (keyCode) {
                    case KeyEvent.KEYCODE_ENTER:
                        // EditText에 입력된 문자열값을 얻기
                        String text = insert.getText().toString();

                        View view = null;
                        ;
                        String value = "";
                        int count = 1;
                        int position = adapter.getCount();

                        // 입력된 text 문자열이 비어있지 않으면
                        if (!text.isEmpty()) {

                            if (position == 0) {
                                adapter.addItem(text, Integer.toString(count));
                                insert.setText("");
                                adapter.notifyDataSetChanged();
                            } else if (position != 0) {

                                for (int i = 0; i < position; i++) {
                                    material_value = (TextView) mainVIew.findViewById(R.id.material_value);
                                    view = adapter.getView(i, view, listView);
                                    String material = ((EDITTEXT_LISTVIEWITEM) listView.getAdapter().getItem(i)).getMaterial();

                                    if (material.equals(text)) {
                                        int qty = Integer.parseInt(((EDITTEXT_LISTVIEWITEM) listView.getAdapter().getItem(i)).getQuantity());
                                        qty++;
                                        String setQty = Integer.toString(qty);
                                        ((EDITTEXT_LISTVIEWITEM) listView.getAdapter().getItem(i)).setQuantity(setQty);
                                        listView.setAdapter(adapter);
                                        adapter.notifyDataSetChanged();
                                        insert.setText("");
                                        return true;
                                    }
                                }

                                adapter.addItem(text, Integer.toString(count));
                                adapter.notifyDataSetChanged();
                                insert.setText("");

                            }
                        }
                        setListViewHeightBasedOnChildren(listView);
                        break;

                }
                return true;
            }
        });
    }

    // ListView 갯수에 따른 크기조절
    public static void setListViewHeightBasedOnChildren(ListView listView) {
        ListAdapter listAdapter = listView.getAdapter();

        if (listAdapter == null) {
            // pre-condition
            return;
        }

        int totalHeight = 0;

        int desiredWidth = View.MeasureSpec.makeMeasureSpec(listView.getWidth(), View.MeasureSpec.AT_MOST);
        for (int i = 0; i < listAdapter.getCount(); i++) {
            View listItem = listAdapter.getView(i, null, listView);
            //listItem.measure(0, 0);
            listItem.measure(desiredWidth, View.MeasureSpec.UNSPECIFIED);
            totalHeight += listItem.getMeasuredHeight();
        }
        ViewGroup.LayoutParams params = listView.getLayoutParams();

        params.height = totalHeight;
        listView.setLayoutParams(params);

        listView.requestLayout();
    }


}
