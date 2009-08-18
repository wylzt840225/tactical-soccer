package com.yogarine.tacsoc;

import android.graphics.Canvas;
import android.view.SurfaceHolder;

public class GameThread extends Thread {

	public boolean running = false;
	private SurfaceHolder _surfaceHolder;
	private GameView _gameView;
	private Canvas _canvas = null;

	public GameThread(SurfaceHolder surfaceHolder, GameView gameView) {
		_surfaceHolder = surfaceHolder;
		_gameView = gameView;
	}

	@Override
	public void run() {
		while (running) {
			_canvas = null;
			if (!_gameView.dirty) continue;
			try {
				_canvas = _surfaceHolder.lockCanvas(null);
				synchronized (_surfaceHolder) {
					_gameView.onDraw(_canvas);
				}
	        } finally {
	            // do this in a finally so that if an exception is thrown
	            // during the above, we don't leave the Surface in an
	            // inconsistent state
	            if (_canvas != null) {
	                _surfaceHolder.unlockCanvasAndPost(_canvas);
	            }
	        }
	    }
	}

}