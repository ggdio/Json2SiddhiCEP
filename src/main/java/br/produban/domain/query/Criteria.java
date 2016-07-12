package br.produban.domain.query;

import java.util.ArrayList;
import java.util.List;

public class Criteria {

	private final List<Criteria> subCriterias;
	private final List<Condition> conditions;
	
	public Criteria() {
		this.subCriterias = new ArrayList<>();
		this.conditions = new ArrayList<>();
	}
	
	public List<Criteria> getSubCriterias() {
		return subCriterias;
	}
	
	public List<Condition> getConditions() {
		return conditions;
	}
	
	public Criteria addCriteria(Criteria criteria) {
		this.subCriterias.add(criteria);
		return this;
	}
	
	public Criteria addCriteria(Condition...conditions) {
		Criteria criteria = new Criteria();
		for (Condition condition : conditions) {
			criteria.getConditions().add(condition);
		}
		
		return addCriteria(criteria);
	}
	
	public Criteria addCondition(String field, Conditional conditional, Object value) {
		return this.addCondition(null, field, conditional, value);
	}
	
	public Criteria addCondition(Operator operator, String field, Conditional conditional, Object value) {
		this.conditions.add(new Condition(operator, field, conditional, value));
		return this;
	}
	
}
