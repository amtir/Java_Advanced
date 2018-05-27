package patterns.state;

import org.apache.log4j.Logger;

public class PlayState implements MediaState {
	
	private static final Logger log4j = Logger.getLogger(PlayState.class.getName());
	
	@Override
	public void performAction(MediaPlayer context) {
		log4j.debug("Playing...");
	}

}
