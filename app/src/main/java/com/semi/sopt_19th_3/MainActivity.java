package com.semi.sopt_19th_3;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.semi.sopt_19th_3.basic.BasicListView;
import com.semi.sopt_19th_3.custom.CustomList;
import com.semi.sopt_19th_3.upgrade.UpgradeList;
import com.semi.sopt_19th_3.upgrade2.UpgradeList2;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button basic;
    private Button custom;
    private Button upgrade;
    private Button upgrade2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /**
         * 변수 초기화
         */
        basic = (Button)findViewById(R.id.basicList);
        custom = (Button)findViewById(R.id.customList);
        upgrade = (Button)findViewById(R.id.upgradeList);
        upgrade2 = (Button)findViewById(R.id.upgradeList2);
        /**
         * 1차,2차 세미나때 사용한 버튼 클릭이벤트 적용방법과는 조금 다른 방법입니다.
         * 여러개의 버튼이 존재할 경우
         * 매번 각 버튼에 대한 이벤트를 주는 것은 비효율적입니다.
         * 나중에 유지보수할 때, 필요한 부분을 찾을 때 비효율적이죠
         * 이번 방법은 하나의 클릭 이벤트함수에서 각 버튼에 대한 이벤트를 관리해주는 방법입니다.
         */
        basic.setOnClickListener(this);
        custom.setOnClickListener(this);
        upgrade.setOnClickListener(this);
        upgrade2.setOnClickListener(this);

    }

    @Override
    public void onClick(View v){
        int id = v.getId();
        Intent intent;
        switch(id){
            case R.id.basicList:
                intent = new Intent(getApplicationContext(), BasicListView.class);
                startActivity(intent);
                break;

            case R.id.customList:
                intent = new Intent(getApplicationContext(), CustomList.class);
                startActivity(intent);
                break;

            case R.id.upgradeList:
                intent = new Intent(getApplicationContext(), UpgradeList.class);
                startActivity(intent);
                break;

            case R.id.upgradeList2:
                intent = new Intent(getApplicationContext(), UpgradeList2.class);
                startActivity(intent);
                break;

        }
    }
}
