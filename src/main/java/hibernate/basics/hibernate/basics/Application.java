package hibernate.basics.hibernate.basics;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class Application {

	/*
	 */
	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
				.addAnnotatedClass(PersonEntity.class)
				.addAnnotatedClass(HobbyEntity.class)
				.addAnnotatedClass(ProjectEntity.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();

		Menu menu = new Menu();
		menu.menu(factory, session);
	}
}