package com.khadri.hibernate.converts;

import java.util.Optional;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import com.khadri.hibernate.enums.Size;

@Converter
public class SizeConverter implements AttributeConverter<Size, Character> {

	@Override
	public Character convertToDatabaseColumn(Size size) {

		// Optional<Character> optCharacter = Optional.ofNullable(size)
		// .map((s) -> {
		// return (size.equals(Size.SMALL))
		// ? 'S'
		// : (size.equals(Size.MEDIUM))
		// ? 'M'
		// : (size.equals(Size.LARGE) ? 'L' : 'E');
		// });
		//
		// return optCharacter.get();

		Optional<Character> optCharacter = Optional.ofNullable(size)
				.map((s) -> {
					if (size.equals(Size.SMALL))
						return 'S';
					return 'A';
				}).map((s) -> {
					if (size.equals(Size.MEDIUM))
						return 'M';
					return 'A';
				}).map((s) -> {
					if (size.equals(Size.LARGE))
						return 'L';
					return 'A';
				}).map((s) -> {
					if (size.equals(Size.EXTRA_LARGE))
						return 'E';
					return 'A';
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