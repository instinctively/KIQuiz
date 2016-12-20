package quiz;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

import selenium.SeleniumHelper;

public class Dinosaurs extends SeleniumHelper {

	public String url = "https://www.freekigames.com/dinosaur-trivia";

	public enum Question {

		Triceratops("Which dinosaur most closely resembles a rhinoceros?", "Triceratops"),
		NotSure("What caused the extinction of dinosaurs according to scientists?", "Scientists are not 100% sure. There is still heavy debate."),
		LateTriassic("In what period did the Coelophysis live?", "Late Triassic"),
		Reptiles("Dinosaurs belonged to which group of animals?", "Reptiles"),
		Diplodocus("Which dinosaur had a long neck to help reach high and low vegetation?", "Diplodocus"),
		Paleontologist("What profession studies dinosaur fossils?", "Paleontologist"),
		ThreeHornedFace("What does the name 'Triceratops' mean?", "three-horned face"),
		LateCretaceousRex("In what period did the Tyrannosaurus live?", "Late Cretaceous"),
		Stegosaurus("Which of the following was not a flying reptile?", "Stegosaurus"),
		LateCretaceousTrike("In what period did the Triceratops live?", "Late Cretaceous"),
		DiplodocusHollow("Which dinosaur had hollow limb bones?", "Diplodocus"),
		SirRichardOwen("Who coined the term 'dinosauria?'", "Sir Richard Owen"),
		LateJurassicStego("In what period did the Stegosaurus live?", "Late Jurassic"),
		Mesozoic("In what era did dinosaurs live?", "Mesozoic"),
		Pterodactyl("Which of these is not a dinosaur?", "Pterodactyl"),
		Extinct("When did dinosaurs become extinct?", "65 million years ago"),
		LateJurassicDiplo("In what period did the Diplodocus live?", "Late Jurassic"),
		TerribleLizard("What does the word 'dinosaur' mean?", "Terrible Lizard"),
		Tyrannosaurus("Which carnivorous dinosaur had teeth up to 8 inches long?", "Tyrannosaurus"),
		Sauropods("The largest dinosaurs were __________________.", "Sauropods");

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