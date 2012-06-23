package by.minsler.oracle.concurrent.skipe;

public class TestSync {

	public static void main(String[] args) {
		Object sync = new Object();
		Data d = new Data();

		Thread t = new Thread(new MyReader(sync, d));
		t.start();

		try {
			Thread.sleep(1000);

			synchronized (sync) {
				System.out.println("main: set value to 1");
				d.value = 1;
				System.out.println("main: waiting 5 s");
				Thread.sleep(5000);
				sync.notify();
				System.out.println("main: after notify");
			}

		} catch (InterruptedException e) {
			System.out.println("main: interrupted exception in sleep "
					+ e.getMessage());
		}

	}

	public static class Data {
		public int value = 0;
	}

	public static class MyReader implements Runnable {
		private Object sync;
		private Data d;

		public MyReader(Object sync, Data d) {
			this.sync = sync;
			this.d = d;
		}

		@Override
		public void run() {

			if (d.value == 0) {
				synchronized (sync) {
					System.out.println("reader: waiting of data...");
					try {
						System.out.println("reader: waiting 2 s");
						sync.wait(2000);// wait with time, minimum waiting time
					} catch (InterruptedException e) {
						System.out.println("reader: interrupted exception "
								+ e.getMessage());
					}
					System.out.println("reader: get value " + d.value);
					System.out.println("reader: exit from synchronized block");
				}
			}
		}
	}
}
