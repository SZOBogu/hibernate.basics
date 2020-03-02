package hibernate.basics.hibernate.basics;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteDebtMain {
    public static void main(String[] args){
        SessionFactory factory = new Configuration()
                .addAnnotatedClass(PersonEntity.class)
                .addAnnotatedClass(PersonHobbyEntity.class)
                .addAnnotatedClass(DebtEntity.class)
                .buildSessionFactory();
        Session session = factory.getCurrentSession();

        try {
            session.getTransaction().begin();
            DebtEntity debt = session.get(DebtEntity.class, 3);
            session.delete(debt);
            session.getTransaction().commit();
        } finally {
            session.close();
            factory.close();
        }
    }
}
