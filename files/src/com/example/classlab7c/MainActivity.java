package com.example.classlab7c;

import java.util.List;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.classlab7c.listeners.SimpleTabListener;
import com.example.classlab7c.service.MusicListService;
import com.example.classlab7c.utils.SecurityUtils;
import com.parse.Parse;

public class MainActivity extends Activity {

    private static final String TAG = "Main_Activity_Fragment";


	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setFullTitle();
        
        ActionBar actionBar = getActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        
        List<com.example.classlab7c.model.MenuItem>menuItems = 
        		MusicListService.getInstance(this).getAllMenuItems();
        for(com.example.classlab7c.model.MenuItem menuItem: menuItems){
	    	ActionBar.Tab tab = actionBar.newTab();
	        tab.setText(menuItem.getMenuTitle());
	        tab.setTabListener(new SimpleTabListener(this, menuItem.getMenuItemClass()));
	        actionBar.addTab(tab);
	    }
        
        Parse.initialize(this, 
				SecurityUtils.APP_ID, 
				SecurityUtils.APP_SECRET
			);
    }

	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        
        return true;
    }
    
    public void onOption1Clicked(MenuItem menuItem){
    	ActionBar actionBar = getActionBar();
    	String name = (String) actionBar.getSelectedTab().getText();
    	
    	if (actionBar.getSelectedTab().getPosition()==1){
	    	Intent intent = new Intent(this, AddSongActivity.class);
			startActivity(intent);  
    	}else if (actionBar.getSelectedTab().getPosition()==2){
    		showToast("Add Artist");
    	}else if (actionBar.getSelectedTab().getPosition()==3){
    		showToast("Add Event");
    	}
    }
    
    public void onExitClicked(MenuItem menuItem){
    	finish();
    }

    private void showToast(String message) {
    	Toast t = Toast.makeText(this, message, Toast.LENGTH_SHORT);
    	t.show();
    }
    
    private void setFullTitle(){
    	ActionBar actionBar = getActionBar();
    	actionBar.setSubtitle("Super kewl subtitle");
    	actionBar.show();
    }
}
