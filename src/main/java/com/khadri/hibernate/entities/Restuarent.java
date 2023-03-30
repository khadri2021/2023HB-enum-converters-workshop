package com.khadri.hibernate.entities;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.khadri.hibernate.converts.SizeConverter;
import com.khadri.hibernate.enums.Size;

@Entity
@Table(name = "RESTUARENT")
public class Restuarent {

	@Id
	@GeneratedValue(generator = "increment")
	@Column(name = "ORDER_ID")
	private Long id;

	@Column(name = "RESTUARENT_NAME")
	private String restuarentName;

	@Column(name = "PIZZA_NAME", insertable = true, updatable = true, nullable = false)
	private String pizzaName;

	@Convert(converter = SizeConverter.class)
	@Column(name = "SIZE", insertable = true, updatable = true, nullable = false)
	private Size size;

	@Column(name = "PHONE_NUMBER", insertable = true, updatable = true, nullable = false)
	private String phoneNumber;

	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "doorNo", column = @Column(name = "PRESENT_DOOR_NO")),
			@AttributeOverride(name = "streetName", column = @Column(name = "PRESENT_STREET_NAME")),
			@AttributeOverride(name = "landMark", column = @Column(name = "PRESENT_LAND_MARK")) })
	private Address presentAddress;

	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "doorNo", column = @Column(name = "PERMENENT_DOOR_NO")),
			@AttributeOverride(name = "streetName", column = @Column(name = "PERMENENT_STREET_NAME")),
			@AttributeOverride(name = "landMark", column = @Column(name = "PERMENENT_LAND_MARK")) })
	private Address permenetAddress;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRestuarentName() {
		return restuarentName;
	}

	public void setRestuarentName(String restuarentName) {
		this.restuarentName = restuarentName;
	}

	public String getPizzaName() {
		return pizzaName;
	}

	public void setPizzaName(String pizzaName) {
		this.pizzaName = pizzaName;
	}

	public Size getSize() {
		return size;
	}

	public void setSize(Size size) {
		this.size = size;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Address getPresentAddress() {
		return presentAddress;
	}

	public void setPresentAddress(Address presentAddress) {
		this.presentAddress = presentAddress;
	}

	public Address getPermenetAddress() {
		return permenetAddress;
	}

	public void setPermenetAddress(Address permenetAddress) {
		this.permenetAddress = permenetAddress;
	}

}
