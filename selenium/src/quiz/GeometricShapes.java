package quiz;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

import selenium.SeleniumHelper;

public class GeometricShapes extends SeleniumHelper {

	public String url = "https://www.freekigames.com/geometric-shapes-trivia";

	public enum Question {
		
		Circle("https://edgecast.freekigames.com/image/free/FreeKIGames/Images/Quizzes/geometric-shapes1.jpg?v=1", "Circle"),
		Oval("https://edgecast.freekigames.com/image/free/FreeKIGames/Images/Quizzes/geometric-shapes2.jpg?v=1", "Oval"),
		Crescent("https://edgecast.freekigames.com/image/free/FreeKIGames/Images/Quizzes/geometric-shapes3.jpg?v=1", "Crescent"),
		CurvilinearTriangle("https://edgecast.freekigames.com/image/free/FreeKIGames/Images/Quizzes/geometric-shapes4.jpg?v=1", "Curvilinear Triangle"),
		Quatrefoil("https://edgecast.freekigames.com/image/free/FreeKIGames/Images/Quizzes/geometric-shapes5.jpg?v=1", "Quatrefoil"),
		Parallelogram("https://edgecast.freekigames.com/image/free/FreeKIGames/Images/Quizzes/geometric-shapes6.jpg?v=1", "Parallelogram"),
		Square("https://edgecast.freekigames.com/image/free/FreeKIGames/Images/Quizzes/geometric-shapes7.jpg?v=1", "Square"),
		Rectangle("https://edgecast.freekigames.com/image/free/FreeKIGames/Images/Quizzes/geometric-shapes8.jpg?v=1", "Rectangle"),
		Trapezium("https://edgecast.freekigames.com/image/free/FreeKIGames/Images/Quizzes/geometric-shapes9.jpg?v=1", "Trapezium"),
		Trapezoid("https://edgecast.freekigames.com/image/free/FreeKIGames/Images/Quizzes/geometric-shapes10.jpg?v=1", "Trapezoid"),
		Triangle("https://edgecast.freekigames.com/image/free/FreeKIGames/Images/Quizzes/geometric-shapes11.jpg?v=1", "Triangle"),
		Kite("https://edgecast.freekigames.com/image/free/FreeKIGames/Images/Quizzes/geometric-shapes12.jpg?v=1", "Kite"),
		Pentagon("https://edgecast.freekigames.com/image/free/FreeKIGames/Images/Quizzes/geometric-shapes13.jpg?v=1", "Pentagon"),
		Rhombus("https://edgecast.freekigames.com/image/free/FreeKIGames/Images/Quizzes/geometric-shapes14.jpg?v=1", "Rhombus"),
		Hexagon("https://edgecast.freekigames.com/image/free/FreeKIGames/Images/Quizzes/geometric-shapes15.jpg?v=1", "Hexagon"),
		Octagon("https://edgecast.freekigames.com/image/free/FreeKIGames/Images/Quizzes/geometric-shapes16.jpg?v=1", "Octagon"),
		Heptagon("https://edgecast.freekigames.com/image/free/FreeKIGames/Images/Quizzes/geometric-shapes17.jpg?v=1", "Heptagon"),
		Nonagon("https://edgecast.freekigames.com/image/free/FreeKIGames/Images/Quizzes/geometric-shapes18.jpg?v=1", "Nonagon");

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
