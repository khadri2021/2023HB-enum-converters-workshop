package com.khadri.hibernate.converterts;

import java.util.Optional;

import javax.persistence.AttributeConverter;

import com.khadri.hibernate.enums.Model;

public class ModelConverter implements AttributeConverter<Model, Character>{
	

	@Override
	public Character convertToDatabaseColumn(Model model) {
		Character getModel = null;

		if (Optional.ofNullable(model).isPresent()) {

			if (model.equals(Model.BASIC)) {
				getModel = 'B';
			} else if (model.equals(Model.MIDEND)) {
				getModel = 'M';
			} else if (model.equals(Model.TOPEND)) {
				getModel = 'T';
			} else {
				getModel = 'R';
			}
		}
		return getModel;
	}

	@Override
	public Model convertToEntityAttribute(Character model) {
		Model getModel = null;
		if (Optional.ofNullable(model).isPresent()) {
			getModel = Model.fromCharacterCode(model);
		}
		return getModel;
	}


}
