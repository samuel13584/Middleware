package cvut.fel.service;

import cvut.fel.entity.Account;
import cvut.fel.exception.FieldMissingException;
import cvut.fel.exception.NotFoundException;
import cvut.fel.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImp implements AccountService {

    private final AccountRepository accountRepository;

    @Autowired
    public AccountServiceImp(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Account findById(Long id){

        if (id == null)
            throw new FieldMissingException();
        return accountRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Account_NOT_FOUND"));
    }

}
