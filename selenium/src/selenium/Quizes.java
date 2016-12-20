package selenium;

public enum Quizes {

	AmericanPresidents("american-presidents-trivia" , "americanPresidents"),
	BigCats("big-cats-trivia", "bigCats"),
	Dinosaurs("dinosaur-trivia", "dinosaurs"),
	FamousPoets("famous-poets", "famousPoets"),
	GeometricShapes("geometric-shapes-trivia", "geometricShapes"),
	Habitats("habitats-trivia", "habitats"),
	NinthGrade("ninth-grade-vocabulary-trivia", "ninthGrade"),
	SolarSystem("solar-system-trivia", "solarSystem"),
	TenthGrade("tenth-grade-vocabulary-trivia", "tenthGrade"),
	WorldCapitals("world-capitals-trivia", "worldCapitals");

	private String url, name;

	Quizes(String url, String name) {
		this.url = url;
		this.name = name;
	}

	public String getUrl() {
		return "https://www.freekigames.com/" + url;
	}

	public String getName() {
		return name;
	}
}