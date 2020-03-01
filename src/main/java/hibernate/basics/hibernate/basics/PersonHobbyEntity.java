package hibernate.basics.hibernate.basics;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "person_hobby", schema = "hibernate_test", catalog = "")
public class PersonHobbyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    private String hobby;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "hobby")
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
