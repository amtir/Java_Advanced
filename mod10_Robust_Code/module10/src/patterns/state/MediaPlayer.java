package patterns.state;

import org.apache.log4j.Logger;


public class MediaPlayer {
	
	private static final Logger log4j = Logger.getLogger(MediaPlayer.class.getName());
	protected MediaState state = new StopState();

	public void play() {
		if (state instanceof PlayState) {
			log4j.debug("Already playing...");
			return;
		}
		state = new PlayState();
		state.performAction(this);
	}

	public void stop() {
		if (state instanceof StopState) {
			log4j.debug("Already stopped.");
			return;
		}
		state = new StopState();
		state.performAction(this);
	}
}
