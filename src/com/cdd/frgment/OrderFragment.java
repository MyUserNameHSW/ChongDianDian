package com.cdd.frgment;

import java.util.ArrayList;
import java.util.List;

import com.cdd.adapter.OrderMenuAdapter;
import com.cdd.bean.OrderMenu;
import com.cdd.chongdiandian.AllOrderActivity;
import com.cdd.chongdiandian.AssessingActivity;
import com.cdd.chongdiandian.ConfirmOrderActivity;
import com.cdd.chongdiandian.CustomerBackActivity;
import com.cdd.chongdiandian.DealOrderActivity;
import com.cdd.chongdiandian.HelpActivity;
import com.cdd.chongdiandian.NotPayActivity;
import com.cdd.chongdiandian.R;
import com.cdd.chongdiandian.ReceiptingActivity;
import com.cdd.chongdiandian.ShippingActivity;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

public class OrderFragment extends Fragment implements OnClickListener {
	View view;
	List<OrderMenu> list;
	TextView pei, confirm, allOrder;
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
		allOrder = (TextView) view.findViewById(R.id.all_orders);
		pei = (TextView) view.findViewById(R.id.peicanzhong);
		confirm = (TextView) view.findViewById(R.id.daiquerening);
		pei.setOnClickListener(this);
		allOrder.setOnClickListener(this);
		confirm.setOnClickListener(this);
		gridView = (GridView) view.findViewById(R.id.ordermenu_gridview);
		adapter = new OrderMenuAdapter(getActivity(), list);
		gridView.setAdapter(adapter);
		gridView.setOnItemClickListener(new OnItemClickListener() {

			private Intent intent;

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
				switch (arg2) {
				case 0:
					intent = new Intent(getActivity(), NotPayActivity.class);
					break;
				case 1:
					intent = new Intent(getActivity(), ShippingActivity.class);
					break;
				case 2:
					intent = new Intent(getActivity(), ReceiptingActivity.class);
					break;
				case 3:
					intent = new Intent(getActivity(), AssessingActivity.class);
					break;
				case 4:
					intent = new Intent(getActivity(),
							CustomerBackActivity.class);
					break;
				case 5:
					intent = new Intent(getActivity(), HelpActivity.class);
					break;
				default:
					break;
				}
				startActivity(intent);
			}

		});
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

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		Intent intent = null;
		switch (arg0.getId()) {
		case R.id.peicanzhong:
			intent = new Intent(getActivity(), DealOrderActivity.class);
			break;
		case R.id.daiquerening:
			intent = new Intent(getActivity(), ConfirmOrderActivity.class);
			break;
		case R.id.all_orders:
			intent = new Intent(getActivity(), AllOrderActivity.class);
			break;
		default:
			break;
		}
		startActivity(intent);
	}
}
