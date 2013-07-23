package com.yunyun.contacts.internal;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import com.actionbarsherlock.view.Menu;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TabWidget;

public class TabManager implements TabHost.OnTabChangeListener,TabHost.TabContentFactory{
	
	
	private TabHost tabhost = null;
	private TreeMap<String,TabInfo> hashTabs = new TreeMap<String,TabInfo>();
	private FragmentActivity activity = null;
	private int mContainerId ;
	private TabInfo mLastTab; 
	
	static class TabInfo{
		
		public String tag;
		public Class viewClazz;
		public Fragment fragment;
		
		public TabInfo(String tag,Class view){
			this.tag = tag;
			this.viewClazz = view;
		}
		
	}
	
	public TabManager(FragmentActivity activity,TabHost tabhost,int container){
		this.tabhost = tabhost;
		this.activity = activity;
		this.mContainerId = container;
		tabhost.setOnTabChangedListener(this);
	}
	
	
	public void addTab(TabHost.TabSpec tabspec,Class view){
		hashTabs.put(tabspec.getTag(), new TabInfo(tabspec.getTag(),view));
		tabspec.setContent(this);
		tabhost.addTab(tabspec);
	}
	
	@Override
	public void onTabChanged(String tabId) {
		// TODO Auto-generated method stub
		
		TabInfo newTab = hashTabs.get(tabId);
        if (mLastTab != newTab) {
            FragmentTransaction ft = activity.getSupportFragmentManager().beginTransaction();
            if (mLastTab != null) {
                if (mLastTab.fragment != null) {
                    ft.detach(mLastTab.fragment);
                }
            }
            
          
            if (newTab != null) {
                if (newTab.fragment == null) {
                    newTab.fragment = Fragment.instantiate(activity,
                            newTab.viewClazz.getName(), null);
                    ft.add(com.yunyun.contacts.R.id.realtabcontent, newTab.fragment, newTab.tag);
                } else {
                    ft.attach(newTab.fragment);
                }
            }
            
            TabWidget tw = (TabWidget)activity.findViewById(android.R.id.tabs);
            for(int i=0;i<BaseActivity.tags.length && tw.getChildCount()==BaseActivity.tags.length;i++){
            	ImageView c = (ImageView)tw.getChildAt(i).findViewById(com.yunyun.contacts.R.id.icon);
            	if (BaseActivity.tags[i].equals(tabId)){
            		((BaseActivity)activity).current = i;
					c.setImageResource(BaseActivity.light_icons[i]);
				}else{
					c.setImageResource(BaseActivity.dark_icons[i]);
				}
			}
            mLastTab = newTab;
            
            TitleBar tb = (TitleBar)(newTab.fragment);
            View c = tb.createTitleBar(((BaseActivity)activity).getActionBarContext());
            ((BaseActivity)activity).setCustomTitle(c);
            createOptionsMenu( ((BaseActivity)activity).getMenu());
           
            ft.commit();
            activity.getSupportFragmentManager().executePendingTransactions();
        }
		
		
	}
	
	public void createOptionsMenu(Menu menu){
		if(mLastTab!=null){
			TitleBar tb = (TitleBar)(mLastTab.fragment);
			 if(((BaseActivity)activity).getMenu()!=null){
				((BaseActivity)activity).getMenu().clear();
	            tb.onCreatePanelMenu(((BaseActivity)activity).getMenu());
	         }
		}
	}

	@Override
	public View createTabContent(String tag) {
		// TODO Auto-generated method stub
		View c = new View(activity);
		c.setMinimumHeight(10);
		c.setMinimumWidth(10);
		return c;
	}

}
