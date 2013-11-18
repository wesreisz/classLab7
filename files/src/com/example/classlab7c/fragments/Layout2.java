package com.example.classlab7c.fragments;

import java.util.List;

import com.example.classlab7c.R;
import com.example.classlab7c.adapters.ArtistAdapter;
import com.example.classlab7c.model.Artist;
import com.example.classlab7c.service.MusicListService;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

public class Layout2 extends Fragment {
	private static int ADD_BUTTON_POSITION = 0;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.layout2, container, false);
		List<Artist>artists = MusicListService.getInstance(getActivity()).getAllArtists();
		
		ArtistAdapter adapter = 
			new ArtistAdapter(getActivity(), R.layout.listview_for_each_artist, artists);
		ListView artistListView = (ListView)view.findViewById(R.id.listViewArtists);
		artistListView.setAdapter(adapter);
		
		setHasOptionsMenu(true);
		
		return view;
		
	}
	
	@Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        menu.getItem(ADD_BUTTON_POSITION).setVisible(true);
    }

}
