package com.yogarine.tacsoc;

import android.app.Activity; 
import android.os.Bundle; 
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;

public class TacSoc extends Activity {

	static int FILL_PARENT = LinearLayout.LayoutParams.FILL_PARENT;
	static int WRAP_CONTENT = LinearLayout.LayoutParams.WRAP_CONTENT;
	private LayoutParams _layoutParams;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		_layoutParams = new LayoutParams(FILL_PARENT,FILL_PARENT);
//		TwoWayScrollView twoWayScrollView = new TwoWayScrollView(this);
		GameView gameView = new GameView(this);
//		twoWayScrollView.addView(gameView,_layoutParams);
//		setContentView(twoWayScrollView,_layoutParams);
		setContentView(gameView,_layoutParams);
	}

}