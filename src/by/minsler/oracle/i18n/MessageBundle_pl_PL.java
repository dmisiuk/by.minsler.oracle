package by.minsler.oracle.i18n;

import java.util.ListResourceBundle;

public class MessageBundle_pl_PL extends ListResourceBundle {

	static final Object[][] contents = { { "greetings", "dzen' dobry" },
			{ "inquary", "jak se mash" }, { "farewell", "do zobachenia" } };

	@Override
	protected Object[][] getContents() {
		return contents;
	}

}
