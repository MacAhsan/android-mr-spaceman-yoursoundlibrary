package Fragments;



import com.labs.mrspaceman.R;

import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class FragmentSong extends Fragment {
	
	Button btn;
	OnSoundSelected listener;
	public interface OnSoundSelected{
		public void OnSoundSelected(String sound_url); 
	}
	
	public void setListener(OnSoundSelected listener) {
		this.listener = listener;
	}

	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
		return inflater.inflate(R.layout.fragment_song, container, false);
	}
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		init();
	}

	private void init() {
		btn = (Button)getView().findViewById(R.id.boton);
		btn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if (listener != null) {
					listener.OnSoundSelected(Environment.getExternalStorageDirectory().getAbsolutePath() + "/spaceman/1.mp3");
				}
			}
		});
		
	}

}
