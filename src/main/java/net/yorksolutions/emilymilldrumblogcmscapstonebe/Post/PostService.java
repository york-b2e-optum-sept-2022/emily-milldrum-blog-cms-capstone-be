package net.yorksolutions.emilymilldrumblogcmscapstonebe.Post;

import net.yorksolutions.emilymilldrumblogcmscapstonebe.Account.Account;
import net.yorksolutions.emilymilldrumblogcmscapstonebe.Account.AccountService;
import net.yorksolutions.emilymilldrumblogcmscapstonebe.Comment.Comment;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    PostRepository repository;
    AccountService accountService;

    public PostService(PostRepository repository, AccountService accountService) {
        this.repository = repository;
        this.accountService =accountService;
    }
    public Post create(PostDTO requestDTO) {

        Account author = this.accountService.getAccountById(requestDTO.author.getId());
        return this.repository.save(new Post(requestDTO, author));
    }

    public Iterable<Post> getAllPosts() {
        return this.repository.findAll();
    }

    public Optional<Post> postOpt(Long id) {
        Optional<Post> postOpt = this.repository.findById(id);
        if (postOpt.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        } else {
            return postOpt;
        }
    }
    public Post updatePost(PostUpdateDTO requestDTO) {
        Post post=this.postOpt(requestDTO.id).get();
        post.setTitle(requestDTO.title);
        post.setBody(requestDTO.body);
        post.setUpdateDate(requestDTO.updateDate);
        post.setViews(requestDTO.views);
//        post.setAuthor(requestDTO.author);

        //TODO null issue here
        //testing add comment
//        List<Comment> comments = post.getComment();
//        for (Comment comment: comments)
//        {
//            System.out.println(comment.getComment());
//        }
//
//        System.out.println(post.getComment());
//        post.getComment().clear();
//        System.out.println(post.getComment());
//        post.getComment().addAll(requestDTO.commentList);
//        System.out.println(post.getComment());

        return this.repository.save(post);
    }

    public Post delete(Long id) {
        Post post=this.postOpt(id).get();
        this.repository.deleteById(id);
        System.out.println(post);
        return post;
//
//        Optional<Post> postOpt=this.postOpt(id);
//        } else {
//            StageOptions options = stageOpt.get();
//            Optional<Stage> found = stageRepository.findStageByStageOptions(options);
//            if (found.isEmpty()) {
//                throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
//            } else {
//                Stage stage = found.get();
//                this.stageOptionsRepository.deleteById(optId);
//                return stage;
//            }
//        }
    }

    public Iterable<Post> findPostsByAuthor(Long id) {
        Account author = this.accountService.getAccountById(id);
        return this.repository.findPostsByAuthor(author);
    }
}
