package hibernate.basics.hibernate.basics;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import java.util.Scanner;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class Application {


	public static void main(String[] args) {
		SessionFactory factory = new Configuration().addAnnotatedClass(PersonEntity.class).buildSessionFactory();
		Session session = factory.getCurrentSession();

		Scanner scanner = new Scanner(System.in);

		System.out.println("1. Create new person");
		System.out.println("2. Read person by id");
		System.out.println("3. Update employee");
		System.out.println("4. Delete employee");
		System.out.println("5. Exit");
		System.out.println("=====================");

		int menuChoice = scanner.nextInt();
		if(menuChoice == 1) {
			String skipCatcher = scanner.nextLine();
			System.out.println("Enter name:");
			String name = scanner.nextLine();
			System.out.println("Enter last name:");
			String lastName = scanner.nextLine();
			System.out.println("Enter email:");
			String email = scanner.nextLine();

			PersonEntity person = new PersonEntity();
			person.setFirstName(name);
			person.setLastName(lastName);
			person.setEmail(email);
			session.getTransaction().begin();
			session.persist(person);
			session.getTransaction().commit();
		}
		else if(menuChoice == 2) {
			System.exit(0);
		}
		else if(menuChoice == 3) {
			System.exit(0);
		}
		else if(menuChoice == 4) {
			System.exit(0);
		}
		else if(menuChoice == 5) {
			System.exit(0);
		}
		//SpringApplication.run(Application.class, args);
	}

}
