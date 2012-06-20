package by.minsler.oracle.concurrent;

public class MessageLoop implements Runnable {

	@Override
	public void run() {
		String str = "my message from messgaeLoop";
		String[] words = str.split(" ");
		try {
			for (String word : words) {
				System.out.println(word);
				Thread.sleep(4000);
			}
		} catch (InterruptedException e) {
			ThreadUtil.threadMessage("I wasn't done");
		}
	}

}
