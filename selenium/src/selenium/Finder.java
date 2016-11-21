package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Finder extends SeleniumHelper {

	public String quizNameXPath = "//div[contains(@class,'quizTitle')]";
	public String questionBox = "quizQuestion";
	public String quizAnswerXPath = "//span[contains(@class,'answerText')]";
	public String quizAnswerBox = "//span[contains(.,'Stars')]/../span[contains(@class,'answerBox')]";
	public String nextQuestion = "nextQuestion";
	
	public String getQuestion(WebDriver driver) {
		return findElement(driver, By.className(questionBox)).getText();
	}

	public void solveQuiz(WebDriver driver) {
		System.out.print("Inside solveQuiz \n");
		driver.findElement(By.id("quizContainer"));
		System.out.print("quiz question is : " + getQuestion(driver));
	}
}