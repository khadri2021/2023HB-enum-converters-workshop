package com.khadri.hibernate.session;

import java.io.File;
import java.io.FileReader;
import java.util.Properties;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.khadri.hibernate.entities.Restuarent;

public class BasicOperationSession {

	public static Session getSession() throws Exception {
		Configuration cfg = new Configuration();

		Properties properties = new Properties();
		properties.load(new FileReader(new File("src/main/resources/hb.properties")));
		cfg.addProperties(properties);

		cfg.addAnnotatedClass(Restuarent.class);

		SessionFactory factory = cfg.buildSessionFactory();

		return factory.openSession();

	}
}
