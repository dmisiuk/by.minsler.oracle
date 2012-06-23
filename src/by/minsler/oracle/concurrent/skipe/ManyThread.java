package by.minsler.oracle.concurrent.skipe;

public class ManyThread {

	public static void main(String[] args) {
		Object o = new Object();
		for (int i = 0; i < 5; i++) {
			Thread t = new Thread(new MyReader(o));
			t.start();
		}

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		synchronized (o) {
			o.notifyAll();
		}

	}

	static class MyReader implements Runnable {

		private static int nextId = 0;
		private Object o;
		private int id;

		public MyReader(Object o) {
			this.o = o;
			id = nextId;
			nextId++;
		}

		@Override
		public void run() {
			synchronized (o) {
				System.out.println("thread id: " + id + " starting");
				System.out.println("thread id: " + id + " waiting");
				try {
					o.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("thread id: " + id + " continue");
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("thread id: " + id + " exiting");

			}
		}

	}
}
