package com.semi.sopt_19th_3.custom;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.semi.sopt_19th_3.R;

import java.util.ArrayList;

/**
 * Created by woody on 2016-04-23.
 */
public class CustomAdapter extends BaseAdapter{

    // 아무것도 없을 때 빨간 줄
    // 기본적으로 무조건 적어줘야 하는 Override 메소드가 있기 때문 !!

    private ArrayList<ListViewItem> itemDatas = null;
    private LayoutInflater layoutInflater = null;

    //생성자
    public CustomAdapter(ArrayList<ListViewItem> itemDatas, Context ctx){
        this.itemDatas = itemDatas;
        layoutInflater = (LayoutInflater)ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public void setItemDatas(ArrayList<ListViewItem> itemDatas){
        this.itemDatas = itemDatas;
        this.notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return itemDatas != null ? itemDatas.size():0;
    }

    @Override
    public Object getItem(int position) {
        return (itemDatas != null && ( position>=0 && position < itemDatas.size()) ? itemDatas.get(position):null);
    }

    @Override
    public long getItemId(int position) {
        return (itemDatas != null && ( position>=0 && position < itemDatas.size()) ? position:0);
    }

    /**
     * ViewHolder Pattern을 사용하지않은 경우
     * data-> listview에 뿌려주는 역할
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null){
            convertView = layoutInflater.inflate(R.layout.list_item1,parent,false);
        }

        ImageView iconImageView = (ImageView) convertView.findViewById(R.id.imageView1) ;
        TextView titleTextView = (TextView) convertView.findViewById(R.id.textView1) ;
        TextView descTextView = (TextView) convertView.findViewById(R.id.textView2) ;

        ListViewItem itemData_temp = itemDatas.get(position);

        iconImageView.setImageResource(itemData_temp.img);
        titleTextView.setText(itemData_temp.Title);
        descTextView.setText(itemData_temp.subTitle);

        return convertView;
    }


    /**
     * ViewHolder Pattern을 이용할 경우
     */
/*
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

        ListViewItem itemData_temp = itemDatas.get(position);

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
*/
}
