package patterns.state;

public class MediaPlayerApp {

	public static void main(String[] args) {

		MediaPlayer player = new MediaPlayer();
		player.play();
		player.stop();
		
		player.play();
		player.play();
		
		player.stop();
		player.stop();
	}
}
