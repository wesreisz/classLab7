package com.example.classlab7c;

import java.util.Date;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.classlab7c.utils.SecurityUtils;
import com.parse.Parse;
import com.parse.ParseAnalytics;
import com.parse.ParseObject;

/**
 * Activity which displays a login screen to the user, offering registration as
 * well.
 */
public class AddSongActivity extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_add_song);
		setupActionBar();
		setFullTitle();
		
		Parse.initialize(this, 
				SecurityUtils.APP_ID, 
				SecurityUtils.APP_SECRET
			);
		
		ParseAnalytics.trackAppOpened(getIntent());
	}	

	private void setupActionBar() {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
			getActionBar().setDisplayHomeAsUpEnabled(true);
		}
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			NavUtils.navigateUpFromSameTask(this);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	public void addSongToBackend(View v){
		showToast("Adding Song");
		
		EditText songName = (EditText)findViewById(R.id.song_title);
		EditText songAlbum = (EditText)findViewById(R.id.song_album);
		EditText songReleaseDate = (EditText)findViewById(R.id.song_release_date);
		
		ParseObject testObject = new ParseObject("Song");
		testObject.put("songName", songName.getText().toString());
		testObject.put("songAlbum", songAlbum.getText().toString());
		testObject.put("songReleaseDate", songReleaseDate.getText().toString());
		testObject.saveInBackground();
		
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
