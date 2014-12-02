package com.labs.mrspaceman;

import Fragments.FragmentPlayer;
import Fragments.FragmentSong;
import Fragments.FragmentSong.OnSoundSelected;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;

public class MainActivity extends FragmentActivity {
	FragmentPlayer fragment_player = new FragmentPlayer();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.activity_main);
		init();

	}


	private void init() {
		///load fragment player
		try {
			FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
			transaction.replace(R.id.frame_player, fragment_player);
			transaction.commit();		
		} catch (Exception e) {}
		
		//load fragment song
		try {
			FragmentSong fragment_song = new FragmentSong();
			FragmentTransaction transaction2 = getSupportFragmentManager().beginTransaction();
			transaction2.replace(R.id.frame_song, fragment_song);
			transaction2.commit();		
			
			fragment_song.setListener(new OnSoundSelected() {
				
				@Override
				public void OnSoundSelected(String sound_url) {
					fragment_player.playSound(sound_url);
				}
			});
		} catch (Exception e) {}
	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
