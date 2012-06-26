package by.minsler.oracle.i18n;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.util.Date;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class I18NSample {

	public static void main(String[] args) {

		String language;
		String cauntry;
		Double money = 234.5;
		Date today = new Date();

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
		DateFormat df = DateFormat.getDateInstance(DateFormat.LONG,
				currentLocale);

		try {
			rb = ResourceBundle.getBundle("MessageBundle", currentLocale);
			System.out.println(rb.getString("greetings"));
			System.out.println(rb.getString("inquary"));
			System.out.println(rb.getString("farewell"));
			System.out.println(nf.format(money));
			System.out.println(rb.getString("today") + ":" + df.format(today));
		} catch (MissingResourceException e) {
			System.out.println(e.getMessage());
		}

	}
}
