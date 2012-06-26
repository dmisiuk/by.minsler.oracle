
import java.util.ListResourceBundle;

public class MessageBundle extends ListResourceBundle {

	static final Object[][] contents = { { "greetings", "Hello" },
			{ "inquary", "How are you?" }, { "farewell", "Good bye" } };

	@Override
	protected Object[][] getContents() {
		return contents;
	}

}
