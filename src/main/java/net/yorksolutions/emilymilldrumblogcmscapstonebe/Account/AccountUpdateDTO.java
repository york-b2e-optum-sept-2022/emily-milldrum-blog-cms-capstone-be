package net.yorksolutions.emilymilldrumblogcmscapstonebe.Account;

import net.yorksolutions.emilymilldrumblogcmscapstonebe.Post.Post;

import java.util.List;

public class AccountUpdateDTO {
    public Long id;
    public String fName;
    public String lName;
    public String email;
    public List<Post> postList;
}