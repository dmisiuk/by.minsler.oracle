package by.minsler.oracle.i18n;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class I18NSample {

	public static void main(String[] args) {

		String language;
		String cauntry;
		Double money = 234.5;

		if (args.length == 2) {
			language = args[0];
			cauntry = args[1];
		} else {
			language = "en";
			cauntry = "US";
		}

		Locale currentLocale;
		ResourceBundle rb;

		currentLocale = new Locale(language, cauntry);
		NumberFormat nf = NumberFormat.getCurrencyInstance(currentLocale);

		try {
			rb = ResourceBundle.getBundle("MessageBundle", currentLocale);
			System.out.println(rb.getString("greetings"));
			System.out.println(rb.getString("inquary"));
			System.out.println(rb.getString("farewell"));
			System.out.println(nf.format(money));
		} catch (MissingResourceException e) {
			System.out.println(e.getMessage());
		}

	}
}
