package com.semi.sopt_19th_3.upgrade;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.ListView;

import com.semi.sopt_19th_3.R;

import java.util.ArrayList;
import java.util.Locale;

public class UpgradeList extends AppCompatActivity {

    private ArrayList<ListViewItem> itemDatas = null;

    private ListView listView1;
    private EditText searchEdit;
    UpgradeAdapter upgradeAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upgrade_list);


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
        upgradeAdapter = new UpgradeAdapter(itemDatas, getApplicationContext());
        listView1 = (ListView) findViewById(R.id.listView1);
        listView1.setAdapter(upgradeAdapter);


        searchEdit = (EditText)findViewById(R.id.searchEdit);

        // Capture Text in EditText
        searchEdit.addTextChangedListener(new TextWatcher() {

            @Override
            public void afterTextChanged(Editable arg0) {
                // TODO Auto-generated method stub
                String text = searchEdit.getText().toString().toLowerCase(Locale.getDefault());
                upgradeAdapter.filter(text);
            }

            @Override
            public void beforeTextChanged(CharSequence arg0, int arg1,
                                          int arg2, int arg3) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onTextChanged(CharSequence arg0, int arg1, int arg2,
                                      int arg3) {
                // TODO Auto-generated method stub
            }
        });

    }
}
