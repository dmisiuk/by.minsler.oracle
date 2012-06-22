package by.minsler.oracle.concurrent.sync;

public class Counter {

	private int c;

	public synchronized void increment() {
		c++;
	}

	public synchronized void decriment() {
		c--;
	}

	public synchronized int value() {
		return c;
	}

}
