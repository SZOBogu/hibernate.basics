package hibernate.basics.hibernate.basics;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Scanner;

public class DebtMain {

    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .addAnnotatedClass(PersonEntity.class)
                .addAnnotatedClass(PersonHobbyEntity.class)
                .addAnnotatedClass(DebtEntity.class)
                .buildSessionFactory();
        Session session = factory.getCurrentSession();

        //Scanner scanner = new Scanner(System.in);

        try {
            session.getTransaction().begin();
//            DebtEntity debt0 = new DebtEntity();
//            DebtEntity debt1 = new DebtEntity();
            DebtEntity debt2 = new DebtEntity();
            PersonEntity personEntity = session.get(PersonEntity.class, 3);

//            debt0.setSum(123123123);
//            debt0.setType("asdda");
          //  debt0.setPersonEntity(session.get(PersonEntity.class, debt0.getPersonEntity().getId()));

//            debt1.setSum(5000);
//            debt1.setType("na zus");
//            debt1.setPersonEntity(session.get(PersonEntity.class, debt1.getPersonEntity().getId()));

            debt2.setSum(644477);
            debt2.setType("przerzniete w makao");
           // debt2.setPersonEntity(session.get(PersonEntity.class, debt2.getPersonEntity().getId()));

//            personEntity.add(debt0);
//            personEntity.add(debt1);
            personEntity.add(debt2);

//            session.persist(debt0);
//            session.persist(debt1);
            session.persist(debt2);

            session.getTransaction().commit();
        } finally {
            session.close();
            factory.close();
        }
    }
}
