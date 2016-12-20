package selenium;
import quiz.AmericanPresidents;

public class EnumReverseLookUp extends AmericanPresidents {
	public static void main(String[] args) {
		AmericanPresidents americanPresidents = new AmericanPresidents();
		System.out.print(americanPresidents.getAnswer("Who was the 37th president of the United States?"));
	}
}