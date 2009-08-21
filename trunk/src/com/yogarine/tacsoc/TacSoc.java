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

import android.app.Activity; 
import android.os.Bundle; 
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;

public class TacSoc extends Activity {

	public static final int FILL_PARENT = LinearLayout.LayoutParams.FILL_PARENT;
	public static final int WRAP_CONTENT = LinearLayout.LayoutParams.WRAP_CONTENT;
	private LayoutParams _layoutParams;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		_layoutParams = new LayoutParams(FILL_PARENT,FILL_PARENT);
		GameView gameView = new GameView(this);
		setContentView(gameView,_layoutParams);
	}

}