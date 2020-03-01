package hibernate.basics.hibernate.basics;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "person_hobby", schema = "hibernate_test")
public class PersonHobbyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Basic
    @Column(name = "hobby")
    private String hobby;

    @OneToOne(targetEntity = PersonEntity.class,
    mappedBy = "personHobbyEntity",
            cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
//    @OneToOne(targetEntity = PersonEntity.class)
    private PersonEntity personEntity;

    public PersonEntity getPersonEntity() {
        return personEntity;
    }

    public void setPersonEntity(PersonEntity personEntity) {
        this.personEntity = personEntity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonHobbyEntity that = (PersonHobbyEntity) o;
        return id == that.id &&
                Objects.equals(hobby, that.hobby);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, hobby);
    }
}
