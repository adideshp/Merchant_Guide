
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
	
	public Analyzer analyzer;
	
	public Parser(Analyzer local_analyzer) {
		this.analyzer = local_analyzer;
	}
	
	public boolean parse_line(String input_line) {
		String DATASTORE_ROMAN_REGEX = "(\\w+)\\sis\\s([I|V|X|L|C|D|M]+)";
		String DATASTORE_CREDITS_REGEX = "([([a-z]+)\\s*]+)([A-Z][a-z]+)\\sis\\s(\\d+)\\sCredits";
		String QUESTION_BASIC_REGEX = "how\\smuch\\sis\\s([\\w+\\s*]+)\\s*\\?";
		String QUESTION_CREDITS_REGEX = "how\\smany\\sCredits\\sis\\s([[a-z]+\\s*]+)\\s([A-Z][a-z]+)\\s*\\?";
		
		Pattern DATASTORE_ROMAN_MATCH = Pattern.compile(DATASTORE_ROMAN_REGEX);
		Pattern DATASTORE_CREDITS_MATCH = Pattern.compile(DATASTORE_CREDITS_REGEX);
		Pattern QUESTION_BASIC_MATCH = Pattern.compile(QUESTION_BASIC_REGEX);
		Pattern QUESTION_CREDITS_MATCH = Pattern.compile(QUESTION_CREDITS_REGEX);
		
		
		Matcher Match_REGEX = DATASTORE_ROMAN_MATCH.matcher(input_line);
		if(Match_REGEX.matches()) {
			// Case 1 : glob is I
			// word is roman
			String word = Match_REGEX.group(1);
			String roman_number = Match_REGEX.group(2);
			return (analyzer.datastore_roman(word, roman_number));
		}
		
		Match_REGEX = DATASTORE_CREDITS_MATCH.matcher(input_line);
		if(Match_REGEX.matches()) {
			// Case 2: glob glob Silver is 34 Credits
			// words Capital word is number Credits
			String other_words = Match_REGEX.group(1);
			String special_word = Match_REGEX.group(2);
			String credits = Match_REGEX.group(3);
			return (analyzer.datastore_credits(other_words, special_word, credits));
		}
		
		Match_REGEX = QUESTION_BASIC_MATCH.matcher(input_line);
		if(Match_REGEX.matches()) {
			//Case 3: how much is pish tegj glob glob ?
			String other_words = Match_REGEX.group(1);
			String answer = analyzer.question_basic(other_words);
			System.out.println(answer);
			return true;
		}
		
		Match_REGEX = QUESTION_CREDITS_MATCH.matcher(input_line);
		if(Match_REGEX.matches()) {
			//Case 4: how many Credits is glob prok Iron ?
			String other_words = Match_REGEX.group(1);
			String special_word = Match_REGEX.group(2);
			String answer = analyzer.question_credits(other_words,special_word);
			System.out.println(answer);
			return false;
		}
		// Anything other than above matches is illegal
		System.out.println("I have no idea what you are talking about");
		return false;
	}
}
