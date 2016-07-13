package br.produban.application.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.produban.application.service.CepRuleService;
import br.produban.domain.rule.CepRule;

/**
 * Created by bera on 30/06/16.
 */

@RestController
@RequestMapping("/ceprule")
public class CepRuleController {

	final static Logger logger = Logger.getLogger(CepRuleController.class);

	@Autowired
	private CepRuleService cepRuleService;

	@RequestMapping(value = "", method = RequestMethod.GET)
	public Iterable<CepRule> listCepRules() {
		logger.info("listCepRules()");
		return cepRuleService.findAll();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public CepRule getCepRule(@PathVariable("id") String id) {
		logger.info("getCepRule() " + id);
		CepRule cepRule = cepRuleService.findOne(id);
		return cepRule;
	}

	@RequestMapping(value = "", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public CepRule createCepRule(@RequestBody final CepRule cepRule) {
		logger.info("createCepRule(..)");
		return cepRuleService.save(cepRule.getChangedBy(), cepRule);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public CepRule updateCepRule(@PathVariable("id") String id, @RequestBody CepRule cepRule) {
		logger.info("updateCepRule(..)");
		CepRule value = cepRuleService.save(cepRule.getChangedBy(), cepRule);
		return value;
	}

}