package net.yorksolutions.emilymilldrumblogcmscapstonebe.Account;

import org.springframework.stereotype.Service;

@Service
public class AccountService {

    AccountRepository repository;

    public AccountService(AccountRepository accountRepository)
    {
        this.repository = accountRepository;
    }

    public Account create(AccountDTO requestDTO) {
        Account newAct = new Account(requestDTO);
        return this.repository.save(newAct);
    }

    public Iterable<Account> getAccounts() {
        return repository.findAll();
    }

//    public Account update(AccountUpdateDTO requestDTO) {
//    }
}
