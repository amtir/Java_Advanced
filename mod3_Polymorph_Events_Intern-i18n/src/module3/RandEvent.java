package module3;

// Class to model the Event
public class RandEvent {
	
	protected String payload;
	protected Object evSource;
	
	public RandEvent(String payload, Object evSource)
	{
		this.payload = payload;
		this.evSource = evSource;
	}
	
	public String getPayload()
	{ return payload; }
	
	@Override
	public String toString()
	{ return evSource.getClass().getSimpleName(); }
	
}
