package com.cdd.frgment;

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
import android.widget.TextView;

public class IndexFragment extends Fragment implements OnClickListener {
	View view;
    TextView subsrcibe,oneKeyBuy;
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
		subsrcibe = (TextView) view.findViewById(R.id.subsrcibe);
		oneKeyBuy = (TextView) view.findViewById(R.id.onekeybuy);
		subsrcibe.setOnClickListener(this);
		oneKeyBuy.setOnClickListener(this);
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		Intent intent = null;
		switch (arg0.getId()) {
		case R.id.subsrcibe:
			intent = new Intent(getActivity(),InfoPageOneActivity.class);
			break;
		case R.id.onekeybuy:
			intent = new Intent(getActivity(),OneKeyBuyActivity.class);
			break;
		default:
			break;
		}
		startActivity(intent);
	}
}
