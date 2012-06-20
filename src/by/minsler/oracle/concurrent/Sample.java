package by.minsler.oracle.concurrent;

public class Sample {

	public static void main(String[] args) throws InterruptedException {

		ThreadUtil.threadMessage("Starting thread in main()");

		Thread t = new Thread(new MessageLoop());
		long patience = 1000 * 6;
		long startTime = System.currentTimeMillis();

		ThreadUtil.threadMessage("Start MessageLoop Thread");

		t.start();

		ThreadUtil.threadMessage("Waiting for message loop to finish");

		while (t.isAlive()) {
			ThreadUtil.threadMessage("Waiting...");
			t.join(1000);
			if ((System.currentTimeMillis() - startTime) > patience
					&& t.isAlive()) {
				ThreadUtil.threadMessage("Tired waiting");
				t.interrupt();
				t.join(); // why?
			}
		}
		ThreadUtil.threadMessage("finally");
	}
}
