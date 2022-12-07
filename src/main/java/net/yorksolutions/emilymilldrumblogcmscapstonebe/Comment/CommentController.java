package net.yorksolutions.emilymilldrumblogcmscapstonebe.Comment;


import net.yorksolutions.emilymilldrumblogcmscapstonebe.Post.Post;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/comment/")
@CrossOrigin
public class CommentController {

    CommentService service;

    public CommentController(CommentService service){
        this.service = service;
    }

    @PostMapping
    public Post addToStage(@RequestBody CommentDTO requestDTO){
        return this.service.addToPost(requestDTO);
    }

}
