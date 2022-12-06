package net.yorksolutions.emilymilldrumblogcmscapstonebe.Post;

import net.yorksolutions.emilymilldrumblogcmscapstonebe.Account.Account;
import net.yorksolutions.emilymilldrumblogcmscapstonebe.Account.AccountService;
import org.springframework.stereotype.Service;

@Service
public class PostService {

    PostRepository repository;
    AccountService accountService;

    public PostService(PostRepository repository, AccountService accountService) {
        this.repository = repository;
        this.accountService =accountService;
    }
    public Post create(PostDTO requestDTO) {

        Account author = this.accountService.getAccountById(requestDTO.author.getId()).get();
        return this.repository.save(new Post(requestDTO, author));
    }

    public Iterable<Post> getAllPosts() {
        return this.repository.findAll();
    }

    public Post updatePost(PostUpdateDTO requestDTO) {
    }
}
