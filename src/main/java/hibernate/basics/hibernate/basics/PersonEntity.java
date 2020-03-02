package hibernate.basics.hibernate.basics;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "person", schema = "hibernate_test")
public class PersonEntity {
    @Id
    @Column(name = "id")
    private int id;

    @Basic
    @Column(name = "first_name")
    private String firstName;

    @Basic
    @Column(name = "last_name")
    private String lastName;

    @Basic
    @Column(name = "email")
    private String email;

    @OneToOne(targetEntity = PersonHobbyEntity.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "person_hobby_id")
    private PersonHobbyEntity personHobbyEntity;

    @OneToMany(targetEntity = DebtEntity.class, mappedBy = "personEntity",
            cascade = {CascadeType.DETACH, CascadeType.MERGE,
                    CascadeType.PERSIST, CascadeType.REFRESH},
    fetch = FetchType.EAGER)
    private List<DebtEntity> debtEntityList = new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "person_hobby_id")
    public PersonHobbyEntity getPersonHobbyEntity() {
        return personHobbyEntity;
    }

    public void setPersonHobbyEntity(PersonHobbyEntity personHobbyEntity) {
        this.personHobbyEntity = personHobbyEntity;
    }

    public List<DebtEntity> getDebtEntityList() {
        return debtEntityList;
    }

    public void setDebtEntityList(List<DebtEntity> debtEntityList) {
        this.debtEntityList = debtEntityList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonEntity that = (PersonEntity) o;
        return id == that.id &&
                Objects.equals(firstName, that.firstName) &&
                Objects.equals(lastName, that.lastName) &&
                Objects.equals(email, that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, email);
    }

    public void add(DebtEntity person){
        this.debtEntityList.add(person);
        person.setPersonEntity(this);
    }

    @Override
    public String toString() {
        return "PersonEntity{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
