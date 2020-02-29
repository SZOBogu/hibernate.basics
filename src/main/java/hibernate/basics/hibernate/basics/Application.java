package hibernate.basics.hibernate.basics;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import java.util.ArrayList;
import java.util.List;
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
		System.out.println("5. Read all persons");
		System.out.println("6. Exit");
		System.out.println("=====================");

		int menuChoice = scanner.nextInt();
		if(menuChoice == 1) {
			try {
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
				session.save(person);
				session.getTransaction().commit();
			}
			finally{
				factory.close();
			}
		}
		else if(menuChoice == 2) {
			try {
				System.out.println("Enter id of person you want to check on:");
				int id = scanner.nextInt();
				session.getTransaction().begin();
				PersonEntity person = session.get(PersonEntity.class, id);
				session.getTransaction().commit();
				System.out.println("Name: " + person.getFirstName());
				System.out.println("Last Name: " + person.getLastName());
				System.out.println("Email: " + person.getEmail());
			}
			finally{
				factory.close();
			}
		}
		else if(menuChoice == 3) {
			System.exit(0);
		}
		else if(menuChoice == 4) {
			System.exit(0);
		}
		else if(menuChoice == 5) {
			try {
				session.getTransaction().begin();
				List<PersonEntity> person = session.createQuery(" from PersonEntity").getResultList();
				session.getTransaction().commit();
				for(int i = 0; i < person.size(); i++) {
					System.out.println("Name: " + person.get(i).getFirstName());
					System.out.println("Last Name: " + person.get(i).getLastName());
					System.out.println("Email: " + person.get(i).getEmail());
					System.out.println("============");
				}
			}
			finally{
				factory.close();
			}
		}
		else if(menuChoice == 6) {
			System.exit(0);
		}
		//SpringApplication.run(Application.class, args);
	}

}
