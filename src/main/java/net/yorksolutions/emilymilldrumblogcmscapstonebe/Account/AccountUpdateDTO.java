package net.yorksolutions.emilymilldrumblogcmscapstonebe.Account;
import net.yorksolutions.emilymilldrumblogcmscapstonebe.Post.Post;
import java.util.List;

public class AccountUpdateDTO extends AccountDTO{
    public Long id;
    public List<Post> postList;
}