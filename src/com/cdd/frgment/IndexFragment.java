package com.cdd.frgment;

import com.cdd.chongdiandian.ConfirmOrderActivity;
import com.cdd.chongdiandian.GoodDetailActivity;
import com.cdd.chongdiandian.InfoPageOneActivity;
import com.cdd.chongdiandian.OneKeyBuyActivity;
import com.cdd.chongdiandian.R;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class IndexFragment extends Fragment implements OnClickListener {
	View view;
	TextView subsrcibe, oneKeyBuy;
	ImageView good1;
	LinearLayout time;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		view = inflater.inflate(R.layout.index_fragment, null);
		initView();
		return view;
	}

	private void initView() {
		// TODO Auto-generated method stub
		subsrcibe = (TextView) view.findViewById(R.id.subsrcibe);// 私宠定制btn
		oneKeyBuy = (TextView) view.findViewById(R.id.onekeybuy);// 一键购买btn
		good1 = (ImageView) view.findViewById(R.id.good1);// 物品链接
		time = (LinearLayout) view.findViewById(R.id.index_f_time);
		good1.setOnClickListener(this);
		subsrcibe.setOnClickListener(this);
		oneKeyBuy.setOnClickListener(this);
		time.setOnClickListener(this);
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		Intent intent = null;
		switch (arg0.getId()) {
		case R.id.subsrcibe:
			intent = new Intent(getActivity(), InfoPageOneActivity.class);
			break;
		case R.id.onekeybuy:
			intent = new Intent(getActivity(), OneKeyBuyActivity.class);
			break;
		case R.id.good1:
			intent = new Intent(getActivity(), GoodDetailActivity.class);
			break;
		case R.id.index_f_time:
			intent = new Intent(getActivity(),ConfirmOrderActivity.class);
			break;
		default:
			break;
		}
		startActivity(intent);
	}
}
