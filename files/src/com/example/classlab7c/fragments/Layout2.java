package com.example.classlab7c.fragments;

import java.util.List;

import com.example.classlab7c.R;
import com.example.classlab7c.model.Artist;
import com.example.classlab7c.service.MusicListService;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Layout2 extends Fragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.layout2, container, false);
		//List<Artist>artists = MusicListService.getInstance(getActivity()).
		
		return view;
		
	}

}
