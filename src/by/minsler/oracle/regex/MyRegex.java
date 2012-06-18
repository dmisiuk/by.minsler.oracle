package by.minsler.oracle.regex;

import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MyRegex {

	public static void main(String[] args) {

		Pattern anyChar = Pattern.compile("[a-zA-Zа-яА-Я]");
		Pattern anyWord = Pattern.compile("[a-zA-Zа-яА-Я]+");

		// [(([a-zA-Zа-яА-Я])+(\\-)?([a-zA-Zа-яА-Я])+)
		String str = "a Мой самы любый текстовы редактор  - Notepad++ супер-пупер zc-";
		Matcher matcher = anyChar.matcher(str);

		Map<String, Integer> characters = new TreeMap<String, Integer>();

		while (matcher.find()) {
			Integer freq = characters.get(matcher.group());
			characters.put(matcher.group(), (freq == null) ? 1 : freq + 1);
		}

		matcher = anyWord.matcher(str);

		Map<String, Integer> words = new TreeMap<String, Integer>();

		while (matcher.find()) {
			Integer freq = words.get(matcher.group());
			words.put(matcher.group(), (freq == null) ? 1 : freq + 1);
		}

		System.out.println("words: " + words);
		System.out.println("characters: " + characters);

	}
}
