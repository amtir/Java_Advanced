package mod7;

public class ThreadDemo {

	public static void main(String[] args) {
		Thread ft = new FirstThread();
		ft.start();
		Thread fr = new Thread(new FirstRunnable());
		fr.start();
	}
}

class FirstThread extends Thread {
	public void run() {
		for (int i =0; i<10 ;i++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(i);
		}
	}
}


class FirstRunnable implements Runnable {
	public void run() {
		for (int i =0; i<20 ;i++) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(i);
		}
	}
}


