
public class Analyzer {
	public Data_Store data_store;
	public Roman_Handler roman_handler;
	
	public Analyzer(Data_Store data_store) {
		this.data_store = data_store;
		this.roman_handler = new Roman_Handler();
	}
	
	public boolean datastore_roman(String word, String roman_number) {
		// This will handle the case1
		return (this.data_store.set_data(word, roman_number));
	}

	public boolean datastore_credits(String other_words, String special_words, String credits) {
		// This will handle case2
		/*Step1 : Compute value of all the other words together
		 * Step2: Calculate the value for special word using above computed value and credits
		 * Step3: Store special word in data_store
		 * */
		
		String [] splitted_words = other_words.split(" ");
		String roman_letter_string = "";
		for (int counter=0; counter < splitted_words.length; counter++){
			String temp = this.data_store.get_data(splitted_words[counter]);
			if (temp !=null) {roman_letter_string = roman_letter_string + temp;}
			else {System.out.println("I have no idea what you are talking about");
			return false;
			}
		}
		int decimal_equivalent = this.roman_handler.get_decimal_equivalent(roman_letter_string);
		int int_credits = Integer.parseInt(credits);
		float value_of_special_word = (float) int_credits/decimal_equivalent;
		
		return (this.data_store.set_data(special_words, Float.toString(value_of_special_word)));
	}

	public String question_basic(String other_words) {
		// This handles case3
		String [] splitted_words = other_words.split(" ");
		String roman_letter_string = "";
		for (int counter=0; counter < splitted_words.length; counter++){
			String temp = this.data_store.get_data(splitted_words[counter]);
			if (temp != null) {roman_letter_string = roman_letter_string + temp;}
			else {String answer = "I have no idea what you are talking about"; return answer;}
		}
		int decimal_equivalent = this.roman_handler.get_decimal_equivalent(roman_letter_string);
		String answer = other_words + " is " + decimal_equivalent;
		return answer;
	}

	public String question_credits(String other_words, String special_word) {
		// This handles case4
		/*Step1 : Compute value of all the other words together
		 * Step2: Calculate the value for special word using above computed value and credits
		 * Step3: Store special word in data_store
		 * */
		
		String [] splitted_words = other_words.split(" ");
		String roman_letter_string = "";
		for (int counter=0; counter < splitted_words.length; counter++){
			String temp = this.data_store.get_data(splitted_words[counter]);
			if (temp != null) {roman_letter_string = roman_letter_string + temp;}
			else {String answer = "I have no idea what you are talking about"; return answer;}
		}
		int decimal_equivalent = this.roman_handler.get_decimal_equivalent(roman_letter_string);
		try {
			float value_of_special_word = Float.parseFloat(this.data_store.get_data(special_word));
			float value = value_of_special_word*decimal_equivalent;
			String answer = other_words + " " + special_word + " is " + Float.toString(value) + " Credits";
			return answer;
		} catch (NullPointerException e) {
			String answer = "I have no idea what you are talking about"; return answer;
		}
	}

}
