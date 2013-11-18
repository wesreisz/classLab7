package com.example.classlab7c.adapters;

import java.text.SimpleDateFormat;
import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.classlab7c.R;
import com.example.classlab7c.model.Artist;
import com.example.classlab7c.model.Song;

public class ArtistAdapter extends ArrayAdapter<Artist> {
	private SimpleDateFormat df = new SimpleDateFormat("EEE MMM d, ''yy"); 
	private Context mContext;
	private List<Artist> mEntries;

	public ArtistAdapter(Context context, int resource, List<Artist> artists) {
		super(context, resource, artists);
		this.mContext = context;
		this.mEntries = artists;
	}

	@Override
	public View getView(int position, View view, ViewGroup parent) {
		if (view==null){
			LayoutInflater inflater =  (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			view = inflater.inflate(R.layout.listview_for_each_artist, parent, false);
		}
		Artist artist = mEntries.get(position);
		
		TextView textViewTitle = (TextView)view.findViewById(R.id.textViewArtistName);
		textViewTitle.setText(artist.getArtistName());
		
		String strSongs = "";
		for(Song song:artist.getSongs()){
			strSongs += song.getSongTitle() + " [" + song.getAlbumTitle() + "]\n";
		}
		
		TextView textViewSong = (TextView)view.findViewById(R.id.textViewSongs);
		textViewSong.setText(strSongs);
		
		return view;
	}
	
}
