package net.yorksolutions.emilymilldrumblogcmscapstonebe.Post;

import net.yorksolutions.emilymilldrumblogcmscapstonebe.Account.Account;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/post")
@CrossOrigin
public class PostController {

    PostService service;
    public PostController(PostService service){
        this.service = service;
    }


    @PostMapping
    public Post create(@RequestBody PostDTO requestDTO){
        return this.service.create(requestDTO);
    }

    @GetMapping
    Iterable<Post> get() {
        return this.service.getAllPosts();
    }

}
