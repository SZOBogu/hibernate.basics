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
		SessionFactory factory = new Configuration()
				.addAnnotatedClass(PersonEntity.class)
				.addAnnotatedClass(PersonHobbyEntity.class)
				.buildSessionFactory();
		Session session = factory.getCurrentSession();

		Scanner scanner = new Scanner(System.in);

		System.out.println("1. Create new person");
		System.out.println("2. Read person by id");
		System.out.println("3. Read hobby by id");
		System.out.println("4. Update person");
		System.out.println("5. Delete person");
		System.out.println("6. Read all persons");
		System.out.println("7. Exit");
		System.out.println("=====================");

		int menuChoice = scanner.nextInt();

		//CREATE
		if(menuChoice == 1) {
			try {
				String skipCatcher = scanner.nextLine();
				System.out.println("Enter name:");
				String name = scanner.nextLine();
				System.out.println("Enter last name:");
				String lastName = scanner.nextLine();
				System.out.println("Enter email:");
				String email = scanner.nextLine();
				System.out.println("Enter hobby:");
				String hobby = scanner.nextLine();

				PersonEntity person = new PersonEntity();
				PersonHobbyEntity personHobby = new PersonHobbyEntity();
				person.setFirstName(name);
				person.setLastName(lastName);
				person.setEmail(email);
				personHobby.setHobby(hobby);
				person.setPersonHobbyEntity(personHobby);

				session.getTransaction().begin();
				session.save(person);
				session.getTransaction().commit();
			}
			finally{
				factory.close();
			}
		}
		//READ PERSON
		else if(menuChoice == 2) {
			try {
				System.out.println("Enter id of person you want to check on:");
				int id = scanner.nextInt();
				session.getTransaction().begin();
				PersonEntity person = session.get(PersonEntity.class, id);
				PersonHobbyEntity personHobby = session.get(PersonHobbyEntity.class, person.getPersonHobbyEntity().getId());
				session.getTransaction().commit();
				System.out.println("Name: " + person.getFirstName());
				System.out.println("Last Name: " + person.getLastName());
				System.out.println("Email: " + person.getEmail());
				System.out.println("Hobby: " + personHobby.getHobby());
			}
			finally{
				factory.close();
			}
		}
		//READ HOBBY
		else if(menuChoice == 3) {
			try {
				System.out.println("Enter id of person you want to check on:");
				int id = scanner.nextInt();
				session.getTransaction().begin();
				PersonHobbyEntity personHobby = session.get(PersonHobbyEntity.class, id);
				PersonEntity person = session.get(PersonEntity.class, personHobby.getPersonEntity().getId());
				session.getTransaction().commit();
				System.out.println("Hobby: " + personHobby.getHobby());
				System.out.println("Name: " + person.getFirstName());
				System.out.println("Last Name: " + person.getLastName());
				System.out.println("Email: " + person.getEmail());
			}
			finally{
				factory.close();
			}
		}
		//UPDATE
		else if(menuChoice == 4) {
            try {
                System.out.println("Enter id of person you want to update:");
                int id = scanner.nextInt();
                String skipCatcher = scanner.nextLine();
                System.out.println("Enter name:");
                String name = scanner.nextLine();
                System.out.println("Enter last name:");
                String lastName = scanner.nextLine();
                System.out.println("Enter email:");
                String email = scanner.nextLine();
				System.out.println("Enter hobby:");
				String hobby = scanner.nextLine();

                session.getTransaction().begin();
                PersonEntity person = session.get(PersonEntity.class, id);
				PersonHobbyEntity personHobby = session.get(PersonHobbyEntity.class, person.getPersonHobbyEntity().getId());
                person.setFirstName(name);
                person.setLastName(lastName);
                person.setEmail(email);
				personHobby.setHobby(hobby);
				person.setPersonHobbyEntity(personHobby);
                session.save(person);
                session.getTransaction().commit();
            }
            finally{
                factory.close();
            }
		}
		//DELETE
		else if(menuChoice == 5) {
            try {
				System.out.println("Enter id of person you want to delete:");
				int id = scanner.nextInt();
				session.getTransaction().begin();
				PersonEntity person = session.get(PersonEntity.class, id);
				session.delete(person);
				session.getTransaction().commit();
				System.out.println("Pronto usunieto ");
            }
            finally{
                factory.close();
            }
		}
		//READ ALL
		else if(menuChoice == 6) {
			try {
				session.getTransaction().begin();
				List<PersonEntity> person = session.createQuery(" from PersonEntity").getResultList();
				for (PersonEntity personEntity : person) {
					PersonHobbyEntity personHobby = session.get(PersonHobbyEntity.class, personEntity.getPersonHobbyEntity().getId());
					System.out.println("Name: " + personEntity.getFirstName());
					System.out.println("Last Name: " + personEntity.getLastName());
					System.out.println("Email: " + personEntity.getEmail());
					System.out.println("Hobby: " + personHobby.getHobby());
					System.out.println("============");
				}
				session.getTransaction().commit();
			}
			finally{
				factory.close();
			}
		}
		else if(menuChoice == 7) {
			System.exit(0);
		}
		//SpringApplication.run(Application.class, args);
	}

}
