package com.khadri.hibernate.enums;

public enum Size {

	SMALL('S'), MEDIUM('M'), LARGE('L'), EXTRA_LARGE('E');

	private Character size;

	private Size(Character size) {
		this.size = size;
	}

	public Character getSize() {
		return this.size;
	}

	public static Size fromCharacterCode(Character size) {
		if (size.equals('S')) {
			return SMALL;
		} else if (size.equals('M')) {
			return MEDIUM;
		} else if (size.equals('L')) {
			return LARGE;
		} else {
			return EXTRA_LARGE;
		}
	}

}
