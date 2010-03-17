package collectables;

import org.myname.flixeldemo.Player;
import org.myname.flixeldemo.parsing.Level;

public class Cigarette extends PowerUp
{
	public static float TIME_GAINED = 1F;
	
	protected Cigarette(int X, int Y, int Width, int Height)
	{
		super(X, Y, Width, Height);
	}

	@Override
	protected void onCollect(Player p)
	{
		Level.timeRemaining += TIME_GAINED;
	}
}