package com.yogarine.tacsoc;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class GameView extends SurfaceView implements SurfaceHolder.Callback {
	private SurfaceHolder _surfaceHolder;
	private GameThread _gameThread;
	private Bitmap _scratch;
	
	public GameView(Context context) {
		super(context);
		_surfaceHolder = getHolder();
		_surfaceHolder.addCallback(this);
		_gameThread = new GameThread(_surfaceHolder,this);
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
    public void onDraw(Canvas canvas) {
        Bitmap _scratch = BitmapFactory.decodeResource(getResources(), R.drawable.icon);
        canvas.drawColor(Color.BLACK);
        canvas.drawBitmap(_scratch, 10, 10, null);
    }

}
