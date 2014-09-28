package com.sakthipriyan.skycast.models;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

public enum Button {
	ZERO(0), ONE(1), TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7), EIGHT(
			8), NINE(9), UP(10), DOWN(11), BACK(12);

	private Button(final int id) {
		this.id = id;
	}

	private int id;

	public int getId() {
		return id;
	}

	private static final Map<Integer, Button> lookup = new HashMap<>();

	static {
		for (Button button : EnumSet.allOf(Button.class))
			lookup.put(button.getId(), button);
	}

	public static Button get(int id) {
		return lookup.get(id);
	}
}