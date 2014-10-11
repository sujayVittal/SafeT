package com.example.safet;

import android.support.v7.app.ActionBarActivity;
import android.telephony.SmsManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

public class Choice extends ActionBarActivity {
	Button cops,taxi,camera,plus,messaging;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_choice);
		cops = (Button) findViewById(R.id.button1);
		taxi = (Button)findViewById(R.id.button2);
		messaging = (Button)findViewById(R.id.Button01);
		plus = (Button)findViewById(R.id.button3);
		camera = (Button)findViewById(R.id.button4);
		camera.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
				startActivityForResult(intent, 0);
				Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND); 
				emailIntent.setType("application/image");
				String strEmail = null;
				emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL, new String[]{strEmail}); 
				emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT,"Test Subject"); 
				emailIntent.putExtra(android.content.Intent.EXTRA_TEXT, "From My App"); 
				emailIntent.putExtra(Intent.EXTRA_STREAM, Uri.parse("file:///mnt/sdcard/Myimage.jpeg"));
				startActivity(Intent.createChooser(emailIntent, "Send mail..."));
			}
		});
		messaging.setOnClickListener(new View.OnClickListener() {
			PhoneNumber n = new PhoneNumber();
			String number = n.ToNumber;
			String message = n.NameSel;
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(Intent.ACTION_VIEW);
		    	i.setType("vnd.android-dir/mms-sms");
		    	SmsManager smsManager = SmsManager.getDefault();
		    	smsManager.sendTextMessage("phoneNo", number, message, null, null);
			}
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.choice, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
