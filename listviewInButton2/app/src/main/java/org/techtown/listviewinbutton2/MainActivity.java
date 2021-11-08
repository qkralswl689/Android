package org.techtown.listviewinbutton2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private ListView m_oListView = null;

 /*  ① 각 아이템 마다 setTag로 position을 등록 합니다.

    ② 선택버튼 이벤트를 MainActivity 로 발생되도록 합니다.

     ③ 이벤트 발생 시 getParent 로 선택 버튼 부모를 얻어옵니다. 즉, 아이템 위젯이 얻어와 지겠죠..그리고 Tag를 읽어오면 됩니다.*/



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 데이터 생성 ============================
        String[] strDate = {"2017-01-03", "1965-02-23", "2016-04-13", "2010-01-01", "2017-06-20",
                "2012-07-08", "1980-04-14", "2016-09-26", "2014-10-11", "2010-12-24"};
        int nDatCnt = 0;

        ArrayList<ItemData> oData = new ArrayList<>();
        for (int i = 0; i < 1000; ++i)
        {
            ItemData oItem = new ItemData();
            oItem.strTitle = "데이터 " + (i + 1);
            oItem.strDate = strDate[nDatCnt++];
            oItem.onClickListener = this;
            oData.add(oItem);
            if(nDatCnt >= strDate.length) nDatCnt = 0;
        }


        // ListView 생성 ===============================
        m_oListView = (ListView)findViewById(R.id.listView);
        ListAdapter oAdapter = new ListAdapter(oData);
        m_oListView.setAdapter(oAdapter);
    }

    @Override
    public void onClick(View v) {
        View oParentView = (View)v.getParent();
        TextView oTextTitle = (TextView) oParentView.findViewById(R.id.textTitle);
        String position = (String) oParentView.getTag();

        AlertDialog.Builder oDialog = new AlertDialog.Builder(this,
                android.R.style.Theme_DeviceDefault_Light_Dialog);

        String strMsg = "선택한 아이템의 position 은 " + position + " 입니다.\nTitle 텍스트 :" + oTextTitle.getText();
        oDialog.setMessage(strMsg)
                .setPositiveButton("확인", null)
                .setCancelable(false) // 백버튼으로 팝업창이 닫히지 않도록 한다.
                .show();
    }
}