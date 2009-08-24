package com.yogarine.tacsoc;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.GestureDetector.SimpleOnGestureListener;

public class Character extends SimpleOnGestureListener {

	/**
	 * Hit Points.
	 * @var int Points you lose when being attacked. KO when it reaches 0.
	 */
	public int hp;

	/**
	 * Magic Points.
	 * @var int Points that are used when using "magic" tricks.
	 */
	public int mp;

	/**
	 * Level.
	 * @var int The characters level.
	 */
	public int lvl;

	/**
	 * Experience.
	 * @var int The amount of experience the character has accumulated.
	 */
	public int exp;

	/**
	 * Strength.
	 * @var int Strength
	 */
	public int str;

	/**
	 * Vitality.
	 * @var int How well the character can defend against enemy attacks.
	 */
	public int vit;

	/**
	 * Magic
	 * @var int How good the character is at 'magic' tricks.
	 */
	public int mag;
	
	/**
	 * Spirit
	 * @var int How well the character defends against 'magic' tricks.
	 */
	public int spr;
	
	/**
	 * Accuracy.
	 * @var int How accurate the passes and shots are.
	 */
	public int acc;
	
	/**
	 * Stamina.
	 * @var int How long the player can hold out before get tired.
	 */
	public int sta;
	
	/**
	 * Evasion.
	 * @var int How good the character is at evading enemy attacks.
	 */
	public int eva;
	
	/**
	 * Dexterity.
	 * @var int How well the character can handle the ball.
	 */
	public int dex;
	
	/**
	 * Speed.
	 * @var int How fast the character can move.
	 */
	public int spd;

	/**
	 * Motivation
	 * @var int How motivated the character is.
	 */
	public int mot;

	public int x;
	
	public int y;
	
	private Bitmap _bitmap;
	
	public String[] statusEffects;

	public Character() {
		_bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.player);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void onDraw(Canvas canvas) {
		canvas.drawBitmap(_bitmap, x, y+10, null);
	}

}
