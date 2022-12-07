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

    public Post delete(Long id) {
        Optional<Comment> comOpt = repo.findById(id);
        if (comOpt.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        Comment comment = comOpt.get();
        Optional<Post> found = postRepo.findById(comment.getPostId());
        if (found.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        Post post = found.get();
        this.repo.deleteById(id);
        return post;
    }
}
