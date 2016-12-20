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
		Seventy("A cheetah can run up to speeds of ____ miles an hour.", "70"),
		Enrichment("Which of the following is not a criteria for an accredited US Fish & Wildlife Service animal sanctuary?", "Must provide enrichment activities for big cats"),
		Lion("Which is the only big cat that lives in groups?", "Lion"),
		Chinese("Tigers are often poached for their parts, used in traditional _________ medicine.", "Chinese"),
		Miles("How far can a lion's roar be heard from?", "5 miles"),
		CheetahRoar("Which of these big cats purrs instead of roars?", "Cheetah"),
		Cougar("Which big cat is in the genus Puma?", "Cougar"),
		Poaching("The main threats to big cats are ___________.", "poaching and habitat destruction"),
		CheetahGenus("Which big cat is not in the genus Panthera?", "Cheetah"),
		Leopard("Which is the best climber of all the big cats?", "Leopard"),
		Amur("Which is the most endangered big cat?", "Amur Leopard"),
		BobCat("Which of the following is not considered a big cat?", "Bobcat"),
		Jaguar("Which big cat is named from the Native American word meaning he who kills with one leap", "Jaguar"),
		Tiger("Which of these big cats is an excellent swimmer who loves water?", "Tiger");

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
			for (Question q : EnumSet.allOf(Question.class))
				lookup.put(q.getQuestion(), q);
		}

		public static Question get(String question) {
			return (Question) lookup.get(question);
		}
	}

	public String getAnswer(String question) {
		try {
			question = question.replace("\"", "");
			return Question.get(question).getAnswer();
		} catch (Exception e) {
			return null;
		}
	}
}