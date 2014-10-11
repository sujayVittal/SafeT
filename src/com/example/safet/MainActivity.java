package com.example.safet;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ProgressBar;
//import android.widget.TextView;

public class MainActivity extends ActionBarActivity {
	private ProgressBar progressBar;
	private int progressStatus = 0;
	protected boolean _active = true;
	protected int _splashTime = 3000;
	
	//private TextView textView;
	private Handler handler = new Handler();

	@Override
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		progressBar = (ProgressBar)findViewById(R.id.progressBar1);
		new Thread(new Runnable() {
		     public void run() {
		        while (progressStatus < 100) {
		           progressStatus += 11;
		    // Update the progress bar and display the 
		                         //current value in the text view
		    handler.post(new Runnable() {
		    public void run() {
		       progressBar.setProgress(progressStatus);
		       //textView.setText(progressStatus+"/"+progressBar.getMax());
		    }
		        });
		    try {
		           // Sleep for 200 milliseconds. 
		                         //Just to display the progress slowly
		           Thread.sleep(100);
		        } catch (InterruptedException e) {
		           e.printStackTrace();
		        }
		    if (progressStatus >= 100){
	        	Intent i = new Intent(MainActivity.this, PhoneNumber.class);
	        	startActivity(i);
	        	break;
	        }
		     }
		        
		  }
		  }).start();
	//Thread logoTimer = new Thread();
	
	}
	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
	}
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
	}
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
	}
	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
	}
	protected void onDestroy() {
    	super.onDestroy();
    }

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
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
