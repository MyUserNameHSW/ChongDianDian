package com.cdd.frgment;

import com.cdd.chongdiandian.LoginActivity;
import com.cdd.chongdiandian.R;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

public class MineFragment extends Fragment implements OnClickListener {
	View view;
	RelativeLayout rel;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		view = inflater.inflate(R.layout.mine_fragment, null);
		initView();
		return view;
	}

	private void initView() {
		// TODO Auto-generated method stub
		rel = (RelativeLayout) view.findViewById(R.id.to_info);
		rel.setOnClickListener(this);
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		Intent intent;
		switch (arg0.getId()) {
		case R.id.to_info:
			intent = new Intent(getActivity(), LoginActivity.class);
			startActivity(intent);
			break;

		default:
			break;
		}
	}
}
