package com.example.getphoneinfo;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

/**
 * 主界面
 * 
 * @author zihao
 * 
 */
public class MainActivity extends Activity implements OnClickListener {

	private Button showBtn;
	private TextView mTextView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initView();
	}

	/**
	 * 初始化视图
	 */
	private void initView() {
		mTextView = (TextView) findViewById(R.id.phone_text);
		showBtn = (Button) findViewById(R.id.get_btn);
		showBtn.setOnClickListener(this);
	}

	/**
	 * 获取手机信息
	 * 
	 * @return
	 */
	@SuppressWarnings("deprecation")
	private String getPhoneInfo() {
		String phoneInfo = "产品名称: " + android.os.Build.PRODUCT;
		phoneInfo += "\nCPU型号: " + android.os.Build.CPU_ABI;
		phoneInfo += "\n标签: " + android.os.Build.TAGS;
		phoneInfo += "\n手机型号: " + android.os.Build.MODEL;
		phoneInfo += "\nSDK版本: " + android.os.Build.VERSION.SDK;
		phoneInfo += "\n系统版本: " + android.os.Build.VERSION.RELEASE;
		phoneInfo += "\n设备驱动: " + android.os.Build.DEVICE;
		phoneInfo += "\n显示: " + android.os.Build.DISPLAY;
		phoneInfo += "\n品牌: " + android.os.Build.BRAND;
		phoneInfo += "\n主板: " + android.os.Build.BOARD;
		phoneInfo += "\n指纹: " + android.os.Build.FINGERPRINT;
		phoneInfo += "\nID: " + android.os.Build.ID;
		phoneInfo += "\n制造商: " + android.os.Build.MANUFACTURER;
		phoneInfo += "\n用户组: " + android.os.Build.USER;

		return phoneInfo;
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.get_btn:
			mTextView.setText(getPhoneInfo());
			break;
		}
	}
}