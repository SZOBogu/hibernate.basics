package hibernate.basics.hibernate.basics;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.validator.internal.constraintvalidators.bv.time.pastorpresent.PastOrPresentValidatorForJapaneseDate;
import org.springframework.expression.spel.support.DataBindingPropertyAccessor;

import java.util.List;
import java.util.Scanner;

public class Menu {
    public void createPerson(SessionFactory factory, Session session){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter name:");
        String name = scanner.nextLine();
        System.out.println("Enter last name:");
        String lastName = scanner.nextLine();
        System.out.println("Enter email:");
        String email = scanner.nextLine();

        List<HobbyEntity> hobbies = this.readAllHobbies(factory, session);
        for(HobbyEntity hobbyEntity : hobbies){
            System.out.println(hobbyEntity);
        }

        System.out.println("Enter hobby id:");
        Integer hobbyId = scanner.nextInt();
//
//        List<ProjectEntity> projectEntities = this.readAllProjects(factory, session);
//        for(ProjectEntity projectEntity : projectEntities){
//            System.out.println(projectEntity);
//        }
//        System.out.println("Enter project id:");
//		Integer projectId = scanner.nextInt();

        PersonEntity person = new PersonEntity();

        person.setFirstName(name);
        person.setLastName(lastName);
        person.setEmail(email);

        try {
            session.getTransaction().begin();
            HobbyEntity hobbyEntity = session.get(HobbyEntity.class, hobbyId);
//            ProjectEntity projectEntity = session.get(ProjectEntity.class, projectId);
            person.setHobbyEntity(hobbyEntity);
//            person.addProjectEntity(projectEntity);
            session.save(person);
            session.getTransaction().commit();
            session.close();
        }
        finally{
            factory.close();
        }

    }

    public void createHobby(SessionFactory factory, Session session){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter hobby:");
        String hobby = scanner.nextLine();

        try {
            session.getTransaction().begin();
            HobbyEntity hobbyEntity = new HobbyEntity();
            hobbyEntity.setHobby(hobby);
            session.save(hobbyEntity);
            session.getTransaction().commit();
            session.close();
        }
        finally{
            factory.close();
        }
    }

    public void createProject(SessionFactory factory, Session session){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter name:");
        String name = scanner.nextLine();
        System.out.println("Enter description:");
        String description = scanner.nextLine();
        System.out.println("Enter budget:");
        Integer budget = scanner.nextInt();
        this.readAllPeople(factory, session);
        System.out.println("Enter id of a guy:");
        Integer personId = scanner.nextInt();

        PersonEntity person;

        ProjectEntity projectEntity = new ProjectEntity();
        projectEntity.setName(name);
        projectEntity.setDescription(description);
        projectEntity.setBudget(budget);

        try {
            session.getTransaction().begin();
            person = session.get(PersonEntity.class, personId);
            projectEntity.setPersonEntity(person);
            session.getTransaction().commit();
            session.close();
        }
        finally{
            factory.close();
        }
    }

    public PersonEntity readPerson(SessionFactory factory, Session session){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter person id:");
        Integer personId = scanner.nextInt();
        PersonEntity personEntity;
        try {
            session.getTransaction().begin();
            personEntity = session.get(PersonEntity.class, personId);
            session.getTransaction().commit();
//			session.close();
        }
        finally{
//			factory.close();
            System.out.print("");
        }
        return personEntity;
    }

    public HobbyEntity readHobby(SessionFactory factory, Session session){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter hobby id:");
        Integer hobbyId = scanner.nextInt();
        HobbyEntity hobbyEntity;

        try {
            session.getTransaction().begin();
            hobbyEntity = session.get(HobbyEntity.class, hobbyId);
            session.getTransaction().commit();

//			session.close();
        }
        finally{
//			factory.close();
            System.out.print("");
        }
        return hobbyEntity;
    }

    public ProjectEntity readProject(SessionFactory factory, Session session){
        Scanner scanner = new Scanner(System.in);
        List<ProjectEntity> projectEntities = this.readAllProjects(factory, session);
        for(ProjectEntity projectEntity : projectEntities){
            System.out.println(projectEntities);
        }
        System.out.println("Enter project id:");
        Integer projectId = scanner.nextInt();
        ProjectEntity projectEntity;
        try {
            session.getTransaction().begin();
            projectEntity = session.get(ProjectEntity.class, projectId);
            session.getTransaction().commit();
//			session.close();
        }
        finally{
//			factory.close();
            System.out.printf("");
        }
        return projectEntity;
    }

    public List<PersonEntity> readAllPeople(SessionFactory factory, Session session){
        List<PersonEntity> people;
        try {
            session.getTransaction().begin();
            people = session.createQuery(" from PersonEntity").getResultList();
            session.getTransaction().commit();
//			session.close();
        }
        finally{
//			factory.close();
            System.out.printf("");
        }
        return people;
    }

    public List<HobbyEntity> readAllHobbies(SessionFactory factory, Session session){
        List<HobbyEntity> hobbies;
        try {
            session.getTransaction().begin();
            hobbies = session.createQuery(" from HobbyEntity").getResultList();
            session.getTransaction().commit();
//			session.close();
        }
        finally{
//			factory.close();
            System.out.printf("");
        }
        return hobbies;
    }

    public List<ProjectEntity> readAllProjects(SessionFactory factory, Session session){
        List<ProjectEntity> projectEntities;
        try {
            session.getTransaction().begin();
            projectEntities = session.createQuery(" from ProjectEntity ").getResultList();
            session.getTransaction().commit();
//			session.close();
        }
        finally{
//			factory.close();
            System.out.printf("");
        }
        return projectEntities;
    }

    public void updatePerson(SessionFactory factory, Session session){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter person id:");
        Integer personId = scanner.nextInt();
        System.out.println("Enter name:");
        String name = scanner.nextLine();
        System.out.println("Enter last name:");
        String lastName = scanner.nextLine();
        System.out.println("Enter email:");
        String email = scanner.nextLine();

        List<HobbyEntity> hobbies = this.readAllHobbies(factory, session);
        for(HobbyEntity hobbyEntity : hobbies){
            System.out.println(hobbyEntity);
        }

        System.out.println("Enter hobby id:");
        Integer hobbyId = scanner.nextInt();

        List<ProjectEntity> projectEntities = this.readAllProjects(factory, session);
        for(ProjectEntity projectEntity : projectEntities){
            System.out.println(projectEntity);
        }
        System.out.println("Enter project id:");
        Integer projectId = scanner.nextInt();


        try {
            session.getTransaction().begin();
            PersonEntity person = session.get(PersonEntity.class, personId);
            person.setFirstName(name);
            person.setLastName(lastName);
            person.setEmail(email);
            HobbyEntity hobbyEntity = session.get(HobbyEntity.class, hobbyId);
            person.setHobbyEntity(hobbyEntity);
            ProjectEntity projectEntity = session.get(ProjectEntity.class, projectId);
            person.addProjectEntity(projectEntity);
            session.save(person);
            session.getTransaction().commit();
            session.close();
        }
        finally{
            factory.close();
        }
    }

    public void updateHobby(SessionFactory factory, Session session){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter hobby id:");
        Integer hobbyId = scanner.nextInt();
        System.out.println("Enter hobby:");
        String hobby = scanner.nextLine();

        try {
            session.getTransaction().begin();
            HobbyEntity hobbyEntity = session.get(HobbyEntity.class, hobbyId);
            hobbyEntity.setHobby(hobby);
            session.save(hobbyEntity);
            session.getTransaction().commit();
            session.close();
        }
        finally{
            factory.close();
        }
    }

    public void updateProject(SessionFactory factory, Session session){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter name:");
        String name = scanner.nextLine();
        System.out.println("Enter description:");
        String description = scanner.nextLine();
        System.out.println("Enter budget:");
        Integer budget = scanner.nextInt();
        this.readAllPeople(factory, session);
        System.out.println("Enter id of a guy:");
        Integer personId = scanner.nextInt();

        ProjectEntity projectEntity = new ProjectEntity();
        projectEntity.setName(name);
        projectEntity.setDescription(description);
        projectEntity.setBudget(budget);

        try {
            session.getTransaction().begin();
            projectEntity.setPersonEntity(session.get(PersonEntity.class, personId));
            session.save(projectEntity);
            session.getTransaction().commit();
            session.close();
        }
        finally{
            factory.close();
        }
    }

    public void deletePerson(SessionFactory factory, Session session){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter person id:");
        Integer id = scanner.nextInt();

        try {
            session.getTransaction().begin();
            PersonEntity person = session.get(PersonEntity.class, id);
            session.delete(person);
            session.getTransaction().commit();
            System.out.println("Pronto usunieto ");
            session.close();
        }
        finally {
            factory.close();
        }
    }

    public void deleteHobby(SessionFactory factory, Session session){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter hobby id:");
        Integer id = scanner.nextInt();

        try {
            session.getTransaction().begin();
            HobbyEntity hobby = session.get(HobbyEntity.class, id);
            session.delete(hobby);
            session.getTransaction().commit();
            System.out.println("Pronto usunieto ");
            session.close();
        }
        finally {
            factory.close();
        }
    }

    public void deleteProject(SessionFactory factory, Session session){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Project id:");
        Integer id = scanner.nextInt();

        try {
            session.getTransaction().begin();
            ProjectEntity projectEntity = session.get(ProjectEntity.class, id);
            session.delete(projectEntity);
            session.getTransaction().commit();
            System.out.println("Pronto usunieto ");
            session.close();
        }
        finally {
            factory.close();
        }
    }

    public void deleteAllPeople(SessionFactory factory, Session session){
        try {
            session.getTransaction().begin();
            List<PersonEntity> people = session.createQuery(" from PersonEntity ").getResultList();

            for (PersonEntity personEntity : people) {
                session.delete(personEntity);
            }
            session.getTransaction().commit();
            session.close();
        }
        finally{
            factory.close();
        }
    }

    public void deleteAllHobbies(SessionFactory factory, Session session){
        try {
            session.getTransaction().begin();
            List<HobbyEntity> hobbies = session.createQuery(" from HobbyEntity ").getResultList();

            for (HobbyEntity hobbyEntity : hobbies) {
                session.delete(hobbyEntity);
            }
            session.getTransaction().commit();
            session.close();
        }
        finally{
            factory.close();
        }

    }

    public void deleteAllProjects(SessionFactory factory, Session session){
        try {
            session.getTransaction().begin();
            List<ProjectEntity> projectEntities = session.createQuery(" from ProjectEntity ").getResultList();

            for (ProjectEntity projectEntity: projectEntities) {
                session.delete(projectEntity);
            }
            session.getTransaction().commit();
            session.close();
        }
        finally{
            factory.close();
        }

    }

    public void menu(SessionFactory factory, Session session){
        System.out.println("Write something you shitface\n");
        Scanner scanner = new Scanner(System.in);
        int menuChoice = scanner.nextInt();

        //createPerson
        if(menuChoice == 1) {
            this.createPerson(factory, session);
        }
        //createHobby
        else if(menuChoice == 2) {
            this.createHobby(factory, session);
        }
        //createProject
        else if(menuChoice == 3) {
            this.createProject(factory, session);
        }
        //readPerson
        else if(menuChoice == 4) {
            PersonEntity personEntity = this.readPerson(factory, session);
            System.out.println(personEntity);
            session.close();
        }

//        //readHobby
        else if(menuChoice == 5) {
            HobbyEntity hobbyEntity =  this.readHobby(factory, session);
            System.out.println(hobbyEntity);
            session.close();
        }
        //readProject
        else if(menuChoice == 6) {
            ProjectEntity ProjectEntity = this.readProject(factory, session);
            System.out.println(ProjectEntity);

            session.close();
        }
        //readAllPeople
        else if(menuChoice == 7) {
            List<PersonEntity> people = this.readAllPeople(factory, session);
            for(PersonEntity personEntity : people){
                System.out.println(personEntity);
            }
            session.close();
        }

//        //readAllHobbies
        else if(menuChoice == 8) {
            List<HobbyEntity> hobbies = this.readAllHobbies(factory, session);
            for(HobbyEntity hobbyEntity : hobbies){
                System.out.println(hobbyEntity);
            }
            session.close();
        }

        //readAllProjects
        else if(menuChoice == 9) {
            List<ProjectEntity> Projects = this.readAllProjects(factory, session);
            for(ProjectEntity ProjectEntity : Projects){
                System.out.println(ProjectEntity);
            }
            session.close();
        }

        //updatePerson
        else if(menuChoice == 10) {
            this.updatePerson(factory, session);
        }

//        updateHobby
        else if(menuChoice == 11) {
            this.updateHobby(factory, session);
        }

        //updateProject
        else if(menuChoice == 12) {
            this.updateProject(factory, session);
        }
        //deletePerson
        else if(menuChoice == 13) {
            this.deletePerson(factory, session);
        }

//        //deleteHobby
        else if(menuChoice == 14) {
            this.deleteHobby(factory, session);
        }
        //deleteProject
        else if(menuChoice == 15) {
            this.deleteProject(factory, session);
        }
        //deleteAllPeople
        else if(menuChoice == 16) {
            this.deleteAllPeople(factory, session);
        }
//        //deleteAllHobbies
        else if(menuChoice == 17) {
            this.deleteAllHobbies(factory, session);
        }
        //deleteAllProjects
        else if(menuChoice == 18) {
            this.deleteAllProjects(factory, session);
        }
    }
}
