package collectables;

import org.myname.flixeldemo.Player;
import org.myname.flixeldemo.parsing.Level;

public final class Beer extends PowerUp 
{
	public static float TIME_GAINED = 1000F;

	protected Beer(int X, int Y, int Width, int Height)
	{
		super(X, Y, Width, Height);
	}

	@Override
	protected void onCollect(Player p)
	{
		Level.timeRemaining += TIME_GAINED;
	}
}