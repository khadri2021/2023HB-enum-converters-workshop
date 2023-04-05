package com.khadri.hibernate.boot.registry;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.BootstrapServiceRegistry;
import org.hibernate.boot.registry.BootstrapServiceRegistryBuilder;

import com.khadri.hibernate.entities.ShowRoom;

public class BootRegistryUtil {

	static SessionFactory factory;
	static Session session;

	private static SessionFactory createSessionFactory() {
		BootstrapServiceRegistry serviceRegistry = new BootstrapServiceRegistryBuilder().build();

		Metadata metadata = new MetadataSources(serviceRegistry).addAnnotatedClass(ShowRoom.class).buildMetadata();

		factory = metadata.buildSessionFactory();

		return factory;
	}

	public static Session getSession() {
		session = createSessionFactory().openSession();
		return session;
	}

	public static void closeObjects() {
		session.close();
		factory.close();
	}

}
