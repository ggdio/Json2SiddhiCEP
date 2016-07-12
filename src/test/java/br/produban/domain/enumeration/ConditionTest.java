package br.produban.domain.enumeration;

import org.junit.Assert;
import org.junit.Test;

import br.produban.domain.query.Operator;

public class ConditionTest {

	@Test(expected = IllegalArgumentException.class)
	public void testFromExternalNull() {
		Operator.fromExternal(null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testFromExternalInvalid() {
		Operator.fromExternal("invalid");
	}

	@Test
	public void testFromExternalString() {
		Operator result = Operator.fromExternal("AND");
		Assert.assertNotNull(result);
		Assert.assertEquals(Operator.AND, result);
	}

	@Test
	public void testFromExternalBetween() {
		Operator result = Operator.fromExternal("OR");
		Assert.assertNotNull(result);
		Assert.assertEquals(Operator.OR, result);
	}

}
