package com.van1300.underscoretesting.base.model;

import java.util.HashMap;
import java.util.Map;

public enum Table1field1 {
	WAITING("waiting"),
	RESOLVED("resolved"),
	OPEN("open"),
	INPROGRESS("inprogress");

	private static final Map<String, Table1field1> displayNameMap = new HashMap<>();
	static {
		for (Table1field1 displayNameEnum : Table1field1.values()) {
			displayNameMap.put(displayNameEnum.getDisplayName(), displayNameEnum);
		}
	}
	private String displayName;

	Table1field1(String displayName) {
		this.displayName = displayName;
	}

	public static Table1field1 getDisplayNameEnum(String displayName) {
		return displayNameMap.get(displayName);
	}

	public String getDisplayName() {
		return displayName;
	}
}
