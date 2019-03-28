package com.example.studentportal;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebViewClient;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements RecyclerView.OnItemTouchListener {
	
	public static final String key = "key";
	public static final int REQUESTCODE = 1234;
	
	private RecyclerView mRecyclerView;
	private List<Portal> mPortalList;
	private PortalAdapter mAdapter;
	private GestureDetector mGestureDetector;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Toolbar toolbar = findViewById(R.id.toolbar);
		setSupportActionBar(toolbar);
		
		mRecyclerView = findViewById(R.id.recyclerView);
		mPortalList = new ArrayList<>();
		
		mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
		
		
		
		FloatingActionButton fab = findViewById(R.id.fab);
		fab.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Intent intent = new Intent(MainActivity.this, AddPortal.class);
				startActivityForResult(intent, REQUESTCODE);
			}
		});
		
		mGestureDetector = new GestureDetector(this, new GestureDetector.SimpleOnGestureListener() {
			@Override
			public boolean onSingleTapUp(MotionEvent e) {
				return true;
			}
		});
		
		mRecyclerView.addOnItemTouchListener(this);
		
	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
		if (requestCode == REQUESTCODE) {
			if (resultCode == RESULT_OK) {
				Portal newPortal = data.getParcelableExtra(MainActivity.key);
				mPortalList.add(newPortal);
				updateUI();
			}
		}
	}
	
	private void updateUI() {
		if (mAdapter == null) {
			mAdapter = new PortalAdapter(mPortalList);
			mRecyclerView.setAdapter(mAdapter);
		} else {
			mAdapter.notifyDataSetChanged();
		}
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu_main, menu);
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		
		//noinspection SimplifiableIfStatement
		if (id == R.id.action_settings) {
			return true;
		}
		
		return super.onOptionsItemSelected(item);
	}
	
	@Override
	public boolean onInterceptTouchEvent(@NonNull RecyclerView recyclerView, @NonNull MotionEvent motionEvent) {
		View child = recyclerView.findChildViewUnder(motionEvent.getX(), motionEvent.getY());
		int mAdapterPosition = recyclerView.getChildAdapterPosition(child);
		if (child != null && mGestureDetector.onTouchEvent(motionEvent)) {
			Intent intent = new Intent(MainActivity.this, WebViewAcitivity.class);
			intent.putExtra(key, mPortalList.get(mAdapterPosition));
			startActivityForResult(intent, REQUESTCODE);
		}
		return false;
	}
	
	@Override
	public void onTouchEvent(@NonNull RecyclerView recyclerView, @NonNull MotionEvent motionEvent) {
		
	}
	
	@Override
	public void onRequestDisallowInterceptTouchEvent(boolean b) {
		
	}
}
