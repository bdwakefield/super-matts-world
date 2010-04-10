package org.myname.flixeldemo;

import java.text.MessageFormat;

import org.flixel.FlxG;
import org.flixel.FlxSprite;
import org.flixel.FlxText;
import org.myname.flixeldemo.parsing.Level;

import android.graphics.Color;

/**
 * Shows the level information necessary for the user including the time left in
 * the level. If time runs out, the HUD will kill the player.
 * 
 * @author Roger Walker, Tony Greer
 */
public final class Hud extends FlxSprite
{
	/* Format String for HUD */
	private static final String HUD_TXT_FMT = "Time: {0}     Level: {1}     x: {2}  y: {3}";

	private final FlxText hudText;
	private final FlxSprite background;
	private final String levelName;

	public Hud(String lvlName)
	{
		  this.hudText = new FlxText((int)(-FlxG.scroll.x), (int)(-FlxG.scroll.y), (int)(FlxG.width));
		  this.hudText.setSize(18);
		  // TODO Change Font of hudText		  
		  this.background = new FlxSprite((int)(-FlxG.scroll.x), (int)(-FlxG.scroll.y),
				  					null, false, (int)(FlxG.width), 50, Color.GRAY);
		  this.background.setAlpha(0.4f);
		  this.levelName = lvlName;
	}

	@Override
	public void update()
	{
		hudText.x =  -FlxG.scroll.x/2 * 2; 
		hudText.y =  -FlxG.scroll.y/2 * 2;
		hudText.width = FlxG.width;
		background.x =  -FlxG.scroll.x/2 * 2;
		background.y =  -FlxG.scroll.y/2 * 2;
		background.width = FlxG.width;

		// Update HUD
		if(Level.timeRemaining > 0)
		{
			this.hudText.setText(MessageFormat.format(HUD_TXT_FMT,
					(int)(Level.timeRemaining -= FlxG.elapsed), //{0}
					this.levelName,								//{1}
					(int)Level.player.x,						//{2}
					(int)Level.player.y));						//{3}
		}else if(Level.timeRemaining <= 0 && !Level.player.dead)
		{
			Level.player.kill();
		}

		//-- Update components
		this.hudText.update();
		this.background.update();
	}

	@Override
	public void render()
	{
		//-- Render components
		this.hudText.render();
		this.background.render();
	}
}