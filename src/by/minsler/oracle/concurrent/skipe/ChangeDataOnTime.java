package by.minsler.oracle.concurrent.skipe;

public class ChangeDataOnTime {

	public static void main(String[] args) {

		SynchronizidObject obj = new SynchronizidObject();
		obj.setValue(1);

		Thread t = new Thread(new MyRunner(obj));
		t.start();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		obj.setValue(2);
	}

	static class SynchronizidObject {
		private int value;

		public synchronized void setValue(int value) {
			this.value = value;
			try {
				System.out.println("set: sleeping 3 s");
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// this.notify();
		}

		public synchronized void process() {
			System.out.println(" value in start: " + value);
			try {
				System.out.println("runner: sleeping");
				Thread.sleep(2000);
				this.wait(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(" value in end: " + value);
		}

	}

	static class MyRunner implements Runnable {
		SynchronizidObject obj;

		public MyRunner(SynchronizidObject obj) {
			this.obj = obj;
		}

		@Override
		public void run() {
			obj.process();
		}
	}
}
