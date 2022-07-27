package cvut.fel.entity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
@Entity
@Table(name = "customers")
@NamedQueries({
        @NamedQuery(name = "Customer.findByName", query = "SELECT u FROM Customer u WHERE u.name = :name"),
})
@Getter
@Setter
public class Customer extends AbstractEntity {
    @Column(unique = true)
    @NotNull
    public int phonenumber;

    public Account account;
    public Customer(String name) {
        this();
        this.name = name;
    }

    public Customer() {

    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phonenumber='" + phonenumber + '\'' +
                ", account='" + account + '\'' +
                '}';
    }
}
