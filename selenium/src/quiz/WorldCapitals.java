package quiz;

public class WorldCapitals {

	public String url = "https://www.freekigames.com/world-capitals-trivia";
	public String quizAnswerBox = "//span[contains(.,'Stars')]/../span[contains(@class,'answerBox')]";

	public enum Question {
		Brussels("What is the capital of Belgium?", "Brussels"),
		Berlin("What is the capital of Germany?", "Berlin"),
		Canberra("What is the capital of Australia?", "Canberra"),
		Tokyo("What is the capital of Japan?", "Tokyo"),
		helsinki("What is the capital of Finland?", "Helsinki"),
		Nassau("What is the capital of The Bahamas?", "Nassau"),
		Prague("What is the capital of Czech Republic?", "Prague"),
		Havana("What is the capital of Cuba?", "Havana"),
		Brasilia("What is the capital of Brazil?", "Brasilia"),
		Cairo("What is the capital of Egypt?", "Cairo"),
		Budapest("What is the capital of Hungary?", "Budapest"),
		Copenhagen("What is the capital of Denmark?", "Copenhagen "),
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
	}
}
