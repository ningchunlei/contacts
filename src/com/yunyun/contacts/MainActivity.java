package com.yunyun.contacts;

import com.actionbarsherlock.ActionBarSherlock.OnCreatePanelMenuListener;
import com.actionbarsherlock.view.MenuItem;
import com.yunyun.contacts.internal.BaseActivity;

import android.os.Bundle;
import android.view.Menu;

public class MainActivity extends BaseActivity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		current = 0;
		super.onCreate(savedInstanceState);
		setDisplayShowTitleEnabled(false);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		 return mSherlock.dispatchCreateOptionsMenu(menu);
	}

	

}
