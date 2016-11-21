package quiz;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

import selenium.SeleniumHelper;

public class WorldCapitals extends SeleniumHelper {

	public String url = "https://www.freekigames.com/world-capitals-trivia";
	public String quizAnswerBox = "//span[contains(.,'Stars')]/../span[contains(@class,'answerBox')]";


	public enum Question {
		Brussels("What is the capital of Belgium?", "Brussels"),
		Berlin("What is the capital of Germany?", "Berlin"),
		Canberra("What is the capital of Australia?", "Canberra"),
		Ottawa("What is the capital of Canada?", "Ottawa"),
		Tokyo("What is the capital of Japan?", "Tokyo"),
		Helsinki("What is the capital of Finland?", "Helsinki"),
		Nassau("What is the capital of The Bahamas?", "Nassau"),
		Prague("What is the capital of Czech Republic?", "Prague"),
		Havana("What is the capital of Cuba?", "Havana"),
		Brasilia("What is the capital of Brazil?", "Brasilia"),
		Vienna("What is the capital of Austria?", "Vienna"),
		NewDelhi("What is the capital of India?", "New Delhi"),
		Rome("What is the capital of Italy?", "Rome"),
		Cairo("What is the capital of Egypt?", "Cairo"),
		Budapest("What is the capital of Hungary?", "Budapest"),
		Copenhagen("What is the capital of Denmark?", "Copenhagen"),
		Beijing("What is the capital of China?", "Beijing");		

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
