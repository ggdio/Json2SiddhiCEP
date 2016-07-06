package br.produban.controllers;

import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import br.produban.models.CepRule;
import br.produban.models.CepRuleFilter;
import br.produban.repositories.CepRuleMongoRepository;
import io.github.benas.jpopulator.api.Populator;
import io.github.benas.jpopulator.impl.PopulatorBuilder;

public class CepRuleControllerTest {

	@Rule
	public MockitoRule rule = MockitoJUnit.rule();

	private Populator populator;

	@Mock
	private CepRuleMongoRepository cepRuleRepository;

	@InjectMocks
	private CepRuleController cepRuleController;

	@Before
	public void setUp() throws Exception {
		populator = new PopulatorBuilder().build();
	}

	@Test
	public void testListCepRules1() {
		Iterable<CepRule> value = cepRuleController.listCepRules();
		Assert.assertNotNull(value);
	}

	@Test
	public void testListCepRules2() {
		List<CepRule> list = populator.populateBeans(CepRule.class, 5);
		Mockito.when(cepRuleRepository.findAll()).thenReturn(list);

		Iterable<CepRule> value = cepRuleController.listCepRules();
		Assert.assertNotNull(value);
		Assert.assertEquals(list, value);

		Mockito.verify(cepRuleRepository, Mockito.only()).findAll();
	}

	@Test
	public void testGetCepRule1() {
		CepRule cepRule = cepRuleController.getCepRule("ID-1");
		Assert.assertNull(cepRule);
	}

	@Test
	public void testGetCepRule2() {
		CepRule cepRule = populator.populateBean(CepRule.class);
		Mockito.when(cepRuleRepository.findOne("ID-2")).thenReturn(cepRule);

		CepRule value = cepRuleController.getCepRule("ID-1");
		Assert.assertNull(value);
	}

	@Test
	public void testGetCepRule3() {
		CepRule cepRule = populator.populateBean(CepRule.class);
		cepRule.setFilters(populator.populateBeans(CepRuleFilter.class, 10));
		Mockito.when(cepRuleRepository.findOne("ID-2")).thenReturn(cepRule);

		CepRule value = cepRuleController.getCepRule("ID-2");
		Assert.assertNotNull(value);
		Assert.assertEquals(cepRule, value);
	}

	@Test
	public void testCreateCepRule() {
		CepRule cepRule = populator.populateBean(CepRule.class);
		Mockito.when(cepRuleRepository.save(cepRule)).thenReturn(cepRule);

		CepRule value = cepRuleController.createCepRule(cepRule);
		Assert.assertNotNull(value);
		Assert.assertEquals(cepRule.getCepRuleId(), value.getCepRuleId());
		Assert.assertEquals(cepRule, value);

		Mockito.verify(cepRuleRepository, Mockito.only()).save(Mockito.any(CepRule.class));

	}

	@Test
	public void testUpdateCepRule() {
		CepRule cepRule = populator.populateBean(CepRule.class);

		Mockito.when(cepRuleRepository.save(cepRule)).thenReturn(cepRule);
		Mockito.when(cepRuleRepository.findOne(Mockito.anyString())).thenReturn(new CepRule());

		cepRuleController.updateCepRule(cepRule.getCepRuleId(), cepRule);

		Mockito.verify(cepRuleRepository).findOne(Mockito.anyString());
		Mockito.verify(cepRuleRepository).save(Mockito.any(CepRule.class));
	}

}