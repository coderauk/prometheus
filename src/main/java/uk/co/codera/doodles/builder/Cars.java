package uk.co.codera.doodles.builder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class Cars implements Iterable<Car> {

	private final List<Car> cars;

	/**
	 * <p>
	 * Constructor is private, can only create instances via the builder or another Cars instance.
	 * </p>
	 */
	private Cars(Builder builder) {
		this(builder.cars);
	}
	
	/**
	 * <p>
	 * Constructor is private, can only create instances via the builder or another Cars instance.
	 * </p>
	 */
	private Cars(List<Car> cars) {
		/*
		 * Take defensive copy of list passed in and make it unmodifiable. don't
		 * want clients to be able to modify the immutable
		 * object.
		 */
		this.cars = Collections.unmodifiableList(new ArrayList<>(cars));
	}
	
	public static Cars.Builder someCars() {
		return new Builder();
	}

	public static Cars.Builder someCars(Car.Builder... carBuilders) {
		Builder cars = someCars();
		for (Car.Builder carBuilder : carBuilders) {
			cars.with(carBuilder);
		}
		return cars;
	}
	
	
	public Cars findByManufacturer(String manufacturer) {
		return new Cars(this.cars.stream().filter(c -> c.getManufacturer().equals(manufacturer)).collect(Collectors.toList()));
	}
	
	@Override
	public Iterator<Car> iterator() {
		return this.cars.iterator();
	}

	public int size() {
		return this.cars.size();
	}

	public static class Builder {

		private final List<Car> cars;

		/**
		 * Can only get the builder using the static method on the class we are
		 * building.
		 */
		private Builder() {
			this.cars = new ArrayList<>();
		}

		/**
		 * Work with the Car.Builder rather than the sealed object. Makes the
		 * client code more readable.
		 * 
		 * @param car
		 *            the car builder.
		 * @return the builder instance so we can chain methods.
		 */
		public Builder with(Car.Builder car) {
			this.cars.add(car.build());
			return this;
		}

		public Cars build() {
			return new Cars(this);
		}
	}
}