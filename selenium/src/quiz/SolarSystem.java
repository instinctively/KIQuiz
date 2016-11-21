package quiz;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

import selenium.SeleniumHelper;

public class SolarSystem extends SeleniumHelper {

	public String url = "https://www.freekigames.com/solar-system-trivia";

	public enum Question {

		Mercury("Which planet is closest to the sun?", "Mercury"),
		Asteroids("What separates the inner and outer solar system?", "Band of asteroids"),
		DirtyIce("What are comets made of?", "Dirty Ice"),
		Neptune("Which planet is furthest from the sun?", "Neptune"),
		Rings("Saturn is famous for its ________ that rotate around it.", "Rings"),
		Jupiter("What is the largest planet in the solar system?", "Jupiter"),
		Hurricane("Jupiter has a ________ in its atmosphere but no solid surface.", "Hurricane"),
		DwarfPlanet("What is the correct term for Pluto?", "Dwarf Planet"),
		Red("Mars is known as the _____ planet.", "Red"),
		Blue("Uranus has a _______ glow to it", "Blue"),
		Eight("How many planets are in our solar system?", "Eight"),
		VenusMars("Which two planets are Earth's \"neighbors\"?", "Venus & Mars");

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