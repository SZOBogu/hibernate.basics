package hibernate.basics.hibernate.basics;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CRUD_Controller {
    private SessionFactory factory = new Configuration()
            .addAnnotatedClass(PersonEntity.class)
            .buildSessionFactory();
    private Session session = factory.getCurrentSession();

    @RequestMapping("/create")
    public String create(@ModelAttribute("personEntity") PersonEntity person, Model model){
        try{
            PersonEntity personEnt = new PersonEntity();
            personEnt.setLastName(person.getLastName());
            personEnt.setFirstName(person.getFirstName());
            personEnt.setEmail(person.getEmail());
            model.addAttribute(person);
            this.session.beginTransaction();
            this.session.save(personEnt);
            this.session.getTransaction().commit();
        }
        finally{
            factory.close();
        }
        return "create";
    }

    @RequestMapping("/read")
    public String read(@ModelAttribute("personEntity") PersonEntity person, Model model){
        return "read";
    }

    @RequestMapping("/readEffect")
    public String readEffect(@ModelAttribute("personEntity") PersonEntity person, Model model){
        return "readEffect";
    }

    @RequestMapping("/delete")
    public String delete(@ModelAttribute("personEntity") PersonEntity person, Model model){
        return "delete";
    }

    @RequestMapping("/update")
    public String update(@ModelAttribute("personEntity") PersonEntity person, Model model){
        return "update";
    }

}
