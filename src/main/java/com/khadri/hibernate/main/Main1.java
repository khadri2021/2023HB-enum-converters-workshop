package com.khadri.hibernate.main;

import org.hibernate.Session;

import com.khadri.hibernate.boot.registry.BootRegistryUtil;
import com.khadri.hibernate.entities.Address;
import com.khadri.hibernate.entities.ShowRoom;
import com.khadri.hibernate.enums.Model;

public class Main1 {

	public static void main(String[] args) throws Exception {

		Session session = BootRegistryUtil.getSession();
		org.hibernate.Transaction txn = session.beginTransaction();

		ShowRoom showroom = new ShowRoom();

		showroom.setShowroomName("vikram showroom");
		showroom.setModelName("TATA-NEXON");
		showroom.setModel(Model.RANGE_ROVER);

		Address presentAddress = new Address();

		presentAddress.setDoorNo("9/09");
		presentAddress.setStreetName("INDIRANAGAR");
		presentAddress.setLandMark("PSS_OFFICE,KADIRI");

		showroom.setPresentAddress(presentAddress);

		Address permanentAddress = new Address();

		permanentAddress.setDoorNo("89/90");
		permanentAddress.setStreetName("AMEERPET");
		permanentAddress.setLandMark("DMART NEAR");

		showroom.setPermenetAddress(permanentAddress);
		showroom.setPhoneNumber("8790606070");

		session.save(showroom);

		txn.commit();
		BootRegistryUtil.closeObjects();
	}

}
