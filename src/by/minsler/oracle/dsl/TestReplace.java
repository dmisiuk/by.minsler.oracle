package by.minsler.oracle.dsl;

public class TestReplace {

	public static void main(String[] args) {
		String s = "123341253";
		String was = "1";
		String will = "2";
		s = s.replace(was, will);
		System.out.println(s);
	}

}
