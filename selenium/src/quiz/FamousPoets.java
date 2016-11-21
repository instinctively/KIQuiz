package quiz;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

import selenium.SeleniumHelper;

public class FamousPoets extends SeleniumHelper {

	public String url = "https://www.freekigames.com/famous-poets";

	public enum Question {

		LangstonHughes("Who wrote \"Life is Fine\"?", "Langston Hughes"),
		ShelSilverstein("Who wrote \"Messy Room\"?", "Shel Silverstein"),
		RobertFrost("Who wrote \"The Road Not Taken\"?", "Robert Frost"),
		LangstonHughesAmerica("Who Wrote \"Let America Be America Again\"?", "Langston Hughes"),
		PabloNeruda("Who Wrote \"If You Forget Me\"?", "Pablo Neruda"),
		EmilyDickinson("Who wrote \"There is Another Sky\"?", "Emily Dickinson"),
		MayaAngelou("Who wrote \"Phenomenal Woman\"?", "Maya Angelou"),
		EdgarAllanPoe("Who wrote \"A Dream Within A Dream\"?", "Edgar Allan Poe"),
		WHAuden("Who wrote \"Funeral Blues\"?", "W.H. Auden"),
		DylanThomas("Who wrote \"Do Not Go Gentle To That Good Night\"?", "Dylan Thomas"),
		EECummings("Who Wrote \"I Carry Your Heart With Me\"?", "E.E. Cummings"),
		ShelSilversteinSidewalk("Who wrote \"Where the Sidewalk Ends\"?", "Shel Silverstein");

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