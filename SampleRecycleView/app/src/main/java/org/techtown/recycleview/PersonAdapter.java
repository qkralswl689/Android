package org.techtown.recycleview;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class PersonAdapter {

    static class ViewHolder extends RecyclerView.ViewHolder{

        TextView textView;
        TextView textView2;

        // 뷰홀더 생성자로 전달되는 뷰 객체 참조하기
        public ViewHolder(View itemView){
            super(itemView);

            // 뷰 객체에 들어 있는 텍스트뷰 참조하기
            textView = itemView.findViewById(R.id.textView);
            textView2 = itemView.findViewById(R.id.textView2)
        }

        public void setItem(Person item){
            textView.setText(item.getName());
            textView2.setText(item.getMobile());
        }
    }
}
