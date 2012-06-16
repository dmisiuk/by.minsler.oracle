package by.minsler.oracle.collection;

import java.util.HashSet;
import java.util.Set;

public class TestSet {

	public static void main(String[] args) {

		Set<String> s = new HashSet<String>();
		s.add(String.valueOf(110));
		s.add("daima'");
		s.add("ooo");
		s.add("01");
		System.out.println(s);

	}
}
