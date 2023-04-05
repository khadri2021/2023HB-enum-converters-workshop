package com.infotech.client;

import java.util.Date;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.infotech.entities.Address;
import com.infotech.entities.AddressType;
import com.infotech.entities.Employee;
import com.infotech.entities.PhoneType;
import com.infotech.util.HibernateUtil;

public class SaveDataClientTest {

	public static void main(String[] args) {
		
	    try(Session session = HibernateUtil.getSessionFactory().openSession()) {
	    	session.beginTransaction();
	    	Employee employee= new Employee();
			employee.setEmployeeName("VIKRAM ");
			employee.setEmail(" vickypandu@gmail.com");
			employee.setSalary(50000.00);
			employee.setDoj(new Date());
			employee.setPhoneNo(8790606070L);
			employee.setPhoneType(PhoneType.MOBILE);
			
			Address address1 = new Address();
			address1.setCity("kadiri");
			address1.setPincode(9087727L);
			address1.setState("Andhra");
			address1.setStreet("indira Street");
			address1.setAddressType(AddressType.PERMANENT);
			
			
			Address address2 = new Address();
			address2.setCity("Bangalore");
			address2.setPincode(9000027L);
			address2.setState("Karnataka");
			address2.setStreet("jp nagar Street");
			address2.setAddressType(AddressType.COMMUNICATION);
			
			employee.getAddressList().add(address1);
			employee.getAddressList().add(address2);
			
			address1.setEmployee(employee);
			address2.setEmployee(employee);
			
			session.persist(employee);
			
			session.getTransaction().commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
	  }
}
