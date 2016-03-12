package com.cdd.chongdiandian;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import com.cdd.customview.CustomTimePicDialog;
import com.cdd.customview.CustomTimePicDialog.ClickListenerInterface;
import com.cdd.customview.EditAlertDialog;

/**
 * @author HSW
 * 
 */
public class ChoosePayActivity extends Activity implements OnClickListener {
	RadioButton customPrice;
	ImageView back;
	TextView cycle, chooseAddress;
	TextView name, phone, address;
	View addView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_choose_pay);
		initView();
	}

	private void initView() {
		// TODO Auto-generated method stub
		back = (ImageView) findViewById(R.id.acp_back);
		addView = findViewById(R.id.acp_address);
		customPrice = (RadioButton) findViewById(R.id.custom_pay);
		chooseAddress = (TextView) findViewById(R.id.acp_chooseAddress);
		cycle = (TextView) findViewById(R.id.cycle);
		back.setOnClickListener(this);
		cycle.setOnClickListener(this);
		addView.setOnClickListener(this);
		customPrice.setOnClickListener(this);
		chooseAddress.setOnClickListener(this);
		name = (TextView) findViewById(R.id.acp_ali_name);
		phone = (TextView) findViewById(R.id.acp_ali_phone);
		address = (TextView) findViewById(R.id.acp_ali_address);
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		switch (arg0.getId()) {
		case R.id.acp_back:
			finish();
			break;
		case R.id.custom_pay:
			showEditDialog();
			break;
		case R.id.cycle:
			showPickerDialog();
			break;
		case R.id.acp_chooseAddress:
			Intent intent = new Intent(this, ChooseAddressActivity.class);
			startActivityForResult(intent, 101);
			break;
		case R.id.acp_address:
			Intent intent2 = new Intent(this, ChooseAddressActivity.class);
			startActivityForResult(intent2, 101);
			break;
		default:
			break;
		}
	}

	private void showPickerDialog() {
		// TODO Auto-generated method stub
		String values[] = new String[12];
		for (int i = 0; i < 12; i++) {
			values[i] = i + 1 + "个月";
		}
		final CustomTimePicDialog dialog = new CustomTimePicDialog(
				ChoosePayActivity.this, "选择时间", values);
		dialog.show();
		dialog.setClicklistener(new ClickListenerInterface() {

			@Override
			public void doConfirm() {
				// TODO Auto-generated method stub
				String text = dialog.getEndNum();
				if (text.length() == 0 || text.equals("")) {
					text = "1个月";
				}
				cycle.setText(text);
				dialog.dismiss();
			}

			@Override
			public void doCancel() {
				// TODO Auto-generated method stub
				dialog.dismiss();
			}
		});
	}

	/**
	 * 显示自定义价格输入弹框
	 */
	private void showEditDialog() {
		// TODO Auto-generated method stub
		final EditAlertDialog eDialog = new EditAlertDialog(
				ChoosePayActivity.this).builder().setEditText("输入价格")
				.setNegativeButton("取消", new OnClickListener() {

					@Override
					public void onClick(View arg0) {
						// TODO Auto-generated method stub

					}
				});
		eDialog.setPositiveButton("确定", new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				String text = eDialog.getResult();
				customPrice.setText(text);
				eDialog.dismiss();
			}
		});
		eDialog.show();
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		if (resultCode == RESULT_OK) {
			addView.setVisibility(View.VISIBLE);
			chooseAddress.setVisibility(View.GONE);
			name.setText(data.getStringExtra("name"));
			phone.setText(data.getStringExtra("phone"));
			address.setText(data.getStringExtra("address"));
		}
	}
}
