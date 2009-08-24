/*	TacSoc - Tactical Soccer
	Copyright © 2009 Alwin Garside

	This file is part of TacSoc.
	
	TacSoc is free software: you can redistribute it and/or modify
	it under the terms of the GNU General Public License as published by
	the Free Software Foundation, either version 3 of the License, or
	(at your option) any later version.

	TacSoc is distributed in the hope that it will be useful,
	but WITHOUT ANY WARRANTY; without even the implied warranty of
	MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
	GNU General Public License for more details.

	You should have received a copy of the GNU General Public License
	along with TacSoc.  If not, see <http://www.gnu.org/licenses/>. */

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
			if (_gameView.dirty) {
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

}