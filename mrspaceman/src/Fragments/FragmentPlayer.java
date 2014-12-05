package Fragments;


import com.labs.mrspaceman.R;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Toast;

public class FragmentPlayer extends Fragment {
	SeekBar seek_bar;
	Button stop_btn;
	MediaPlayer media_player;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
		return inflater.inflate(R.layout.fragment_player, container, false);
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		init();
	}

	private void init() {
		seek_bar = (SeekBar)getView().findViewById(R.id.seek_bar);
		stop_btn = (Button)getView().findViewById(R.id.play_btn);
	}


	public void playSound(String sound){
		media_player = new MediaPlayer();
		try {media_player.setDataSource(sound);
		media_player.prepare();
		media_player.start();
		} catch (Exception e) {}

		stop_btn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				media_player.pause();

			}
		});
	}


}
