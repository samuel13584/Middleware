package cvut.fel.repository;

import cvut.fel.entity.Account;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AccountRepository extends CrudRepository<Account, Long> {

    List<Account> findByName(String name);


}
