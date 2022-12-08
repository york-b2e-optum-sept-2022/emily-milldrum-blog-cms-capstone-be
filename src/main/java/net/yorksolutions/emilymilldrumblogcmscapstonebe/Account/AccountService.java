package net.yorksolutions.emilymilldrumblogcmscapstonebe.Account;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

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

    public Optional<Account> getAccountById(Long id) {
        Optional<Account> accountOpt = this.repository.findById(id);
        if(accountOpt.isEmpty())
        {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return accountOpt;
    }

    public Account login(String email, String password) {
        Optional<Account> accountOpt = this.repository.findByEmailAndPassword(email, password);
        if (accountOpt.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return accountOpt.get();
    }

    public Account updatePost(AccountUpdateDTO requestDTO) {
        Optional<Account> accountOpt = this.getAccountById(requestDTO.id);
        Account account = accountOpt.get();
        //account.getPostList()
        //account.getPostList().clear();
        //account.getPostList().addAll(requestDTO.postList);

        return this.repository.save(account);
    }

}
