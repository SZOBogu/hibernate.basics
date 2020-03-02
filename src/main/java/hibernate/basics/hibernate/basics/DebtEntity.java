package hibernate.basics.hibernate.basics;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "debt", schema = "hibernate_test")
public class DebtEntity {
    @Id
    @Column(name = "id")
    private int id;

    @Basic
    @Column(name = "type")
    private String type;

    @Basic
    @Column(name = "sum")
    private Integer sum;

    @ManyToOne(targetEntity = PersonEntity.class,
            cascade = {CascadeType.DETACH, CascadeType.MERGE,
                    CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name="person_id")
    private PersonEntity personEntity;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getSum() {
        return sum;
    }

    public void setSum(Integer sum) {
        this.sum = sum;
    }

    public PersonEntity getPersonEntity() {
        return personEntity;
    }

    public void setPersonEntity(PersonEntity personEntity) {
        this.personEntity = personEntity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DebtEntity that = (DebtEntity) o;
        return id == that.id &&
                Objects.equals(type, that.type) &&
                Objects.equals(sum, that.sum);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type, sum);
    }

    @Override
    public String toString() {
        return "DebtEntity{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", sum=" + sum +
                ", personEntity=" + personEntity +
                '}';
    }
}
