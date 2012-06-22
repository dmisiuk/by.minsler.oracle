package by.minsler.oracle.concurrent.sync;

public class TestCaunter implements Runnable {

	private static Counter myCounter;

	@Override
	public void run() {
		for (int i = 0; i < 20000; i++) {
			myCounter.increment();
			System.out.println("current: " + myCounter.value());
			// try {
			// Thread.sleep(100);
			// } catch (InterruptedException e) {
			// // TODO Auto-generated catch block
			// e.printStackTrace();
			// }
		}
	}

	public static void main(String[] args) throws InterruptedException {
		myCounter = new Counter();
		new Thread(new TestCaunter()).start();
		for (int i = 0; i < 20000; i++) {
			myCounter.decriment();
			System.out.println("current: " + myCounter.value());
			// Thread.sleep(100);
		}
	}
}
