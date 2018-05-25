package module3;

public class RandEventConsumer implements RandEventListener {

	@Override  // implementation of the method Handler to the Event
	public void eventHandler(RandEvent evObj) {

		System.out.println("Source: " + evObj.toString() + " "
				+ " Payload: " + evObj.getPayload());
	}

}
