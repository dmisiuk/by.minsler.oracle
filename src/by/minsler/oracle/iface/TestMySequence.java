package by.minsler.oracle.iface;

public class TestMySequence {

	public static void main(String[] args) {
		MySequence ms = new MySequence("test string");
		System.out.println(ms.charAt(5));
		System.out.println(ms.subSequence(0, 4));
	}
}
