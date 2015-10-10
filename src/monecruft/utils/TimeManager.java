package monecruft.utils;

import org.lwjgl.Sys;

public class TimeManager 
{
	private long lastFPS=getTime();
	private int fpscont=0;
	private long lastReadedTime;
	private int fps=0;
	public TimeManager()
	{
		this.lastReadedTime=getTime();
	}
	/**
	 * Get the accurate system time
	 * 
	 * @return The system time in milliseconds
	 */
	public long getTime() {
	    return (Sys.getTime() * 1000) / Sys.getTimerResolution();
	}
	/**
	 * @return delta time in seconds
	 */
	public float getDeltaTime()
	{
		long currentTime=getTime();
		long delta=currentTime-this.lastReadedTime;
		this.lastReadedTime=currentTime;
		return (float)(delta)/1000;
	}
	/**
	 * Calculate the FPS and set it in the title bar
	 */
	public void updateFPS() {
		if (getTime() - lastFPS > 1000) {
			this.fps=this.fpscont;
			fpscont = 0;
			lastFPS += 1000;
		}
		fpscont++;
	}
	public int getFPS()
	{
		return this.fps;
	}
}
