package uk.co.codera.doodles.builder;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static uk.co.codera.doodles.builder.CarTestDataBuilder.aFordMondeo;
import static uk.co.codera.doodles.builder.CarTestDataBuilder.aVwGolf;
import static uk.co.codera.doodles.builder.CarTestDataBuilder.aVwPassatt;
import static uk.co.codera.doodles.builder.Cars.someCars;

import org.junit.Test;

public class CarsTest {

	@Test
	public void shouldReportSizeCorrectly() {
		assertThat(cars(aVwGolf(), aFordMondeo()).size(), is(2));
	}
	
	@Test
	public void shouldBeAbleToFindCarsByExistingManufacturer() {
		Cars volkswagens = cars(aVwGolf(), aVwPassatt(), aFordMondeo()).findByManufacturer("VW");
		assertThat(volkswagens, hasItems(aVwGolf().build(), aVwPassatt().build()));
	}
	
	@Test
	public void findByManufacturerShouldBeCaseSensitive() {
		assertThat(cars(aVwGolf()).findByManufacturer("vw").size(), is(0));
	}
	
	private Cars cars(Car.Builder... cars) {
		return someCars(cars).build();
	}
}