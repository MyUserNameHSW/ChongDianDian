package com.cdd.chongdiandian;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

public class InfoPageOneActivity extends Activity implements OnClickListener {
	private ImageView back;
	private TextView nextStep, leibie, pinzhong, age, otherInfo;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_info_page_one);
		initView();
	}

	private void initView() {
		// TODO Auto-generated method stub
		back = (ImageView) findViewById(R.id.aip_back);
		nextStep = (TextView) findViewById(R.id.aip_nextStep);
		back.setOnClickListener(this);
		nextStep.setOnClickListener(this);
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		switch (arg0.getId()) {
		case R.id.aip_back:
			finish();
			break;
		case R.id.aip_nextStep:
			Intent intent = new Intent(this, ChoosePayActivity.class);
			startActivity(intent);
			break;
		default:
			break;
		}
	}

}
