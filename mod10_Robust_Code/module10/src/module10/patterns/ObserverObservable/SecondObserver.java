package module10.patterns.ObserverObservable;

import java.util.Observable;
import java.util.Observer;
import org.apache.log4j.Logger;

public class SecondObserver implements Observer {

	private static final Logger log4j = Logger.getLogger(SecondObserver.class.getName());

	public void update(Observable obj, Object arg) {
		if (obj instanceof RandObservable)
			log4j.debug("SecondObserver got The Random Int:" + (String) arg+ " from RandObservable1");
		else if (obj instanceof RandObservable2)
			log4j.debug("SecondObserve got The Random Int:" + (String) arg+ " from RandObservable2");
	}
}