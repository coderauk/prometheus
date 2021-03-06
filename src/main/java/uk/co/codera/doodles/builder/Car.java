package uk.co.codera.doodles.builder;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class Car {

	/*
	 * Member variables of class are final.
	 */
	private final String manufacturer;
	private final String model;

	/**
	 * <p>
	 * Constructor is private, can only create instances via the builder.
	 * </p>
	 * <p>
	 * Constructor takes the builder rather than pass an ever growing list of
	 * parameters.
	 * </p>
	 */
	private Car(Builder builder) {
		this.manufacturer = builder.manufacturer;
		this.model = builder.model;
	}

	public static Builder aCar() {
		return new Builder();
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public String getModel() {
		return model;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Car)) {
			return false;
		}
		Car other = (Car) obj;
		return new EqualsBuilder().append(this.manufacturer, other.manufacturer).append(this.model, other.model)
				.isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(this.manufacturer).append(this.model).hashCode();
	}

	public static class Builder {

		/*
		 * We don't want to make the builder variables final because we might
		 * modify them before building the sealed immutable object.
		 */
		private String manufacturer;
		private String model;

		/**
		 * Can only get the builder using the static method on the class we are
		 * building.
		 */
		private Builder() {
			super();
		}

		public Builder manufacturer(String manufacturer) {
			this.manufacturer = manufacturer;
			return this;
		}

		public Builder model(String model) {
			this.model = model;
			return this;
		}

		public Car build() {
			return new Car(this);
		}
	}
}