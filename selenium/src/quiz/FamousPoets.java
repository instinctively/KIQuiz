package quiz;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

import selenium.SeleniumHelper;

public class FamousPoets extends SeleniumHelper {

	public String url = "https://www.freekigames.com/famous-poets";

	public enum Question {

		LangstonHughes("who wrote life is fine?", "Langston Hughes"),
		ShelSilverstein("who wrote messy room?", "Shel Silverstein"),
		RobertFrost("who wrote the road not taken?", "Robert Frost"),
		LangstonHughesAmerica("who wrote let america be america again?", "Langston Hughes"),
		PabloNeruda("who wrote if you forget me?", "Pablo Neruda"),
		RoberFrost("who wrote stopping by the woods on a snowy evening?", "Robert Frost"),
		EzraPound("who wrote a girl?", "Ezra Pound"),
		WaltWhitman("who wrote to you?", "Walt Whitman"),
		EmilyDickinsonSky("who wrote there is another sky?", "Emily Dickinson"),
		MayaAngelou("who wrote phenomenal woman?", "Maya Angelou"),
		EdgarAllanPoe("who wrote a dream within a dream?", "Edgar Allan Poe"),
		EmilyDickinson("who wrote if those i loved were lost?", "Emily Dickinson"),
		WHAuden("who wrote funeral blues?", "W.H. Auden"),
		DylanThomas("who wrote do not go gentle to that good night?", "Dylan Thomas"),
		EECummings("who wrote i carry your heart with me?", "E.E. Cummings"),
		ShelSilversteinSidewalk("who wrote where the sidewalk ends?", "Shel Silverstein");

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
			question = question.replace("\"", "").toLowerCase();
			System.out.println("changed question is : " + question);
			return Question.get(question).getAnswer();
		} catch (Exception e) {
			return null;
		}
	}
}