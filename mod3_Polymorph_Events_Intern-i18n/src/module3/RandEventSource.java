package module3;

import java.util.ArrayList; //import java.util.Vector;

 // Event source.
public final class RandEventSource 
{
	private static final int ITERATIONS = 10;
	// Holds the reference of the event consumer.
	private ArrayList<RandEventListener> evlistener = new ArrayList<RandEventListener>();
	
	// A list of listeners (Vector or ArrayList).
	public void registerListener(RandEventListener listener)
	{ 
		evlistener.add(listener);
	}
	 // This method is called by the event source to notify the 
	 // event consumers about the event.
	public void notifyListener(RandEvent evObj)
	{
		for(RandEventListener list : evlistener )
			list.eventHandler(evObj);
	}

	public static void main(String[] args) 
	{
		// Create event object
		RandEventSource evSource = new RandEventSource();
		// Register event consumers, more than one Consumer
		evSource.registerListener(new RandEventConsumer());
		evSource.registerListener(new RandEventConsumer());
		evSource.registerListener(new RandEventConsumer());
		
		double randomNum;
		int truncRandomNum;
		for (int i = 0; i < ITERATIONS; i++)
		{
			randomNum = Math.random();
			truncRandomNum = (int)(randomNum*10000);	
			if (truncRandomNum%2 == 0) 
			{
				RandEvent ev = new RandEvent("10000th decimal place is even for random number = " + randomNum, 
						evSource);
				evSource.notifyListener(ev);
			}
		}
	}
}