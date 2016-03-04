package com.cdd.adapter;

import java.util.List;

import com.cdd.bean.OrderMenu;
import com.cdd.chongdiandian.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class OrderMenuAdapter extends BaseAdapter {
	Context context;
	LayoutInflater mInflater;
	List<OrderMenu> list;

	public OrderMenuAdapter(Context context, List<OrderMenu> list) {
		super();
		this.context = context;
		this.list = list;
		mInflater = LayoutInflater.from(context);
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return list.size();
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return list.get(arg0);
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return arg0;
	}

	@Override
	public View getView(int arg0, View arg1, ViewGroup arg2) {
		// TODO Auto-generated method stub
		arg1 = mInflater.inflate(R.layout.ordermenu_item, null);
		ImageView imageView = (ImageView) arg1.findViewById(R.id.ordermenu_img);
		TextView textView = (TextView) arg1.findViewById(R.id.ordermenu_text);
		imageView.setImageResource(list.get(arg0).getPic());
		textView.setText(list.get(arg0).getName());
		return arg1;
	}

}
