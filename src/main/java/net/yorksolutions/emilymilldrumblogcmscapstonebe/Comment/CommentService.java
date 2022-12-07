package net.yorksolutions.emilymilldrumblogcmscapstonebe.Comment;

import net.yorksolutions.emilymilldrumblogcmscapstonebe.Post.Post;
import net.yorksolutions.emilymilldrumblogcmscapstonebe.Post.PostRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class CommentService {

    CommentRepository repo;
    PostRepository postRepo;
    public CommentService(CommentRepository repo, PostRepository postRepo){
        this.repo = repo;
        this.postRepo = postRepo;
    }
    public Post addToPost(CommentDTO requestDTO) {
        Comment comment = new Comment(requestDTO);
        this.repo.save(comment);
        Optional<Post> postOpt = this.postRepo.findById(requestDTO.postId);
        if (postOpt.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        Post post = postOpt.get();

        post.addComment(comment);
        return this.postRepo.save(post);
    }
}
