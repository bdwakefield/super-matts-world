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
	private final String levelName;

	public Hud(String lvlName)
	{
		super((int)(-FlxG.scroll.x), (int)(-FlxG.scroll.y),
				null, false, (int)(FlxG.width), 50, Color.GRAY);
		super.setAlpha(0.4f);
		super.width = FlxG.width;

		this.hudText = new FlxText((int)(-FlxG.scroll.x), (int)(-FlxG.scroll.y), (int)(FlxG.width));
		this.hudText.setSize(18);		  

		this.levelName = lvlName;
	}

	@Override
	public void update()
	{
		super.update();

		hudText.x =  -FlxG.scroll.x/2 * 2; 
		hudText.y =  -FlxG.scroll.y/2 * 2;
		hudText.width = FlxG.width;
		super.x =  -FlxG.scroll.x/2 * 2;
		super.y =  -FlxG.scroll.y/2 * 2;

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
	}

	@Override
	public void render()
	{
		//-- Render components
		super.render();
		this.hudText.render();
	}
}