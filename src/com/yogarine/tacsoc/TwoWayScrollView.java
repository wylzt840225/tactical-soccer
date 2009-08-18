package com.yogarine.tacsoc;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.GestureDetector.OnGestureListener;
import android.widget.FrameLayout;

public class TwoWayScrollView extends FrameLayout implements OnGestureListener {

	private GestureDetector _gestureDetector;
	
	public TwoWayScrollView(Context context) {
		super(context);
		_gestureDetector = new GestureDetector(context, this);
	}

	public TwoWayScrollView(Context context, AttributeSet attrs) {
		super(context, attrs);
		_gestureDetector = new GestureDetector(context, this);
	}

	public TwoWayScrollView(Context context, AttributeSet attrs, int defStyle)
	{
		super(context, attrs, defStyle);
		_gestureDetector = new GestureDetector(context, this);
	}

	@Override
	public boolean onTouchEvent(MotionEvent me) {
		return _gestureDetector.onTouchEvent(me);
	}
	
	public boolean onDown(MotionEvent e) {
		return true;
	}

	public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
		return false;
	}

	public void onLongPress(MotionEvent e) {

	}

	public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
		scrollBy((int)distanceX, (int)distanceY);
		return true;
	}

	public void onShowPress(MotionEvent e) {

	}

	public boolean onSingleTapUp(MotionEvent e)
	{
		return false;
	}

}
