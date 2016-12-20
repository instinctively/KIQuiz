package selenium;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.google.api.services.vision.v1.Vision;
import com.google.api.services.vision.v1.model.EntityAnnotation;

import quiz.AmericanPresidents;
import quiz.BigCats;
import quiz.Dinosaurs;
import quiz.FamousPoets;
import quiz.GeometricShapes;
import quiz.Habitats;
import quiz.NinthGrade;
import quiz.SolarSystem;
import quiz.TenthGrade;
import quiz.WorldCapitals;

public class Solver extends SeleniumHelper {

	public static String quizNameXPath = "//div[contains(@class,'quizTitle')]";
	public static String questionBox = "quizQuestion";
	public static String quizAnswerXPath = "//span[contains(@class,'answerText')]";
	public static String quizAnswerBox = "//span[contains(.,'Stars')]/../span[contains(@class,'answerBox')]";
	public static String nextQuestion = "nextQuestion";
	public static String captchaElement = "//body[@id='bodyId']//img[@id='captchaImage']";
	public static String loginLink = "//div[@class='quizContainer']/a[@class='loginitem']";



	public static AmericanPresidents americanPresidents = new AmericanPresidents();
	public static BigCats bigCats = new BigCats();
	public static Dinosaurs dinosaurs = new Dinosaurs();
	public static FamousPoets famousPoets = new FamousPoets();
	public static GeometricShapes geometricShapes = new GeometricShapes();
	public static Habitats habitats = new Habitats();
	public static NinthGrade ninthGrade = new NinthGrade();
	public static SolarSystem solarSystem = new SolarSystem();
	public static TenthGrade tenthGrade = new TenthGrade();
	public static WorldCapitals worldCapitals = new WorldCapitals();



	public static String getQuestion(WebDriver driver) {
		return findElement(driver, By.className(questionBox)).getText();
	}

	public static void pickAnswer(WebDriver driver, String answer) {
		System.out.println("Picking answer : " + answer);
		String answerBox = "//span[contains(.,'" + answer + "')]/../span[@class='answerBox']";
		if (answer != null) {
			click(driver, By.xpath(answerBox));

			clickNextQuestion(driver);
		} else {
			Random rn = new Random();
			int rand = rn.nextInt(3);
			System.out.println("Didn't find answer. Clicking random answer : " + rand);
			List<WebElement> findElements = driver
					.findElements(By.xpath("//span[contains(.,'')]/../span[@class='answerBox']"));
			findElements.get(rand).click();
			clickNextQuestion(driver);
		}
	}

	/*
	 * uses google vision API to try and solve captcha
	 * 
	 */
	public static String solveCaptcha(WebDriver driver, By by) throws IOException {
		String filePath = captureElementScreenShot(driver, findElement(driver, By.xpath(captchaElement))).getAbsolutePath();
		final Vision vision = null;
		Path imagePath = Paths.get(filePath);
		Label label = new Label(vision);
		List<EntityAnnotation> imageLabels = label.labelImage(imagePath, 1);
		List<String> labels = Label.getLabels(System.out, imagePath, imageLabels);
		String captcha = labels.get(0);
		return captcha;

	}

	public static void clickNextQuestion(WebDriver driver) {
		if (driver.findElement(By.id(nextQuestion)) != null)
			click(driver, By.id(nextQuestion));
	}

	public static void solveGeometricShapes(WebDriver driver) {
		for (int i = 0; i < 12; i++) {
			waitForWebElementVisible(driver, By.id("nextQuestion"));
			System.out.println("Solving question number : " + (i+1));
			driver.findElement(By.id("quizContainer"));
			String question = driver.findElement(By.xpath("//div[@class='quizQuestion']/img")).getAttribute("src");
			System.out.println("Question is : " + question);

			String answer = geometricShapes.getAnswer(question);
			System.out.println("Answer is : " + answer);
			pickAnswer(driver, answer);
		}
	}

	public static void solveQuiz(WebDriver driver, String quiz) throws IOException {

		System.out.println("Inside solveQuiz \n");
		switch(quiz) {
		case "americanPresidents" :
			System.out.println("solving : " + quiz);
			for (int i = 0; i < 12; i++) {
				waitForWebElementVisible(driver, By.id("nextQuestion"));
				System.out.println("Solving question number : " + (i+1));
				driver.findElement(By.id("quizContainer"));
				String question = getQuestion(driver);
				System.out.println("Question is : " + question);

				String answer = americanPresidents.getAnswer(question);
				System.out.println("Answer is : " + answer);
				pickAnswer(driver, answer);
			}
			break;
		case "bigCats" : 
			System.out.println("solving : " + quiz);
			for (int i = 0; i < 12; i++) {
				waitForWebElementVisible(driver, By.id("nextQuestion"));
				System.out.println("Solving question number : " + (i+1));
				driver.findElement(By.id("quizContainer"));
				String question = getQuestion(driver);
				System.out.println("Question is : " + question);

				String answer = bigCats.getAnswer(question);
				System.out.println("Answer is : " + answer);
				pickAnswer(driver, answer);
			}
			break;
		case "dinosaurs" : 
			System.out.println("solving : " + quiz);
			for (int i = 0; i < 12; i++) {
				waitForWebElementVisible(driver, By.id("nextQuestion"));
				System.out.println("Solving question number : " + (i+1));
				driver.findElement(By.id("quizContainer"));
				String question = getQuestion(driver);
				System.out.println("Question is : " + question);

				String answer = dinosaurs.getAnswer(question);
				System.out.println("Answer is : " + answer);
				pickAnswer(driver, answer);
			}
			break;
		case "famousPoets" : 
			System.out.println("solving : " + quiz);
			for (int i = 0; i < 12; i++) {
				waitForWebElementVisible(driver, By.id("nextQuestion"));
				System.out.println("Solving question number : " + (i+1));
				driver.findElement(By.id("quizContainer"));
				String question = getQuestion(driver);
				System.out.println("Question is : " + question);

				String answer = famousPoets.getAnswer(question);
				System.out.println("Answer is : " + answer);
				pickAnswer(driver, answer);
			}
			break;
		case "geometricShapes" :
			System.out.println("solving : " + quiz);
			solveGeometricShapes(driver);
			break;
		case "habitats" : 
			System.out.println("solving : " + quiz);
			for (int i = 0; i < 12; i++) {
				waitForWebElementVisible(driver, By.id("nextQuestion"));
				System.out.println("Solving question number : " + (i+1));
				driver.findElement(By.id("quizContainer"));
				String question = getQuestion(driver);
				System.out.println("Question is : " + question);

				String answer = habitats.getAnswer(question);
				System.out.println("Answer is : " + answer);
				pickAnswer(driver, answer);
			}
			break;
		case "ninthGrade" : 
			System.out.println("solving : " + quiz);
			for (int i = 0; i < 12; i++) {
				waitForWebElementVisible(driver, By.id("nextQuestion"));
				System.out.println("Solving question number : " + (i+1));
				driver.findElement(By.id("quizContainer"));
				String question = getQuestion(driver);
				System.out.println("Question is : " + question);

				String answer = ninthGrade.getAnswer(question);
				System.out.println("Answer is : " + answer);
				pickAnswer(driver, answer);
			}
			break;
		case "solarSystem" : 
			System.out.println("solving : " + quiz);
			for (int i = 0; i < 12; i++) {
				waitForWebElementVisible(driver, By.id("nextQuestion"));
				System.out.println("Solving question number : " + (i+1));
				driver.findElement(By.id("quizContainer"));
				String question = getQuestion(driver);
				System.out.println("Question is : " + question);

				String answer = solarSystem.getAnswer(question);
				System.out.println("Answer is : " + answer);
				pickAnswer(driver, answer);
			}
			break;
		case "tenthGrade" : 
			System.out.println("solving : " + quiz);
			for (int i = 0; i < 12; i++) {
				waitForWebElementVisible(driver, By.id("nextQuestion"));
				System.out.println("Solving question number : " + (i+1));
				driver.findElement(By.id("quizContainer"));
				String question = getQuestion(driver);
				System.out.println("Question is : " + question);

				String answer = tenthGrade.getAnswer(question);
				System.out.println("Answer is : " + answer);
				pickAnswer(driver, answer);
			}
			break;
		case "worldCapitals" : 
			System.out.println("solving : " + quiz);
			for (int i = 0; i < 12; i++) {
				waitForWebElementVisible(driver, By.id("nextQuestion"));
				System.out.println("Solving question number : " + (i+1));
				driver.findElement(By.id("quizContainer"));
				String question = getQuestion(driver);
				System.out.println("Question is : " + question);

				String answer = worldCapitals.getAnswer(question);
				System.out.println("Answer is : " + answer);
				pickAnswer(driver, answer);
			}
			break;
		}

		waitForWebElementVisible(driver, By.xpath(loginLink));
		click(driver, By.xpath(loginLink));
		sleep(3000);
		driver.switchTo().frame(driver.findElement(By.xpath("//body[@id='bodyId']")));
		driver.findElement(By.xpath(captchaElement));
		solveCaptcha(driver, By.xpath(captchaElement));
	}
}