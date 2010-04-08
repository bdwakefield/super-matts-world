package org.myname.flixeldemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

public class FlixelDemo extends Activity 
{
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        
        // turn off the window's title bar
        super.requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, 
                                            WindowManager.LayoutParams.FLAG_FULLSCREEN );
        setContentView(R.layout.main);
    }

	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
	}
}