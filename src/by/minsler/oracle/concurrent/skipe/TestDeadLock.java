package by.minsler.oracle.concurrent.skipe;

public class TestDeadLock {

	public static void main(String[] args) {
		Test o1 = new Test(10);
		Test o2 = new Test(10);

		Runnable t1 = new Tester(o1, o2);
		new Thread(t1).start();

		Runnable t2 = new Tester(o2, o1);
		new Thread(t2).start();

	}

	public static class Tester implements Runnable {
		private static int nextId;
		private Test obj1;
		private Test obj2;
		private int id;

		public Tester(Test obj1, Test obj2) {
			this.obj1 = obj1;
			this.obj2 = obj2;
			id = nextId++;
		}

		@Override
		public void run() {
			// System.out.println("Thread: " + nextId);
			System.out.println("Thread: " + id + " Object value: "
					+ obj1.getValue());
			System.out.println("Thread: " + id + " Equality: "
					+ obj1.equals(obj2));
			// System.out.println("Thread: " + nextId);
		}

	}

	public static class Test {
		private int value;

		public Test(int value) {
			this.value = value;
		}

		public synchronized int getValue() {
			return value;
		}

		// @Override
		public synchronized boolean equals(Object obj) {
			if (obj instanceof Test) {
				// Thread.yield(); не гарантирует, что другой поток захватит
				// объект obj2;
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("in instanceof");
				return this.value == ((Test) obj).getValue();
			}
			return false;
		}
	}
}
