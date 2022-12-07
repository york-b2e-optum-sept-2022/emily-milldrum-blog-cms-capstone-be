package net.yorksolutions.emilymilldrumblogcmscapstonebe.Post;

import net.yorksolutions.emilymilldrumblogcmscapstonebe.Account.Account;
import net.yorksolutions.emilymilldrumblogcmscapstonebe.Account.AccountUpdateDTO;
import net.yorksolutions.emilymilldrumblogcmscapstonebe.Comment.Comment;
import net.yorksolutions.emilymilldrumblogcmscapstonebe.Comment.CommentDTO;
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
    @GetMapping("/a/{id}")
    Iterable<Post> get(@PathVariable Long id) {return this.service.findPostsByAuthor(id);
    }


    @PutMapping("")
    public Post updatePost(@RequestBody PostUpdateDTO requestDTO){
        return this.service.updatePost(requestDTO);
    }

    @DeleteMapping("/{id}")
    public Post delete(@PathVariable Long id){
        return this.service.delete(id);
    }

//    @PutMapping("/comment/")
//    public Post addComment(@RequestBody Comment.CommentDTO commentDTO){
//        return this.service.addComment(commentDTO);
//    }

}
