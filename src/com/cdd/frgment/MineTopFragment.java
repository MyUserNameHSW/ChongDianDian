package com.cdd.frgment;

import com.cdd.chongdiandian.R;
import com.cdd.chongdiandian.SetActivity;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;

public class MineTopFragment extends Fragment {
	View view;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		view = inflater.inflate(R.layout.mine_top_fragment, null);
		ImageView back = (ImageView) view.findViewById(R.id.to_set);
		back.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(getActivity(), SetActivity.class);
				startActivity(intent);
			}
		});
		return view;
	}
}
