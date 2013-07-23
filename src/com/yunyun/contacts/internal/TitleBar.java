package com.yunyun.contacts.internal;

import android.content.Context;
import android.view.View;

public interface TitleBar {
	
	public View createTitleBar(Context context);
	
	public boolean onCreatePanelMenu (com.actionbarsherlock.view.Menu menu);
	
}
