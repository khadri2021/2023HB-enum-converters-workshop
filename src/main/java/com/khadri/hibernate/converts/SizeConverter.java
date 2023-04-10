package com.khadri.hibernate.converts;

import java.util.Optional;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import com.khadri.hibernate.enums.Size;

@Converter
public class SizeConverter implements AttributeConverter<Size, Character> {

	@Override
	public Character convertToDatabaseColumn(Size size) {

		Optional<Character> optCharacter = Optional.ofNullable(size).map((s) -> {
			return (size.equals(Size.SMALL)) ? 'S'
					: (size.equals(Size.MEDIUM)) ? 'M' : (size.equals(Size.LARGE) ? 'L' : 'E');
		});

		return optCharacter.get();
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