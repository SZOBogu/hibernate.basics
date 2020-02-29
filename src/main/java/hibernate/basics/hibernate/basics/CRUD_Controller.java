//package hibernate.basics.hibernate.basics;
//
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.cfg.Configuration;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.data.jpa.util.*;
//
//import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
//import javax.persistence.Persistence;
//
//@Controller
//public class CRUD_Controller {
//    private SessionFactory factory;
//    private Session session;
//
//    public EntityManagerFactory entityManagerFactory;
//    public EntityManager entityManager;
//
//    public CRUD_Controller(){
//        this.factory = new Configuration().addAnnotatedClass(PersonEntity.class).buildSessionFactory();
//        this.session = factory.getCurrentSession();
////        this.entityManagerFactory = Persistence.createEntityManagerFactory("hibernate_test");
////        this.entityManager = entityManagerFactory.createEntityManager();
//    }
//
//    @RequestMapping("/create")
//    public String create(@ModelAttribute("personEntity") PersonEntity person, Model model){
//       // try{
//            PersonEntity personEnt = new PersonEntity();
//            personEnt.setLastName(person.getLastName());
//            personEnt.setFirstName(person.getFirstName());
//            personEnt.setEmail(person.getEmail());
//            model.addAttribute(person);
//           session.getTransaction().begin();
//           session.persist(personEnt);
//           session.getTransaction().commit();
////        }
////        finally{
////            factory.close();
////        }
//        return "create";
//    }
//
//    @RequestMapping("/read")
//    public String read(@ModelAttribute("personEntity") PersonEntity person, Model model){
//        return "read";
//    }
//
//    @RequestMapping("/readEffect")
//    public String readEffect(@ModelAttribute("personEntity") PersonEntity person, Model model){
//        return "readEffect";
//    }
//
//    @RequestMapping("/delete")
//    public String delete(@ModelAttribute("personEntity") PersonEntity person, Model model){
//        return "delete";
//    }
//
//    @RequestMapping("/update")
//    public String update(@ModelAttribute("personEntity") PersonEntity person, Model model){
//        return "update";
//    }
//
//}
