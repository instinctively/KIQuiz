package quiz;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

import selenium.SeleniumHelper;

public class NinthGrade extends SeleniumHelper {

	public String url = "https://www.freekigames.com/ninth-grade-vocabulary-trivia";

	public enum Question {

		Mar("Mar", "a mark or flaw that spoils the appearance of something (especially on a person's body)"),
		Advocate("Advocate", "a person who pleads for a cause or propounds an idea"),
		Tangible("Tangible", "possible to be treated as fact"),
		Abstract("Abstract", "a concept or idea not associated with any specific instance"),
		Censure("Censure", "harsh criticism or disapproval"),
		Deference("Deference", "a disposition or tendency to yield to the will of others"),
		Comply("Comply", "act in accordance with someone's rules, commands, or wishes"),
		Heed("Heed", "paying particular notice (as to children or helpless people)	"),
		Eccentric("Eccentric", "a person of a specified kind (usually with many eccentricities)"),
		Parsimony("Parsimony", "extreme care in spending money"),
		Inadvertent("Inadvertent", "without intention (especially resulting from heedless action)"),
		Guile("Guile", "shrewdness as demonstrated by being skilled in deception");

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