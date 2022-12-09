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
    public Comment addToPost(@RequestBody CommentDTO requestDTO){
        return this.service.addToPost(requestDTO);
    }

    @DeleteMapping("/{id}")
    public Post delete(@PathVariable Long id){
        return this.service.delete(id);
    }

    @PutMapping
    public Comment update(@RequestBody CommentUpdateDTO requestDTO){
        return this.service.update(requestDTO);
    }
}
