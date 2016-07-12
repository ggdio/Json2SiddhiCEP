package br.produban.domain.query;

import org.apache.commons.lang3.StringUtils;

public enum Operator {

	AND("AND"), OR("OR");

	public final String external;

	private Operator(String external) {
		this.external = external;
	}

	public static Operator fromExternal(String external) {
		if (StringUtils.isEmpty(external)) {
			throw new IllegalArgumentException();
		}
		for (Operator itemType : Operator.values()) {
			if (itemType.external.equals(external)) {
				return itemType;
			}
		}
		throw new IllegalArgumentException();
	}

}
