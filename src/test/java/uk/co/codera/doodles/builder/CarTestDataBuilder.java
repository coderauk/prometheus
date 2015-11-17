package uk.co.codera.doodles.builder;

public class CarTestDataBuilder {

	public static final String MANUFACTURER_VW = "VW";
	public static final String MANUFACTURER_FORD = "Ford";
	
	public static Car.Builder aVwGolf() {
		return aVw().model("Golf");
	}
	
	public static Car.Builder aVwPassatt() {
		return aVw().model("Passatt");
	}
	
	public static Car.Builder aFordMondeo() {
		return aFord().model("Mondeo");
	}
	
	public static Car.Builder aVw() {
		return Car.aCar().manufacturer(MANUFACTURER_VW);
	}
	
	public static Car.Builder aFord() {
		return Car.aCar().manufacturer(MANUFACTURER_FORD);
	}
}