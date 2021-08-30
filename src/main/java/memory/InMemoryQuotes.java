package memory;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class InMemoryQuotes {
	private static List<String> quotes = Arrays.asList(
				"Be who you are and say what you feel, because those who mind don't matter, and those who matter don't mind.",
				"In three words I can sum up everything I've learned about life: it goes on.",
				"I've learned that people will forget what you said, people will forget what you did, but people will never forget how you made them feel.",
				"To be yourself in a world that is constantly trying to make you something else is the greatest accomplishment.",
				"It is better to be hated for what you are than to be loved for what you are not.",
				"It's supposed to be a challenge, that's why they call it a shortcut. If it was easy it would just be the way",
				"My name is Maximus Decimus Meridius, Commander of the Armies of the North, General of the Felix Legions, "
				+ "loyal servant to the true Emperor Marcus Aurelius, father to a murdered son, "
				+ "husband to a murdered wife – and I will have my vengeance, in this life or the next."
			);
	
	public static String[] getQuote() {
		int randomIndex = ThreadLocalRandom.current().nextInt(0, quotes.size());
		String quote = quotes.get(randomIndex);
		return quote.split(" ");
	}
}
