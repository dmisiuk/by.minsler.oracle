package by.minsler.oracle.collection;

import java.util.Map;
import java.util.TreeMap;

public class TestMap {

	public static void main(String[] args) {
		Map<String, Integer> m1 = new TreeMap<String, Integer>();

		String str = new String(
				"диме нравиться играть на балалайке он очень любит есть пить играть и все остальное бб");
		fillMap(m1, str);

		System.out.println("distinct words: " + m1.size());

		Map<String, Integer> m2 = new TreeMap<String, Integer>();
		String str2 = new String("дима поехал играть на рыбалку и забыл все");

		fillMap(m2, str2);

		System.out.println("words: " + m1);
		System.out.println("words: " + m2);
		m1.putAll(m2);
		System.out.println("words: " + m1);
		System.out.println(m1.keySet());
		m1.keySet().removeAll(m2.keySet());
		System.out.println(m1);

	}

	private static void fillMap(Map<String, Integer> m, String str) {
		String[] a = str.split(" ");

		for (String word : a) {
			Integer freq = m.get(word);
			m.put(word, (freq == null) ? 1 : freq + 1);
		}
	}
}
