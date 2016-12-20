package quiz;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

import selenium.SeleniumHelper;

public class AmericanPresidents extends SeleniumHelper {

	public String url = "https://www.freekigames.com/american-presidents-trivia";

	public enum Question {

		GeorgeWashington("Who was the 1st president of the United States?", "George Washington"), 
		JohnAdams("Who was the 2nd president of the United States?","John Adams"), 
		ThomasJefferson("Who was the 3rd president of the United States?","Thomas Jefferson"), 
		JamesMadison("Who was the 4th president of the United States?","James Madison"), 
		JamesMonroe("Who was the 5th president of the United States?","James Monroe"), 
		JohnQuincyAdams("Who was the 6th president of the United States?","John Quincy Adams"), 
		AndrewJackson("Who was the 7th president of the United States?","Andrew Jackson"), 
		MartinVanBuren("Who was the 8th president of the United States?","Martin Van Buren"), 
		WilliamHenryHarrison("Who was the 9th president of the United States?","William Henry Harrison"), 
		JohnTyler("Who was the 10th president of the United States?","John Tyler"), 
		JamesKPolk("Who was the 11th president of the United States?","James K. Polk"), 
		ZacharyTaylor("Who was the 12th president of the United States?","Zachary Taylor"), 
		MillardFillmore("Who was the 13th president of the United States?","Millard Fillmore"), 
		FranklinPierce("Who was the 14th president of the United States?","Franklin Pierce"), 
		JamesBuchnan("Who was the 15th president of the United States?","James Buchanan"), 
		AbrahamLincoln("Who was the 16th president of the United States?","Abraham Lincoln"), 
		AndrewJohnson("Who was the 17th president of the United States?","Andrew Johnson"), 
		UlyssesSGrant("Who was the 18th president of the United States?","Ulysses S. Grant"), 
		RutherfordBHayes("Who was the 19th president of the United States?","Rutherford B. Hayes"), 
		JamesAGarfield("Who was the 20th president of the United States?","James A. Garfield"), 
		ChesterAArthur("Who was the 21st president of the United States?","Chester A. Arthur"), 
		GroverCleveland("Who was the 22nd president of the United States?","Grover Cleveland"), 
		BenjaminHarrison("Who was the 23rd president of the United States?","Benjamin Harrison"), 
		GroverCleveland24("Who was the 24th president of the United States?","Grover Cleveland"), 
		WilliamMcKinley("Who was the 25th president of the United States?","William McKinley"), 
		TheodoreRoosevelt("Who was the 26th president of the United States?","Theodore Roosevelt"), 
		WilliamHowardTaft("Who was the 27th president of the United States?","William Howard Taft"), 
		WoodrowWilson("Who was the 28th president of the United States?","Woodrow Wilson"), 
		WarrenGHarding("Who was the 29th president of the United States?","Warren G. Harding"), 
		CalvinCoolidge("Who was the 30th president of the United States?","Calvin Coolidge"), 
		HerbertHoover("Who was the 31st president of the United States?","Herbert Hoover"), 
		FranklinDRoosevelt("Who was the 32nd president of the United States?","Franklin D. Roosevelt"), 
		HarrySTruman("Who was the 33rd president of the United States?","Harry S. Truman"), 
		DwightDEisenhower("Who was the 34th president of the United States?","Dwight D. Eisenhower"), 
		JohnFKennedy("Who was the 35th president of the United States?","John F. Kennedy"), 
		LyndonBJohnson("Who was the 36th president of the United States?","Lyndon B. Johnson"), 
		RichardNixon("Who was the 37th president of the United States?","Richard Nixon"), 
		GeraldFord("Who was the 38th president of the United States?","Gerald Ford"), 
		JimmyCarter("Who was the 39th president of the United States?","Jimmy Carter"), 
		RonaldReagan("Who was the 40th president of the United States?","Ronald Reagan"), 
		GeorgeHWBush("Who was the 41st president of the United States?","George H. W. Bush"), 
		BillClinton("Who was the 42nd president of the United States?","Bill Clinton"), 
		GeorgeWBush("Who was the 43rd president of the United States?","George W. Bush"), 
		BarackObama("Who was the 44th president of the United States?","Barack Obama");

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
			return Question.get(question).getAnswer();
		} catch (Exception e) {
			return null;
		}
	}
}
