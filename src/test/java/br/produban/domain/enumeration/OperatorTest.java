package br.produban.domain.enumeration;

import org.junit.Assert;
import org.junit.Test;

import br.produban.domain.query.Conditional;

public class OperatorTest {

	@Test(expected = IllegalArgumentException.class)
	public void testFromExternalNull() {
		Conditional.fromExternal(null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testFromExternalInvalid() {
		Conditional.fromExternal("invalid");
	}

	@Test
	public void testFromExternalEqual() {
		Conditional result = Conditional.fromExternal("==");
		Assert.assertNotNull(result);
		Assert.assertEquals(Conditional.EQUAL, result);
	}

	@Test
	public void testFromExternalDouble() {
		Conditional result = Conditional.fromExternal("<=");
		Assert.assertNotNull(result);
		Assert.assertEquals(Conditional.LOWER_OR_EQUAL, result);
	}
}
