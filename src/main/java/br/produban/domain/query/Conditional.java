package br.produban.domain.query;

import org.apache.commons.lang3.StringUtils;

public enum Conditional {

	BETWEEN("between"), 
	EQUAL("=="), 
	NOT_EQUAL("!="), 
	LOWER_THAN("<"), 
	GREATER_THAN(">"), 
	LOWER_OR_EQUAL("<="), 
	GRATER_OR_EQUAL(">=");

	public final String external;

	private Conditional(String external) {
		this.external = external;
	}
	
	public String getExternal() {
		return external;
	}

	public static Conditional fromExternal(String external) {
		if (StringUtils.isEmpty(external)) {
			throw new IllegalArgumentException();
		}
		for (Conditional itemType : Conditional.values()) {
			if (itemType.external.equals(external)) {
				return itemType;
			}
		}
		throw new IllegalArgumentException();
	}

}
