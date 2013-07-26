package com.yunyun.contacts;


import com.actionbarsherlock.internal.widget.IcsAdapterView;
import com.actionbarsherlock.internal.widget.IcsSpinner;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;
import com.yunyun.contacts.internal.TitleBar;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class CallFragment extends Fragment implements TitleBar{
	
	private TextView textView1 = null;
    private TextView textView2 = null;
    
    private int titleBarIndex = 0;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.callfragment, container, false);
        textView1 = (TextView) v.findViewById(R.id.nameLable);
        textView1.setText("TextView1");
        return v;
    }


	@Override
	public View createTitleBar(Context context) {
		// TODO Auto-generated method stub
	   TextView v = new TextView(context);
	   v.setGravity(Gravity.CENTER);
	   v.setText(R.string.calltitle);
       /*ArrayAdapter<CharSequence> list = ArrayAdapter.createFromResource(context, R.array.call, R.layout.sherlock_spinner_item);
       list.setDropDownViewResource(R.layout.sherlock_spinner_dropdown_item);
       
       IcsSpinner mSpinner = new IcsSpinner(context, null,
               R.attr.actionDropDownStyle);
       
       mSpinner.setAdapter(list);
       mSpinner.setOnItemSelectedListener(new IcsAdapterView.OnItemSelectedListener() {
           public void onItemSelected(IcsAdapterView parent, View view, int position, long id) {
        	   titleBarIndex = position;
           }
           public void onNothingSelected(IcsAdapterView parent) {
               // Do nothing
           }
       });
       mSpinner.setSelection(titleBarIndex);*/
	   return v;
	}


	@Override
	public boolean onCreatePanelMenu(Menu menu) {
/*
        menu.add("Save")
            .setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS | MenuItem.SHOW_AS_ACTION_WITH_TEXT);*/
        return false;
	}
	
}
