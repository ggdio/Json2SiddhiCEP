package br.produban.domain.query;

public class Condition {

	private final Operator operator;
	private final String field;
	private final Conditional conditional;
	private final Object value;
	
	public Condition(String field, Conditional conditional, Object value) {
		this(null, field, conditional, value);
	}
	
	public Condition(Operator operator, String field, Conditional conditional, Object value) {
		this.operator = operator;
		this.field = field;
		this.conditional = conditional;
		this.value = value;
	}

	public Operator getOperator() {
		return operator;
	}

	public String getField() {
		return field;
	}

	public Conditional getConditional() {
		return conditional;
	}

	public Object getValue() {
		return value;
	}
	
}