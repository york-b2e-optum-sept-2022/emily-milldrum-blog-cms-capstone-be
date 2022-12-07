package net.yorksolutions.emilymilldrumblogcmscapstonebe.Post;

import net.yorksolutions.emilymilldrumblogcmscapstonebe.Account.Account;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends CrudRepository <Post, Long>{

    Iterable<Post> findPostsByAuthor(Account author);
}
