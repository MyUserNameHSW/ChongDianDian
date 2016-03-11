package com.cdd.chongdiandian;

import java.util.ArrayList;
import java.util.List;

import com.cdd.customview.ActionSheetDialog;
import com.cdd.customview.ActionSheetDialog.OnSheetItemClickListener;
import com.cdd.customview.ActionSheetDialog.SheetItemColor;
import com.cdd.utils.Cdd_Method;
import com.cdd.utils.Config;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class OneKeyBuyActivity extends Activity implements OnClickListener {
	private ImageView back;
	private TextView startP, leibie, pinzhong, age;
	private List<String> leibieList, ageList;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_one_key_buy);
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
		back = (ImageView) findViewById(R.id.aok_back);
		leibie = (TextView) findViewById(R.id.key_leibie);
		pinzhong = (TextView) findViewById(R.id.key_pinzhong);
		age = (TextView) findViewById(R.id.key_age);
		startP = (TextView) findViewById(R.id.aok_nextStep);
		startP.setOnClickListener(this);
		back.setOnClickListener(this);
		leibie.setOnClickListener(this);
		pinzhong.setOnClickListener(this);
		age.setOnClickListener(this);
		back.setOnClickListener(this);
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		switch (arg0.getId()) {
		case R.id.aok_back:
			finish();
			break;
		case R.id.key_leibie:
			showLeiBieDialog();
			break;
		case R.id.key_pinzhong:
			String edit1 = leibie.getText().toString();
			if (edit1.equals("") || edit1.length() == 0) {
				Cdd_Method.showToast(this, "请先选择类别");
				return;
			} else {
				Intent intent2 = new Intent(this, PetListSearchActivity.class);
				intent2.putExtra("leibie", getLeiBie(edit1));
				startActivityForResult(intent2, 111);
			}
			break;
		case R.id.key_age:
			showAgeDialog();
			break;
		case R.id.aok_nextStep:
			Intent intent = new Intent(this, PiPeiListActivity.class);
			startActivity(intent);
			break;
		default:
			break;
		}
	}

	private int getLeiBie(String leibie) {
		if (leibie.equals(Config.dog)) {
			return R.array.dog;
		} else {
			return R.array.cat;
		}
	}

	private void showAgeDialog() {
		// TODO Auto-generated method stub
		ActionSheetDialog dialog;
		if (ageList.size() > 0) {
			dialog = new ActionSheetDialog(OneKeyBuyActivity.this).builder()
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
			dialog = new ActionSheetDialog(OneKeyBuyActivity.this).builder()
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
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		if (resultCode == RESULT_OK) {
			pinzhong.setText(data.getStringExtra("pinzhong"));
		}
	}
}
