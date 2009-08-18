package com.yogarine.tacsoc;

//import java.util.ArrayList;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class GameView extends SurfaceView implements SurfaceHolder.Callback, GestureDetector.OnGestureListener {
	public int scrollX = 0;
	public int scrollY = 0;
	private int _tempX = 0;
	private int _tempY = 0;
	private GestureDetector _gestureDetector;
	private SurfaceHolder _surfaceHolder;
	private GameThread _gameThread;
	private Bitmap _scratch;
	private Bitmap _grass;
//	private ArrayList<Bitmap> _graphics = new ArrayList<Bitmap>();
	
	public GameView(Context context) {
		super(context);
		setFocusable(true);
		_gestureDetector = new GestureDetector(context, this);
		_surfaceHolder = getHolder();
		_surfaceHolder.addCallback(this);
		_gameThread = new GameThread(_surfaceHolder,this);
		_scratch = BitmapFactory.decodeResource(getResources(), R.drawable.player);
		_grass = BitmapFactory.decodeResource(getResources(), R.drawable.grass);
	}

	public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
		
	}

	public void surfaceCreated(SurfaceHolder holder) {
		_gameThread.running = true;
		_gameThread.start();
	}

	/**
	 * Surface Destroyed callback function.
	 * 
	 * Simply copied from sample application LunarLander:
	 * We have to tell thread to shut down & wait for it to finish, or else it
	 * might touch the Surface after we return and explode.
	 */
	public void surfaceDestroyed(SurfaceHolder holder) {
		boolean retry = true;
		_gameThread.running = false;

		while (retry) {
			try {
				_gameThread.join();
				retry = false;
			} catch (InterruptedException e) {
				// we will try it again and again...
			}
		}
	}

	@Override
	public boolean onTouchEvent(MotionEvent me) {
//		Log.d("TacSoc", "-- GameView.onTouchEvent()");
		return _gestureDetector.onTouchEvent(me);
	}

	@Override
	public void onDraw(Canvas canvas) {
//		long timestampStart = 0;
//		long timestampEnd = 0;
		int ix = 0;
		int iy = 0;
		canvas.drawColor(Color.BLACK);
		_tempX = scrollX;
		_tempY = scrollY;
//		timestampStart = System.currentTimeMillis();
		for (ix=0; ix<3200; ix+=64) {
			for (iy=0; iy<2400; iy+=64) {
				if (_tempX+ix < -64) continue;
				else if (_tempY+iy < -64) continue;
				else if (_tempX+ix > 480) continue;
				else if (_tempY+iy > 480) continue;
				else
					canvas.drawBitmap(_grass, _tempX+ix, _tempY+iy, null);				
			}			
		}
//		timestampEnd = System.currentTimeMillis();
		canvas.drawBitmap(_scratch, _tempX+10, _tempY+10, null);
		canvas.drawBitmap(_scratch, _tempX+10+128, _tempY+10+64, null);
		canvas.drawBitmap(_scratch, _tempX+10+320, _tempY+10+320, null);

//		Log.d("onDraw","time: "+(timestampEnd - timestampStart));
	}

	public boolean onDown(MotionEvent e) {
//		Log.d("TacSoc", "-- GameView.onDown()");
		return true;
	}

	public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
//		Log.d("TacSoc", "-- GameView.onFling()");
		return false;
	}

	public void onLongPress(MotionEvent e) {
//		Log.d("TacSoc", "-- GameView.onLongPress()");
	}

	public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
//		Log.d("TacSoc", "-- GameView.onScroll(e1,e2,"+distanceX+","+distanceY+")");
		scrollX -= (int)distanceX;
		scrollY -= (int)distanceY;
//		Log.d("TacSoc", "-- scrollX = "+scrollX);
//		Log.d("TacSoc", "-- scrollY = "+scrollY);
		return true;
	}

	public void onShowPress(MotionEvent e) {
//		Log.d("TacSoc", "-- GameView.onShowPress()");
	}

	public boolean onSingleTapUp(MotionEvent e)
	{
//		Log.d("TacSoc", "-- GameView.onSingleTap()");
		return false;
	}
}