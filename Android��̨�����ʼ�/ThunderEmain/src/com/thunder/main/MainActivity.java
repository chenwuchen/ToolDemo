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

		send.setText("�������");
		userid.setText("489697862@qq.com"); // ��������û���
		password.setText("jinlei0801"); // ��������½����
//		from.setText("489697862@qq.com");// ���͵�����
		to.setText("jinlei0506@qq.com"); // �����ĸ��ʼ�ȥ

		subject.setText("���");
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
					mailInfo.setUserName(userid.getText().toString()); // ��������ַ
					mailInfo.setPassword(password.getText().toString());// ������������
					mailInfo.setFromAddress(userid.getText().toString()); // ���͵�����
					mailInfo.setToAddress(to.getText().toString()); // �����ĸ��ʼ�ȥ
					mailInfo.setSubject(subject.getText().toString()); // �ʼ�����
					mailInfo.setContent(body.getText().toString()); // �ʼ��ı�
					// �������Ҫ�������ʼ�
					SimpleMailSender sms = new SimpleMailSender();
					sms.sendTextMail(mailInfo);// ���������ʽ
					 //sms.sendHtmlMail(mailInfo);//����html��ʽ

				} catch (Exception e) {
					Log.e("==SendMail", e.getMessage(), e);
				}
			}
		});
	}
}

