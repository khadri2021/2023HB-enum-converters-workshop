package com.khadri.hibernate.main;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.khadri.hibernate.entities.Address;
import com.khadri.hibernate.entities.Restuarent;
import com.khadri.hibernate.enums.Size;
import com.khadri.hibernate.session.BasicOperationSession;

public class RestuarentMain {

	public static void main(String[] args) throws Exception {

		Session session = BasicOperationSession.getSession();

		Transaction txn = session.beginTransaction();

		Restuarent rest = new Restuarent();

		rest.setRestuarentName("Pizza Hub Kadiri");
		rest.setPizzaName("Chicken Cheese Pizza");
		rest.setSize(Size.LARGE);

		Address presentAddress = new Address();

		presentAddress.setDoorNo("10/1098");
		presentAddress.setStreetName("Nizam Vali Colony");
		presentAddress.setLandMark("HP Petrol Bunk,Gajjala Reddy Palli");

		rest.setPresentAddress(presentAddress);

		Address permanentAddress = new Address();

		permanentAddress.setDoorNo("10/1098");
		permanentAddress.setStreetName("Nizam Vali Colony");
		permanentAddress.setLandMark("HP Petrol Bunk,Gajjala Reddy Palli");

		rest.setPermenetAddress(permanentAddress);
		rest.setPhoneNumber("9876543210");

		session.save(rest);

		txn.commit();
		session.close();
	}
}
