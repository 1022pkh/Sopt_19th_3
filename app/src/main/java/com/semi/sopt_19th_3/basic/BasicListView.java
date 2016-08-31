package com.semi.sopt_19th_3.basic;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.semi.sopt_19th_3.R;

import java.util.ArrayList;

public class BasicListView extends AppCompatActivity {

    //순서대로 정의된 배열을 리스트 뷰를 이용하여 보여주고자 함.
    //2. 사용자 데이터 정의
    ArrayList<String> mDatas = new ArrayList<String>();
    ListView listview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic_list_view);

        // 3. Adapter 생성 후 ListView에 지정
        //ListView가 보여줄 뷰를 만들어내는 Adapter 객체 생성
        //ArrayAdapter : 문자열 데이터들을 적절한 iew로 1:1로 만들어서 List형태로 ListView에 제공하는 객체
        //첫번째 파라미터 : Context객체 ->MainActivity가 Context를 상속했기 때문에 this로 제공 가능
        //두번째 파라미터 : 문자열 데이터를 보여줄 뷰. ListView에 나열되는 하나의 아이템 단위의 뷰 모양
        //세번째 파라미터 : adapter가 뷰로 만들어줄 대량의 데이터들
        //본 예제에서는 문자열만 하나씩 보여주면 되기 때문에 두번째 파라미터의 뷰 모먕은 Android 시스템에서 제공하는
        //기본 Layout xml 파일을 사용함.
        mDatas.add("List1");
        mDatas.add("List2");
        mDatas.add("List3");
        mDatas.add("List4");
        mDatas.add("List5");
        mDatas.add("List6");
        mDatas.add("List7");
        mDatas.add("List8");
        mDatas.add("List9");
        mDatas.add("List10");
        mDatas.add("List11");
        mDatas.add("List12");
        mDatas.add("List13");

        ArrayAdapter adapter = new ArrayAdapter(getApplicationContext(),android.R.layout.simple_list_item_1,mDatas);
        listview = (ListView)findViewById(R.id.basicListview);
        listview.setAdapter(adapter);

        //android.R.layout.simple_list_item_1 안드로이드에서 제공하는 xml를 사용
        //원하는 글씨 스타일을 적용 할 수 가 없다 !! , 한 개의 문자열이 아닌 여려개 문자열과 그림을 넣고 싶다 !!
        //좀 더 아름다운 UI 꾸미기를 하기 위해서 => Custom ListView를 구현

        // 4. ListView 클릭 이벤트 처리
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), position+"번 리스트가 클릭 되었습니다.",Toast.LENGTH_SHORT).show();
            }
        });

    }
}
