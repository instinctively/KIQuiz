package quiz;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

import selenium.SeleniumHelper;

public class AmericanPresidents extends SeleniumHelper {

	public String url = "https://www.freekigames.com/american-presidents-trivia";

	public enum Question {

		CalvinCoolidge("Who was the 30th president of the United States?", "Calvin Coolidge"),
		HerbertHoover("Who was the 31st president of the United States?", "Herbert Hoover"),
		GroverCleveland("Who was the 22nd president of the United States?", "Grover Cleveland"),
		HarrySTruman("Who was the 33rd president of the United States?", "Harry S. Truman"),
		TheodoreRoosevelt("Who was the 26th president of the United States?", "Theodore Roosevelt"),
		DwightDEisenhower("Who was the 34th president of the United States?", "Dwight D. Eisenhower"),
		FranklinDRoosevelt("Who was the 32nd president of the United States?", "Franklin D. Roosevelt"),
		JohnQuincyAdams("Who was the 6th president of the United States?", "John Quincy Adams"),
		JamesKPolk("Who was the 11th president of the United States?", "James K. Polk"),
		FranklinPierce("Who was the 14th president of the United States?", "Franklin Pierce"),
		WilliamHowardTaft("Who was the 27th president of the United States?", "William Howard Taft"),
		JimmyCarter("Who was the 39th president of the United States?", "Jimmy Carter");

		private String question;
		private String answer;

		Question(String question, String answer) {
			this.question = question;
			this.answer = answer;
		}	
		public String getQuestion() {
			return question;
		}	
		public String getAnswer() {
			return answer;
		}

		private static final Map<String, Question> lookup = new HashMap<String, Question>();
		
		static {
			for(Question q: EnumSet.allOf(Question.class))
				lookup.put(q.getQuestion(), q);
		}
		public static Question get(String question) {
		    return (Question) lookup.get(question);
		  }
	}

	public String getAnswer(String question) {
		Question.get(question);
		return Question.get(question).toString();
	}
}
