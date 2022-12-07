package net.yorksolutions.emilymilldrumblogcmscapstonebe.Comment;


import net.yorksolutions.emilymilldrumblogcmscapstonebe.Post.Post;
import org.springframework.web.bind.annotation.*;

import javax.xml.xpath.XPathVariableResolver;
import java.util.Map;

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

    @DeleteMapping("/{id}")
    public Post delete(@PathVariable Long id){
        return this.service.delete(id);
    }

//
//    ]CommentUpdateDTO requestDTO){
//        return this.service.delete(requestDTO);
//    }

}
