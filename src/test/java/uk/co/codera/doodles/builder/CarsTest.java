package uk.co.codera.doodles.builder;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static uk.co.codera.doodles.builder.CarTestDataBuilder.aFordMondeo;
import static uk.co.codera.doodles.builder.CarTestDataBuilder.aVwGolf;
import static uk.co.codera.doodles.builder.Cars.someCars;

import org.junit.Test;

public class CarsTest {

	@Test
	public void shouldReportSizeCorrectly() {
		assertThat(cars(aVwGolf(), aFordMondeo()).size(), is(2));
	}
	
	private Cars cars(Car.Builder... cars) {
		return someCars(cars).build();
	}
}