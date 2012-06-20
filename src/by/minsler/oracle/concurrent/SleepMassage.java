package by.minsler.oracle.concurrent;

public class SleepMassage {

	public static void main(String[] args) throws InterruptedException {
		String str = "the film is very good";
		String[] s = str.split(" ");
		for (String word : s) {
			System.out.print(word + " ");
			Thread.sleep(1000);
		}
	}
}
