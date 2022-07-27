package cvut.fel.entity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.Year;

@Entity
@Table(name = "accounts")
@NamedQueries({
        @NamedQuery(name = "Account.findByName", query = "SELECT u FROM Account u WHERE u.name = :name"),
})
@Getter
@Setter
public class Account extends AbstractEntity {
    @Column(unique = true)
    @NotNull
    public long amount;
    public Year creation;

    public Account(Long id) {
        this();
        this.id = id;
    }

    public Account() {

    }

    public Account(long i) {
        super();
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", amount='" + amount + '\'' +
                '}';
    }
}
