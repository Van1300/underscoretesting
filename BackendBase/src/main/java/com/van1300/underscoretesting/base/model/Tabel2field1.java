package com.van1300.underscoretesting.base.model;

import java.util.HashMap;
import java.util.Map;

public enum Tabel2field1 {
	RESOLVED("resolved"),
	OPEN("open"),
	DONE("done"),
	INPROGRESS("inprogress"),
	WAITING("waiting");

	private static final Map<String, Tabel2field1> displayNameMap = new HashMap<>();
	static {
		for (Tabel2field1 displayNameEnum : Tabel2field1.values()) {
			displayNameMap.put(displayNameEnum.getDisplayName(), displayNameEnum);
		}
	}
	private String displayName;

	Tabel2field1(String displayName) {
		this.displayName = displayName;
	}

	public static Tabel2field1 getDisplayNameEnum(String displayName) {
		return displayNameMap.get(displayName);
	}

	public String getDisplayName() {
		return displayName;
	}
}
