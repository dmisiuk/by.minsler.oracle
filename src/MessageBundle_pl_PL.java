
import java.util.ListResourceBundle;

public class MessageBundle_pl_PL extends ListResourceBundle {

	static final Object[][] contents = { { "greetings", "dzen' dobry" },
			{ "inquary", "jak se mash" }, { "farewell", "do zobachenia" },
			{ "today", "dzisiaj" } };

	@Override
	protected Object[][] getContents() {
		return contents;
	}

}
