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

/** 
 * Sprite
 * 
 * Base class defining the core set of information necessary to render (and move
 * an object on the screen.  This is an abstract type and must be derived to
 * add methods to actually draw (see CanvasSprite and GLSprite).
 */
public abstract class Sprite {
    public float x;
    public float y;
    public float z;
    
    public float velocityX;
    public float velocityY;
    public float velocityZ;
    
    public float width;
    public float height;
}
