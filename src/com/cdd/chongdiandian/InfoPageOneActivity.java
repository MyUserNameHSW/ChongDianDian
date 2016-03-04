package com.cdd.chongdiandian;

import java.util.ArrayList;
import java.util.List;

import com.cdd.customview.ActionSheetDialog;
import com.cdd.customview.ActionSheetDialog.OnSheetItemClickListener;
import com.cdd.customview.ActionSheetDialog.SheetItemColor;
import com.cdd.utils.Config;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class InfoPageOneActivity extends Activity implements OnClickListener {
	private ImageView back;
	private TextView nextStep, leibie, pinzhong, age;
	private EditText otherInfo;
	private List<String> leibieList, ageList;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_info_page_one);
		initData();
		initView();
	}

	private void initData() {
		// TODO Auto-generated method stub
		leibieList = new ArrayList<String>();
		ageList = new ArrayList<String>();
		leibieList.add(Config.dog);
		leibieList.add(Config.cat);
		ageList.add(Config.age1);
		ageList.add(Config.age2);
		ageList.add(Config.age3);
	}

	private void initView() {
		// TODO Auto-generated method stub
		back = (ImageView) findViewById(R.id.aip_back);
		leibie = (TextView) findViewById(R.id.leibieChoose);
		pinzhong = (TextView) findViewById(R.id.pinzhongChoose);
		age = (TextView) findViewById(R.id.ageChoose);
		otherInfo = (EditText) findViewById(R.id.other_info);
		nextStep = (TextView) findViewById(R.id.aip_nextStep);
		back.setOnClickListener(this);
		leibie.setOnClickListener(this);
		pinzhong.setOnClickListener(this);
		age.setOnClickListener(this);
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
		case R.id.leibieChoose:
			showLeiBieDialog();
			break;
		case R.id.pinzhongChoose:

			break;
		case R.id.ageChoose:
			showAgeDialog();
			break;
		default:
			break;
		}
	}

	private void showAgeDialog() {
		// TODO Auto-generated method stub
		ActionSheetDialog dialog;
		if (ageList.size() > 0) {
			dialog = new ActionSheetDialog(InfoPageOneActivity.this).builder()
					.setTitle(Config.chooseAge).setCancelable(true)
					.setCanceledOnTouchOutside(true);
			for (int i = 0; i < ageList.size(); i++) {
				final int a = i;
				dialog.addSheetItem(ageList.get(a), SheetItemColor.Blue,
						new OnSheetItemClickListener() {

							@Override
							public void onClick(int which) {
								// TODO Auto-generated method stub
								age.setText(ageList.get(a));
							}
						});
			}
			dialog.show();
		}
	}

	private void showLeiBieDialog() {
		// TODO Auto-generated method stub
		ActionSheetDialog dialog;
		if (leibieList.size() > 0) {
			dialog = new ActionSheetDialog(InfoPageOneActivity.this).builder()
					.setTitle(Config.chooseLeiBie).setCancelable(true)
					.setCanceledOnTouchOutside(true);
			for (int i = 0; i < leibieList.size(); i++) {
				final int a = i;
				dialog.addSheetItem(leibieList.get(a), SheetItemColor.Blue,
						new OnSheetItemClickListener() {

							@Override
							public void onClick(int which) {
								// TODO Auto-generated method stub
								leibie.setText(leibieList.get(a));
							}
						});
			}
			dialog.show();
		}
	}
}
