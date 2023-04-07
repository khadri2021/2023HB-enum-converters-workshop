package com.khadri.hibernate.boot.registry;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.BootstrapServiceRegistry;
import org.hibernate.boot.registry.BootstrapServiceRegistryBuilder;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.khadri.hibernate.entities.Restuarent;

public class StandardServiceRegistryUtil {
	static SessionFactory factory;
	static Session session;

	private static SessionFactory createSessionFactory() {
		BootstrapServiceRegistry serviceRegistry = new BootstrapServiceRegistryBuilder().build();
		StandardServiceRegistry standardServiceRegistry = new StandardServiceRegistryBuilder(serviceRegistry).build();

		Metadata metadata = new MetadataSources(standardServiceRegistry).addAnnotatedClass(Restuarent.class)
				.buildMetadata();

		return metadata.buildSessionFactory();
	}

	public static Session getSession() {
		return createSessionFactory().openSession();
	}

}
