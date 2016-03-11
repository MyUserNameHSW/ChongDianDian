package com.cdd.frgment;

import com.cdd.chongdiandian.AboutUsActivity;
import com.cdd.chongdiandian.AddressMangerActivity;
import com.cdd.chongdiandian.DiscountActivity;
import com.cdd.chongdiandian.FeedbackActivity;
import com.cdd.chongdiandian.LoginActivity;
import com.cdd.chongdiandian.MessageActivity;
import com.cdd.chongdiandian.R;
import com.cdd.chongdiandian.WalletActivity;

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
	RelativeLayout rel, wallet, discount, message, address, aboutUs, feedback;

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
		wallet = (RelativeLayout) view.findViewById(R.id.mine_text1);
		discount = (RelativeLayout) view.findViewById(R.id.mine_text2);
		message = (RelativeLayout) view.findViewById(R.id.mine_text3);
		address = (RelativeLayout) view.findViewById(R.id.mine_text4);
		aboutUs = (RelativeLayout) view.findViewById(R.id.mine_text5);
		feedback = (RelativeLayout) view.findViewById(R.id.mine_text6);
		rel.setOnClickListener(this);
		wallet.setOnClickListener(this);
		discount.setOnClickListener(this);
		message.setOnClickListener(this);
		address.setOnClickListener(this);
		aboutUs.setOnClickListener(this);
		feedback.setOnClickListener(this);
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		Intent intent = null;
		switch (arg0.getId()) {
		case R.id.to_info:
			intent = new Intent(getActivity(), LoginActivity.class);
			break;
		case R.id.mine_text1:
			intent = new Intent(getActivity(), WalletActivity.class);
			break;
		case R.id.mine_text2:
			intent = new Intent(getActivity(), DiscountActivity.class);
			break;
		case R.id.mine_text3:
			intent = new Intent(getActivity(), MessageActivity.class);
			break;
		case R.id.mine_text4:
			intent = new Intent(getActivity(), AddressMangerActivity.class);
			break;
		case R.id.mine_text5:
			intent = new Intent(getActivity(), AboutUsActivity.class);
			break;
		case R.id.mine_text6:
			intent = new Intent(getActivity(), FeedbackActivity.class);
			break;
		default:
			break;
		}
		startActivity(intent);
	}
}
