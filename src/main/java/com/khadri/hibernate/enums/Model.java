package com.khadri.hibernate.enums;

public enum Model {
	

	BASIC('B'), MIDEND('M'), TOPEND('T'), RANGE_ROVER('R');

	private Character model;

	private Model(Character model) {
		this.model = model;
	}

	public Character getModel() {
		return this.model;
	}

	public static Model fromCharacterCode(Character model) {
		if (model.equals('B')) {
			return BASIC;
		} else if (model.equals('M')) {
			return MIDEND;
		} else if (model.equals('L')) {
			return TOPEND;
		} else {
			return RANGE_ROVER;
		}
	}


}
