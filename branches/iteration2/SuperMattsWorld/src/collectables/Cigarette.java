package collectables;

import org.flixel.FlxG;
import org.myname.flixeldemo.Player;
import org.myname.flixeldemo.R;
import org.myname.flixeldemo.parsing.Level;

public class Cigarette extends PowerUp
{
	public static float TIME_GAINED = 5F;

	protected Cigarette(int X, int Y, int Width, int Height)
	{
		super(X, Y, Width, Height);
		this.loadGraphic(R.drawable.cigarette);
	}

	@Override
	protected void onCollect(Player p)
	{
		Level.timeRemaining += TIME_GAINED;
	}

	@Override
	protected void playSound()
	{
		FlxG.play(R.raw.cigarettesfx, FlxG.getVolume());
	}
}