package hibernate.basics.hibernate.basics;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
				.addAnnotatedClass(PersonEntity.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();

		try{
			PersonEntity person = new PersonEntity();
			person.setLastName("Stanisławski");
			person.setFirstName("Łukasz");
			person.setEmail("mokebe@buziaczek.sen");

			session.beginTransaction();
			session.save(person);
			session.getTransaction().commit();
			System.out.print("Dziala");
		}
		finally{
			factory.close();
		}
		SpringApplication.run(Application.class, args);
	}

}
