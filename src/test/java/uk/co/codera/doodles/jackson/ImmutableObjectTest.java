package uk.co.codera.doodles.jackson;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;
import static uk.co.codera.doodles.jackson.ImmutableObject.anImmutableObject;

import java.util.UUID;

import org.junit.Before;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ImmutableObjectTest {

	private ObjectMapper mapper;

	@Before
	public void before() {
		this.mapper = new ObjectMapper();
	}

	@Test
	public void shouldBeAbleToSerialiseObjectToJson() {
		ImmutableObject immutableObject = anImmutableObject().somethingInteresting(randomString())
				.build();
		assertThat(writeAsString(immutableObject), is(notNullValue()));
	}

	private String writeAsString(ImmutableObject object) {
		try {
			return this.mapper.writeValueAsString(object);
		} catch (JsonProcessingException e) {
			throw new IllegalStateException(e);
		}
	}

	private String randomString() {
		return UUID.randomUUID().toString();
	}
}