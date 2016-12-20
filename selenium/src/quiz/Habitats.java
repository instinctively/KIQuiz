package quiz;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

import selenium.SeleniumHelper;

public class Habitats extends SeleniumHelper {

	public String url = "https://www.freekigames.com/habitats-trivia";

	public enum Question {

		Streams("How are freshwater lakes and rivers created?", "Streams high in the Mountains that flow down"),
		Rainforest("Which habitat is found in tropical regions?", "Rainforest"),
		Bottle("Which of the following is NOT a habitat?", "Bottle"),
		WarmWetHumid("What kind of a climate does a swamp have?", "Warm, wet, humid"),
		Ocean("What is the largest habitat on the planet?", "Ocean"),
		Desert("What is the habitat that has little rain and intense sunshine?", "Desert"),
		MountainsOcean("Which of the following is NOT part of the Ocean landscape?", "Mountains"),
		ConiferousForest("Which habitat has trees with needle shaped leaves?", "Coniferous Forest"),
		HabitatDefinition("What is a habitat?", "The natural home or environment of an animal, plant, or other organism."),
		Antarctica("Which continent does NOT have Grasslands?", "Antarctica"),
		Bear("Which is a large predator that lives in Coniferous Forests?", "Bear"),
		Tundra("What is the coldest habitat?", "Tundra"),
		Temperate("Which type of habitat can be found in all ranges of climate?", "Temperate Forests"),
		Mountains("Which habitat do animals have to withstand lower oxygen levels?", "Mountains"),
		OceanWhale("The largest animal in the world, the blue whale, resides in which habitat?", "Ocean"),
		Nocturnal("Animals in the desert have adopted a ___________ lifestyle to survive the heat.", "Nocturnal"),
		Cactus("What type of plant grows in the desert?", "Cactus"),
		CoralReef("Which of the following is NOT a habitat found on land?", "Coral Reef");

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