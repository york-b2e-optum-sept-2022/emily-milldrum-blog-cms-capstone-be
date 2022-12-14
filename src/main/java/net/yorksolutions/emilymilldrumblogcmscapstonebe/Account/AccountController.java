package net.yorksolutions.emilymilldrumblogcmscapstonebe.Account;

import net.yorksolutions.emilymilldrumblogcmscapstonebe.Comment.CommentService;
import net.yorksolutions.emilymilldrumblogcmscapstonebe.Post.Post;
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
    public Account getAccountById(@PathVariable Long id){
        return this.service.getAccountById(id);
    }

    @PutMapping()
    public Account updateAccount(@RequestBody AccountProfileDTO requestDTO){
        return this.service.updateAccount(requestDTO);
    }


    @GetMapping("/login")
    public Account login(@RequestParam String email, @RequestParam String password) {
        return this.service.login(email, password);
    }
    @PutMapping("/post")
    public Account updatePost(@RequestBody AccountUpdateDTO requestDTO){
        return this.service.updatePost(requestDTO);
    }

}
