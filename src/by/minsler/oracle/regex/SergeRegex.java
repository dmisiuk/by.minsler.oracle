package by.minsler.oracle.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SergeRegex {

	public static void main(String[] args) {

		String str = "=вес*елый= в*яселы\n";
		String regex = "(=)([а-яА-Я]*)(\\*[а-яА-Я]*)(=)(\\s)";
		Pattern pattern = Pattern.compile(regex);

		Matcher matcher = pattern.matcher(str);
		if (matcher.find()) {
			String partTo = matcher.group(2);
			String partAfter = matcher.group(3);
			System.out.print(partTo + "<i>" + partAfter.charAt(1) + "</i>"
					+ partAfter.substring(2, partAfter.length()));
		}

	}
}
