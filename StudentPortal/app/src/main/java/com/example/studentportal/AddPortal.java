package com.example.studentportal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddPortal extends AppCompatActivity {
	
	public static final String url = "url";
	public static final String title = "title";
	
	EditText mEditURL;
	EditText mEditTitle;
	Button mButton;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add_portal);
		Toolbar toolbar = findViewById(R.id.toolbar);
		setSupportActionBar(toolbar);
		
		mEditURL = findViewById(R.id.editTextURL);
		mEditTitle = findViewById(R.id.editTextTitle);
		mButton = findViewById(R.id.AddPortalButton);
		
		
		mButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				String titel = mEditTitle.getText().toString();
				String urslie = mEditURL.getText().toString();
				
				final Portal newPortal = new Portal(titel, urslie);
				Intent data = new Intent();
				data.putExtra(MainActivity.key, newPortal);
				setResult(Activity.RESULT_OK, data);
				finish();
			}
		});
		
	}
}
