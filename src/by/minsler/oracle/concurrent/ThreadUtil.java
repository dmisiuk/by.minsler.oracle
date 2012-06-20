package by.minsler.oracle.concurrent;

public class ThreadUtil {

	public static void threadMessage(String str) {
		Thread currentThread = Thread.currentThread();
		System.out.println(currentThread + ": " + str);
	}
}
