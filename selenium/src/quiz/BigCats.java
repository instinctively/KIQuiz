package quiz;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

import selenium.SeleniumHelper;

public class BigCats extends SeleniumHelper {

	public String url = "https://www.freekigames.com/big-cats-trivia";

	public enum Question {

		Roar("One common way to determine what is considered a big cat, is a feline that can ________.", "Roar"),
		Carnivores("Big cats are ________.", "Carnivores"),
		Cheetah("Which big cat is in the genus Acinonyx?", "Cheetah"),
		SnowLeopard("Which big cat is in the genus Uncia?", "Snow Leopard"),
		CaspianTiger("Which type of tiger is extinct?", "Caspian Tiger"),
		BarbaryLion("Which of these lions are recently extinct?", "Barbary Lion"),
		Enrichment("Which of the following is not a criteria for an accredited US Fish & Wildlife Service animal sanctuary?", "Must provide enrichment activities for big cats"),
		Lion("Which is the only big cat that lives in groups?", "Lion"),
		Chinese("Tigers are often poached for their parts, used in traditional _________ medicine.", "Chinese"),
		Miles("How far can a lion's roar be heard from?", "5 miles"),
		CheetahRoar("Which of these big cats purrs instead of roars?", "Cheetah"),
		Cougar("Which big cat is in the genus Puma?", "Cougar");

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
