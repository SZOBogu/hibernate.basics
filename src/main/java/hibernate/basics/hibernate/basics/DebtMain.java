package hibernate.basics.hibernate.basics;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;
import java.util.Scanner;

public class DebtMain {

    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .addAnnotatedClass(PersonEntity.class)
                .addAnnotatedClass(PersonHobbyEntity.class)
                .addAnnotatedClass(DebtEntity.class)
                .buildSessionFactory();
        Session session = factory.getCurrentSession();

        try {
            session.getTransaction().begin();
            PersonEntity personEntity = session.get(PersonEntity.class, 3);
            List<DebtEntity> debts = personEntity.getDebtEntityList();
            System.out.println("Person: " + personEntity.getFirstName() + " " + personEntity.getLastName());
            for(DebtEntity debt : debts){
                System.out.println(debt);
            }
            session.getTransaction().commit();
        } finally {
            session.close();
            factory.close();
        }
    }
}
