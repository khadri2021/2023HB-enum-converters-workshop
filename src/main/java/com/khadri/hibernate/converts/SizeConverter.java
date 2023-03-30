package com.khadri.hibernate.converts;

import java.util.Optional;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import com.khadri.hibernate.enums.Size;

@Converter
public class SizeConverter implements AttributeConverter<Size, Character> {

	@Override
	public Character convertToDatabaseColumn(Size size) {
		Character getSize = null;

		if (Optional.ofNullable(size).isPresent()) {

			if (size.equals(Size.SMALL)) {
				getSize = 'S';
			} else if (size.equals(Size.MEDIUM)) {
				getSize = 'M';
			} else if (size.equals(Size.LARGE)) {
				getSize = 'L';
			} else {
				getSize = 'E';
			}
		}
		return getSize;
	}

	@Override
	public Size convertToEntityAttribute(Character size) {
		Size getSize = null;
		if (Optional.ofNullable(size).isPresent()) {
			getSize = Size.fromCharacterCode(size);
		}
		return getSize;
	}

}