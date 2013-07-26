package com.yunyun.contacts;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;
import com.yunyun.contacts.internal.TitleBar;

public class CardFragment extends Fragment implements TitleBar{
	
	 @Override
     public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

     }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
    	View v = inflater.inflate(R.layout.cardfragment, container, false);
    	return v;
    }
	
	@Override
	public View createTitleBar(Context context) {
		// TODO Auto-generated method stub
		TextView v = new TextView(context);
	    v.setGravity(Gravity.CENTER);
		v.setText(R.string.cardtitle);
		return v;
	}

	@Override
	public boolean onCreatePanelMenu(Menu menu) {
		// TODO Auto-generated method stub
        menu.add(R.string.menuSave)
            .setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS | MenuItem.SHOW_AS_ACTION_WITH_TEXT);
		return false;
	}

}
