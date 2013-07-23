package com.yunyun.contacts.internal;


import com.actionbarsherlock.ActionBarSherlock;
import com.actionbarsherlock.ActionBarSherlock.OnCreatePanelMenuListener;
import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.view.Menu;
import com.yunyun.contacts.CallFragment;
import com.yunyun.contacts.MainActivity;
import com.yunyun.contacts.R;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;

public class BaseActivity extends FragmentActivity  implements OnCreatePanelMenuListener{
	protected ActionBarSherlock mSherlock = ActionBarSherlock.wrap(this);
	private Menu mMenu;
	protected int current = 0;
	public static final String [] lables = {"拨号","联系人","群组","设置"};
	 public static final  String [] tags = {"call","person","group","setting"};
	 public static final  int [] light_icons = {R.drawable.l_device_access_ring_volume,R.drawable.l_social_person,R.drawable.l_social_group,R.drawable.l_action_settings};
	 public static final  int []  dark_icons = {R.drawable.d_device_access_ring_volume,R.drawable.d_social_person,R.drawable.d_social_group,R.drawable.d_action_settings};
	 public static final Class[] fragments = {CallFragment.class,CallFragment.class,CallFragment.class,CallFragment.class};
	private  TabManager tabManager;

	@Override
    protected void onCreate(Bundle savedInstanceState) {
		setTheme(R.style.contacts);
	    super.onCreate(savedInstanceState);
	    mSherlock.setContentView(R.layout.baseactivity);
	    
	    TabHost tbhost = (TabHost)findViewById(android.R.id.tabhost);
	    tbhost.setup();
	    
	       
	    LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	    tabManager = new TabManager(this,tbhost,R.id.realtabcontent);
	   
	    for(int i=0;i<lables.length;i++){
	    	View tabIndicator = inflater.inflate(R.layout.tab_indicator,
		    		   tbhost.getTabWidget(), // tab widget is the parent
		               false); // no inflate params
	    	
	    	TextView lable = (TextView)tabIndicator.findViewById(R.id.title);      
	        lable.setText(lables[i]);
	        
	        ImageView icon = (ImageView)tabIndicator.findViewById(R.id.icon);
	        if(current==i)
	        	icon.setImageResource(light_icons[i]);
	        else
	        	icon.setImageResource(dark_icons[i]);
	        tabManager.addTab(tbhost.newTabSpec(tags[i]).setIndicator(tabIndicator),fragments[i]);
	    }
	}
	
	protected void setDisplayShowTitleEnabled(boolean flag){
		 mSherlock.getActionBar().setDisplayShowTitleEnabled(false);
	}
	
	protected void setDisplayShowHomeEnabled(boolean flag){
		mSherlock.getActionBar().setDisplayShowHomeEnabled(false);
	}
	
	protected void setCustomTitle(View v){
		mSherlock.getActionBar().setDisplayShowCustomEnabled(true);
		ActionBar.LayoutParams params = new ActionBar.LayoutParams(
	               LayoutParams.WRAP_CONTENT, LayoutParams.MATCH_PARENT);
	    params.gravity = Gravity.CENTER;
		mSherlock.getActionBar().setCustomView(v, params);
	}
	
	
	protected Context getActionBarContext(){
		return mSherlock.getActionBar().getThemedContext();
	}
	
	@Override
	public boolean onCreatePanelMenu(int featureId,
			com.actionbarsherlock.view.Menu menu) {
		// TODO Auto-generated method stub
		mMenu = menu;
		tabManager.createOptionsMenu(menu);
        return true;
	}
	
	public com.actionbarsherlock.view.Menu getMenu(){
		return mMenu;
	}
	
}
