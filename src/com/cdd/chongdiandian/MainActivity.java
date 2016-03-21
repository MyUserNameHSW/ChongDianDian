package com.cdd.chongdiandian;

import com.cdd.frgment.IndexFragment;
import com.cdd.frgment.IndexTopFragment;
import com.cdd.frgment.MineFragment;
import com.cdd.frgment.MineTopFragment;
import com.cdd.frgment.OrderFragment;
import com.cdd.frgment.OrderTopFragment;

import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.graphics.Color;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

@SuppressLint("ResourceAsColor")
public class MainActivity extends Activity implements OnClickListener {
	LinearLayout indexLiner, orderLiner, mineLiner;
	ImageView indexImageView, orderImageView, mineImageView;
	TextView indexTextView, orderTextView, mineTextView;
	FragmentManager manager;
	FragmentTransaction transaction;
	private int mBackKeyPressedTimes = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);
		initBottomData();
		initTopData();
		initBottomView();
	}

	private void initBottomView() {
		// TODO Auto-generated method stub
		indexLiner = (LinearLayout) findViewById(R.id.index_logo);
		orderLiner = (LinearLayout) findViewById(R.id.order_logo);
		mineLiner = (LinearLayout) findViewById(R.id.mine_logo);
		indexImageView = (ImageView) findViewById(R.id.index_logo_img);
		orderImageView = (ImageView) findViewById(R.id.order_logo_img);
		mineImageView = (ImageView) findViewById(R.id.mine_logo_img);
		indexTextView = (TextView) findViewById(R.id.index_logo_text);
		orderTextView = (TextView) findViewById(R.id.order_logo_text);
		mineTextView = (TextView) findViewById(R.id.mine_logo_text);
		reset();
		setBottomImageView(indexImageView, R.drawable.index_logo_check);
		setBottomTextColor(indexTextView, R.color.themeColor);
		indexLiner.setOnClickListener(this);
		orderLiner.setOnClickListener(this);
		mineLiner.setOnClickListener(this);
	}

	private void initBottomData() {
		// TODO Auto-generated method stub
		manager = getFragmentManager();
		transaction = manager.beginTransaction();
		IndexFragment fragment = new IndexFragment();
		transaction.replace(R.id.main_content, fragment);
		transaction.commit();
	}

	private void initTopData() {
		// TODO Auto-generated method stub
		manager = getFragmentManager();
		transaction = manager.beginTransaction();
		IndexTopFragment fragment = new IndexTopFragment();
		transaction.replace(R.id.top_view, fragment);
		transaction.commit();
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		transaction = manager.beginTransaction();
		switch (arg0.getId()) {
		case R.id.index_logo:
			replaceFragment(transaction, 1);
			replaceTopFragment(transaction, 1);
			reset();
			setBottomImageView(indexImageView, R.drawable.index_logo_check);
			setBottomTextColor(indexTextView, R.color.themeColor);
			break;
		case R.id.order_logo:
			replaceFragment(transaction, 2);
			replaceTopFragment(transaction, 2);
			reset();
			setBottomImageView(orderImageView, R.drawable.order_logo_check);
			setBottomTextColor(orderTextView, R.color.themeColor);
			break;
		case R.id.mine_logo:
			replaceFragment(transaction, 3);
			replaceTopFragment(transaction, 3);
			reset();
			setBottomImageView(mineImageView, R.drawable.mine_logo_check);
			setBottomTextColor(mineTextView, R.color.themeColor);
			break;
		default:
			break;
		}
		transaction.commit();
	}

	private void replaceFragment(FragmentTransaction transaction, int flag) {
		Fragment fragment = null;
		switch (flag) {
		case 1:
			fragment = new IndexFragment();
			break;
		case 2:
			fragment = new OrderFragment();
			break;
		case 3:
			fragment = new MineFragment();
			break;
		default:
			break;
		}
		transaction.replace(R.id.main_content, fragment);
	}

	private void replaceTopFragment(FragmentTransaction transaction, int flag) {
		Fragment fragment = null;
		switch (flag) {
		case 1:
			fragment = new IndexTopFragment();
			break;
		case 2:
			fragment = new OrderTopFragment();
			break;
		case 3:
			fragment = new MineTopFragment();
			break;
		default:
			break;
		}
		transaction.replace(R.id.top_view, fragment);
	}

	private void reset() {
		setBottomImageView(indexImageView, R.drawable.index_logo_nocheck);
		setBottomImageView(orderImageView, R.drawable.order_logo_nocheck);
		setBottomImageView(mineImageView, R.drawable.mine_logo_nocheck);
		setBottomTextColor(indexTextView, R.color.blackTextColor);
		setBottomTextColor(orderTextView, R.color.blackTextColor);
		setBottomTextColor(mineTextView, R.color.blackTextColor);
	}

	private void setBottomImageView(ImageView imageView, int drawable) {
		imageView.setImageResource(drawable);
	}

	private void setBottomTextColor(TextView textView, int color) {
		textView.setTextColor(getApplicationContext().getResources().getColor(
				color));
	}

	@Override
	public void onBackPressed() {
		if (mBackKeyPressedTimes == 0) {
			Toast.makeText(this, "再按一次退出程序 ", Toast.LENGTH_SHORT).show();
			mBackKeyPressedTimes = 1;
			new Thread() {
				@Override
				public void run() {
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					} finally {
						mBackKeyPressedTimes = 0;
					}
				}
			}.start();
			return;
		} else {
			finish();
		}
		super.onBackPressed();
	}
}
