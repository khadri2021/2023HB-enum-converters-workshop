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
		return (size.equals('S')) ? SMALL
			: (size.equals('M')) ? MEDIUM
				: (size.equals('L') ? LARGE : EXTRA_LARGE);

	}

}
