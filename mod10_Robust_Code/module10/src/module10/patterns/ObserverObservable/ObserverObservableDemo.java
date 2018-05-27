package module10.patterns.ObserverObservable;

public class ObserverObservableDemo {
	public static void main(String args[]) throws InterruptedException {
		
		RandObservable observedObj = new RandObservable();
		RandObservable2 observedObj2 =  new RandObservable2();
		
		FirstObserver Observer1 = new FirstObserver();
		FirstObserver Observer2 = new FirstObserver(); // SecondObserver();
		
		Thread randThread1 = new Thread(new RandomRunnable(observedObj,Observer1 ));
	    Thread randThread2 = new Thread(new RandomRunnable(observedObj,Observer2 ));
		Thread randThread3 = new Thread(new RandomRunnable2(observedObj2,Observer1 ));
	 
	    randThread1.start();
	    randThread2.start();
	    randThread3.start();
	    
	    randThread1.join();
	    randThread2.join();
	    randThread3.join();
		
	}
}

 class RandomRunnable implements Runnable {
	 
	 RandObservable observedObj;
	 FirstObserver Observer;
	 
	 public RandomRunnable(RandObservable observedObj, FirstObserver Observer){
		 this.observedObj=observedObj;
		 this.Observer=Observer;
	 }

	@Override
	public void run() {
		observedObj.addObserver(Observer);
		observedObj.startObservable();
	}
}
 
 class RandomRunnable2 implements Runnable {
	 
	 RandObservable2 observedObj;
	 FirstObserver Observer;
	 
	 public RandomRunnable2(RandObservable2 observedObj, FirstObserver Observer){
		 this.observedObj=observedObj;
		 this.Observer=Observer;
	 }

	@Override
	public void run() {
		observedObj.addObserver(Observer);
		observedObj.startObservable();
	}
}
 