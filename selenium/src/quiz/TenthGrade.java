package quiz;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

import selenium.SeleniumHelper;

public class TenthGrade extends SeleniumHelper {

	public String url = "https://www.freekigames.com/tenth-grade-vocabulary-trivia";

	public enum Question {

		Malcontent("Malcontent", "person dissatisfied with existing state of affairs"),
		Phonetic("Phonetic", "related to the sounds in a language"),
		//Adjunct("Adjunct", "something attached to but holding an inferior position"),
		Adjunct("Adjunct", "something attached to but"),
		//Juncture("Juncture", "a joining together; the point at which two things are joined; any important point in time"),
		Juncture("Juncture", "the point at which two things are joined"),
		Dialogue("Dialogue", "a conversation between two persons"),
		Junction("Junction", "an act of joining or adjoining things"),
		Injunction("Injunction", "a formal command or admonition"),
		Malevolent("Malevolent", "wishing or appearing to wish evil to others"),
		Gregarious("Gregarious", "seeking and enjoying the company of others"),
		Malicious("Malicious", "wishing evil or harm upon others"),
		//Eloquent("Eloquent", "expressing yourself readily, clearly, effectively"),
		Eloquent("Eloquent", "expressing yourself readily"),
		//Malady("Malady", "a sickness, illness, disease, disorder"),
		Malady("Malady", "a sickness"),
		Congregate("Congregate", "To come together in a group, assemble."),
		Segregate("Segregate", "separating into different groups"),
		Soliloquy("Soliloquy", "the act of talking to oneself or a dramatic monologue");

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
		try {
			return Question.get(question).getAnswer();
		} catch (Exception e) {
			return null;
		}
	}
}
