package com.labs.mrspaceman;

import java.io.File;
import java.util.ArrayList;

import utils.FragmentAdapter;
import Fragments.FragmentPlayer;
import Fragments.FragmentSong;
import Fragments.FragmentSong.OnSoundSelected;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore.Files;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;

public class MainActivity extends FragmentActivity {
	FragmentPlayer fragment_player = new FragmentPlayer();
	String PRINCIPAL_DIRECTORY_NAME = "spaceman";
	ArrayList<String> arrSongs;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.activity_main);
		init();

	}


	private void init() {
		 String path = Environment.getExternalStorageDirectory().toString()+"/"+PRINCIPAL_DIRECTORY_NAME+"/";
		 arrSongs = getDirectoriesFromPath(path);
		
		
		///load fragment player
		try {
			FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
			transaction.replace(R.id.frame_player, fragment_player);
			transaction.commit();		
		} catch (Exception e) {}
		
		//load fragment song
//		try {
//			FragmentSong fragment_song = new FragmentSong();
//			FragmentTransaction transaction2 = getSupportFragmentManager().beginTransaction();
//			transaction2.replace(R.id.frame_song, fragment_song);
//			transaction2.commit();		
//			
//			fragment_song.setListener(new OnSoundSelected() {
//				
//				@Override
//				public void OnSoundSelected(String sound_url) {
//					fragment_player.playSound(sound_url);
//				}
//			});
//		} catch (Exception e) {}
		
		ViewPager pager = (ViewPager) findViewById(R.id.pager);
		FragmentAdapter adapter = new FragmentAdapter(getSupportFragmentManager());
		
		 for (String str : arrSongs){
			 FragmentSong fragment_song = FragmentSong.newInstance(str);
			 adapter.setFragment(fragment_song); 
		 }
		 
		 pager.setAdapter(adapter);
		 adapter.notifyDataSetChanged();
	}

	private ArrayList<String> getDirectoriesFromPath(String path) {
		ArrayList<String> directories = new ArrayList<String>();
		File f = new File(path);
		File[] files = f.listFiles();
		
		if (files != null) {
			for (int j = 0; j < files.length; j++) {
				File file = files[j];
				if (file.isDirectory()){
					directories.add(file.getName());
				}
			}
		}
		
		return directories;
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
