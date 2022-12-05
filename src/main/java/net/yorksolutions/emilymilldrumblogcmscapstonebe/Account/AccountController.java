package net.yorksolutions.emilymilldrumblogcmscapstonebe.Account;

import org.springframework.web.bind.annotation.*;

import java.util.Optional;

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
    @GetMapping("/{id}")
    public Optional<Account> getAccountById(@PathVariable Long id){
        return this.service.getAccountById(id);
    }

    @GetMapping("/login")
    public Account login(@RequestParam String email, @RequestParam String password) {
        return this.service.login(email, password);
    }
//    @PutMapping
//    public Account update(@RequestBody AccountUpdateDTO requestDTO){
//        return this.service.update(requestDTO);
//    }

}
