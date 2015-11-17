package uk.co.codera.doodles.jackson;

public class ImmutableObject {

	private final String somethingInteresting;
	
	private ImmutableObject(Builder builder) {
		this.somethingInteresting = builder.somethingInteresting;
	}

	public static Builder anImmutableObject() {
		return new Builder();
	}
	
	public String getSomethingInteresting() {
		return somethingInteresting;
	}
	
	public static class Builder {
		
		private String somethingInteresting;
		
		public Builder somethingInteresting(String somethingInteresting) {
			this.somethingInteresting = somethingInteresting;
			return this;
		}
		
		public ImmutableObject build() {
			return new ImmutableObject(this);
		}
	}
}