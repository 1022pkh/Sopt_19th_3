package com.semi.sopt_19th_3.custom;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.semi.sopt_19th_3.R;

import java.util.ArrayList;

public class CustomList extends AppCompatActivity {

    private ArrayList<ListViewItem> itemDatas = null;

    ListView listView1;
    CustomAdapter customAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_list_view);

        itemDatas = new ArrayList<ListViewItem>();
        // itemDatas 들어갈 자료를 추가

        for(int i=0;i<15;i++){
            ListViewItem listViewItem = new ListViewItem();

            if(i%3==0)
                listViewItem.img = R.drawable.img1;
            else if(i%3==1)
                listViewItem.img = R.drawable.img2;
            else if(i%3==2)
                listViewItem.img = R.drawable.img3;

            listViewItem.Title = (i+1)+"번 Title";
            listViewItem.subTitle = (i+1)+"번 subTitle";

            itemDatas.add(0,listViewItem);
        }

        // 들어갈 자료를 ListView에 지정
        customAdapter = new CustomAdapter(itemDatas,getApplicationContext());
        listView1 = (ListView) findViewById(R.id.listView1);
        listView1.setAdapter(customAdapter);
    }
}
