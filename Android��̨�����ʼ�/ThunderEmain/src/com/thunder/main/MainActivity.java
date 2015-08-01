package com.thunder.main;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {
	private Button send;
	private EditText userid;
	private EditText password;
	private EditText from;
	private EditText to;
	private EditText subject;
	private EditText body;


	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		send = (Button) findViewById(R.id.send);
		userid = (EditText) findViewById(R.id.userid);
		password = (EditText) findViewById(R.id.password);
//		from = (EditText) findViewById(R.id.from);
		to = (EditText) findViewById(R.id.to);
		subject = (EditText) findViewById(R.id.subject);
		body = (EditText) findViewById(R.id.body);

		send.setText("点击发送");
		userid.setText("489697862@qq.com"); // 你的邮箱用户名
		password.setText("jinlei0801"); // 你的邮箱登陆密码
//		from.setText("489697862@qq.com");// 发送的邮箱
		to.setText("jinlei0506@qq.com"); // 发到哪个邮件去

		subject.setText("你好");
		body.setText("OK......");

		send.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				try {
					MailSenderInfo mailInfo = new MailSenderInfo();
					mailInfo.setMailServerHost("smtp.qq.com");
					mailInfo.setMailServerPort("25");
					mailInfo.setValidate(true);
					mailInfo.setUserName(userid.getText().toString()); // 你的邮箱地址
					mailInfo.setPassword(password.getText().toString());// 您的邮箱密码
					mailInfo.setFromAddress(userid.getText().toString()); // 发送的邮箱
					mailInfo.setToAddress(to.getText().toString()); // 发到哪个邮件去
					mailInfo.setSubject(subject.getText().toString()); // 邮件主题
					mailInfo.setContent(body.getText().toString()); // 邮件文本
					// 这个类主要来发送邮件
					SimpleMailSender sms = new SimpleMailSender();
					sms.sendTextMail(mailInfo);// 发送文体格式
					 //sms.sendHtmlMail(mailInfo);//发送html格式

				} catch (Exception e) {
					Log.e("==SendMail", e.getMessage(), e);
				}
			}
		});
	}
}

