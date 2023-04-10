package com.khadri.hibernate.main;

import org.hibernate.Session;

import com.khadri.hibernate.boot.registry.StandardServiceRegistryUtil;
import com.khadri.hibernate.entities.Address1;
import com.khadri.hibernate.entities.ShowRoom;
import com.khadri.hibernate.enums.Model;

public class Main1 {

	public static void main(String[] args) throws Exception {
      Class<?> classObj1 =  Address1.class;
      Class<?> classObj2 =  ShowRoom.class;
		Session session = StandardServiceRegistryUtil.createSession(classObj1,classObj2);
		org.hibernate.Transaction txn = session.beginTransaction();

		ShowRoom showroom = new ShowRoom();

		showroom.setShowroomName("vikram showroom");
		showroom.setModelName("TATA-NEXON");
		showroom.setModel(Model.RANGE_ROVER);

		Address1 presentAddress = new Address1();

		presentAddress.setDoorNo("9/09");
		presentAddress.setStreetName("INDIRANAGAR");
		presentAddress.setLandMark("PSS_OFFICE,KADIRI");

		showroom.setPresentAddress(presentAddress);

		Address1 permanentAddress = new Address1();

		permanentAddress.setDoorNo("89/90");
		permanentAddress.setStreetName("AMEERPET");
		permanentAddress.setLandMark("DMART NEAR");

		showroom.setPermenetAddress(permanentAddress);
		showroom.setPhoneNumber("8790606070");

		session.save(showroom);

		txn.commit();
		StandardServiceRegistryUtil.closeResources();
	}

}
