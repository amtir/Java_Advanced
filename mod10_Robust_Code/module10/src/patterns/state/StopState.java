package patterns.state;

import org.apache.log4j.Logger;

public class StopState implements MediaState {
	
	private static final Logger log4j = Logger.getLogger(StopState.class.getName());
	
	@Override
	public void performAction(MediaPlayer context) {
		log4j.debug("Stoping...");
	}

}
