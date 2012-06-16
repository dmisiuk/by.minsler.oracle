package by.minsler.oracle.collection;

import java.util.HashSet;
import java.util.Set;

public class FindDups {

	public static void main(String[] args) {

		Set<String> uniquies = new HashSet<String>();
		Set<String> dups = new HashSet<String>();

		String str = "dima i kk ak   i  10 12 10";
		String[] myArgs = str.split(" ");
		for (String s : myArgs) {
			if (!uniquies.add(s)) {
				dups.add(s);
			}
		}
		uniquies.removeAll(dups);
		System.out.println("uniquies: " + uniquies);
		System.out.println("dups: " + dups);

	}
}
