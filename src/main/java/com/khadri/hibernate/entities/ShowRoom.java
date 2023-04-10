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

import com.khadri.hibernate.converts.ModelConverter;
import com.khadri.hibernate.enums.Model;

@Entity(name="ShowRoom")
@Table(name="SHOWROOM")
public class ShowRoom {
	
	@Id
	@GeneratedValue(generator = "increment")
	@Column(name = "S_ID ")
	private Long id;

	@Column(name = "SHOWROOM_NAME")
	private String showroomName;

	@Column(name = "MODEL_NAME", insertable = true, updatable = true, nullable = false)
	private String modelName;
	

	@Convert(converter = ModelConverter.class)
	@Column(name = "MODEL", insertable = true, updatable = true, nullable = false)
	private Model model;
	
	@Column(name = "PHONE_NUMBER", insertable = true, updatable = true, nullable = false)
	private String phoneNumber;

	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "doorNo", column = @Column(name = "PRESENT_DOOR_NO")),
			@AttributeOverride(name = "streetName", column = @Column(name = "PRESENT_STREET_NAME")),
			@AttributeOverride(name = "landMark", column = @Column(name = "PRESENT_LAND_MARK")) })
	private Address1 presentAddress;

	@Embedded
	@AttributeOverrides({@AttributeOverride(name="doorNo",column= @Column(name="PERMENENT_DOOR_NO")),
		@AttributeOverride(name = "streetName", column = @Column(name = "PERMENENT_STREET_NAME")),
		@AttributeOverride(name = "landMark", column = @Column(name = "PERMENENT_LAND_MARK")) })
	 	private Address1 permenentAddress;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getShowroomName() {
		return showroomName;
	}

	public void setShowroomName(String showroomName) {
		this.showroomName = showroomName;
	}

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	public Model getModel() {
		return model;
	}

	public void setModel(Model model) {
		this.model = model;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Address1 getPresentAddress() {
		return presentAddress;
	}

	public void setPresentAddress(Address1 presentAddress) {
		this.presentAddress = presentAddress;
	}

	public Address1 getPermenentAddress() {
		return permenentAddress;
	}

	public void setPermenetAddress(Address1 permenentAddress) {
		this.permenentAddress = permenentAddress;
	}



 }
