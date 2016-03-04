package com.cdd.frgment;

import java.util.ArrayList;
import java.util.List;

import com.cdd.adapter.OrderMenuAdapter;
import com.cdd.bean.OrderMenu;
import com.cdd.chongdiandian.R;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

public class OrderFragment extends Fragment {
	View view;
    List<OrderMenu> list;
    GridView gridView;
    OrderMenuAdapter adapter;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		view = inflater.inflate(R.layout.order_fragment, null);
		initData();
		initView();
		return view;
	}

	private void initView() {
		// TODO Auto-generated method stub
		gridView = (GridView) view.findViewById(R.id.ordermenu_gridview);
		adapter = new OrderMenuAdapter(getActivity(), list);
		gridView.setAdapter(adapter);
	}

	private void initData() {
		// TODO Auto-generated method stub
		list = new ArrayList<OrderMenu>();
		OrderMenu orderMenu;
		orderMenu = new OrderMenu(R.drawable.u110, "待付款");
		list.add(orderMenu);
		orderMenu = new OrderMenu(R.drawable.u112, "待发货");
		list.add(orderMenu);
		orderMenu = new OrderMenu(R.drawable.u114, "待收货");
		list.add(orderMenu);
		orderMenu = new OrderMenu(R.drawable.u116, "待评价");
		list.add(orderMenu);
		orderMenu = new OrderMenu(R.drawable.u118, "退货/售后");
		list.add(orderMenu);
		orderMenu = new OrderMenu(R.drawable.u120, "帮助");
		list.add(orderMenu);
	}
}
