package net.yorksolutions.emilymilldrumblogcmscapstonebe.Account;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/account")
@CrossOrigin
public class AccountController {

    AccountService service;
    public AccountController(AccountService accountService){
        this.service = accountService;
    }

    @PostMapping
    public Account create(@RequestBody AccountDTO requestDTO){
        return this.service.create(requestDTO);
    }

    @GetMapping
    Iterable<Account> get() {
        return this.service.getAccounts();
    }
//    @PutMapping
//    public Account update(@RequestBody AccountUpdateDTO requestDTO){
//        return this.service.update(requestDTO);
//    }

}
