package com.example.classlab7c.fragments;

import java.util.List;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.example.classlab7c.R;
import com.example.classlab7c.listeners.OnItemSelectedListener;
import com.example.classlab7c.model.MenuItem;
import com.example.classlab7c.service.MusicListService;

public class ListFragment extends Fragment {
	private OnItemSelectedListener listener;
	private List<MenuItem>menuItems;
	
	
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.list_fragment, container, false);
		
		//this is how we will interact with the services
		menuItems = MusicListService.getInstance(getActivity()).getAllMenuItems();
		
		Button button1 = (Button) view.findViewById(R.id.button1);
		button1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				updateDetail("layout1");  
			}
		});
		
		ArrayAdapter<MenuItem> adapter =
				new ArrayAdapter<MenuItem>(getActivity(), android.R.layout.simple_list_item_1, menuItems);
		ListView listViewMusic = (ListView) view.findViewById(R.id.listViewMusic);
		listViewMusic.setAdapter(adapter);
		
		return view;
	}
	
	//NPE is thrown if you attempt to run this before instantiating
	//the listener.
	//fragment activity lifecycle info:
	//  - http://developer.android.com/reference/android/app/Fragment.html
	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity); 
		//this ensures that the activity implements the interface we defined.
		if (activity instanceof OnItemSelectedListener) {  
			listener = (OnItemSelectedListener) activity;  
		} else {  
			throw new ClassCastException(
				activity.toString() + " must implemenet MyListFragment.OnItemSelectedListener"
			);  
		} 
	}
	
	// May also be triggered from the Activity  
	public void updateDetail(String s) {          
		listener.onRssItemSelected(s);  
	} 
}
