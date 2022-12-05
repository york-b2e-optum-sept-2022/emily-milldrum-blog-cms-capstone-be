package net.yorksolutions.emilymilldrumblogcmscapstonebe.Post;
import net.yorksolutions.emilymilldrumblogcmscapstonebe.Comment.Comment;

import java.util.Date;
import java.util.List;

public class PostDTO {
    public Long authorId;
    public Date createDate;
    public Date updateDate;
    public String title;
    public String body;
    public List<Comment> commentList;
}
