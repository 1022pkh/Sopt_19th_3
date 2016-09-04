package com.semi.sopt_19th_3.upgrade;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.semi.sopt_19th_3.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by KH
 */
public class UpgradeAdapter extends BaseAdapter{
    /**
     * 이번 심화과정1
     * 필터기능을 사용해보는 것입니다.
     * 쉽게 생각해서....
     * 항목데이터를 하나의 객체(A)에 저장해둡니다
     * 그리고 검색창에 데이터를 입력할 때마다 항목 데이터가 저장된 객체(A)에서 찾아서
     * 찾은 객체만 따로 모아 객체(B)를 만드는 것이죠
     * 최종적으로는 따로 모은 객체(B)를 뿌려주는 것이죠
     *
     */


    ArrayList<ListViewItem> arraylist;
    LayoutInflater layoutInflater = null;
    List<ListViewItem> arSrc;

    //생성자
    public UpgradeAdapter(ArrayList<ListViewItem> itemDatas, Context ctx){
        /**
         * 여기서 arSrc은 검색한 데이터가 일치하는 항목만 넣어주는 객체입니다. (B)
         * 처음에는 입력한 데이터가 없기때문에, 일단 모든 데이터를 넣어줍니다
         * arraylist 경우에는 데이터 전체를 가지고있는 객체입니다. (A)
         */

        arSrc = itemDatas;

        this.arraylist = new ArrayList<ListViewItem>();
        this.arraylist.addAll(arSrc);

        layoutInflater = (LayoutInflater)ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return arSrc.size();
    }

    @Override
    public ListViewItem getItem(int position) {
        // TODO Auto-generated method stub
        return arSrc.get(position);
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }
    /**
     * ViewHolder Pattern을 사용
     * data-> listview에 뿌려주는 역할
     */

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder = new ViewHolder();

        if(convertView == null){
            convertView = layoutInflater.inflate(R.layout.list_item1,parent,false);

            viewHolder.TextView_Title = (TextView)convertView.findViewById(R.id.textView1);
            viewHolder.TextView_Description = (TextView)convertView.findViewById(R.id.textView2);
            viewHolder.img_item = (ImageView)convertView.findViewById(R.id.imageView1);

            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder)convertView.getTag();
        }

        ListViewItem itemData_temp = arSrc.get(position);

        viewHolder.TextView_Title.setText(itemData_temp.Title);
        viewHolder.TextView_Description.setText(itemData_temp.subTitle);
        viewHolder.img_item.setImageResource(itemData_temp.img);

        return convertView;
    }

    public class ViewHolder {
        TextView TextView_Title;
        TextView TextView_Description;
        ImageView img_item;
    }


    // Filter
    public void filter(String charText) {
        /**
         * 검색창에 입력한 데이터를 가져오는 것이죠
         * 밑에 toLowerCase()의 경우에는 소문자로 바꿔주는 함수죠
         * 대소문자 구분없이 검색하도록 넣어준 것입니다
         * 만약 대소문자 구분하여 검색하려면 toLowerCase()부분을 제거해주시면 됩니다!
         */
        charText = charText.toLowerCase(Locale.getDefault());

        //먼저 arSrc객체를 비워줍니다.
        arSrc.clear();

        //입력한 데이터가 없을 경우에는 모든 데이터항목을 출력해줍니다.
        if (charText.length() == 0) {
            arSrc.addAll(arraylist);
        }
        //입력한 데이터가 있을 경우에는 일치하는 항목들만 찾아 출력해줍니다.
        else
        {
            for (ListViewItem wp : arraylist)
            {
                if (wp.getTitle().toLowerCase(Locale.getDefault()).contains(charText))
                {
                    arSrc.add(wp);

                }
            }
        }

        notifyDataSetChanged();
    }

}
