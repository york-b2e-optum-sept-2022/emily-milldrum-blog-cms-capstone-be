package net.yorksolutions.emilymilldrumblogcmscapstonebe.Comment;

import net.yorksolutions.emilymilldrumblogcmscapstonebe.Account.Account;

import java.util.Date;

public class CommentDTO {
    public Account author;

    public Long postId;

    public Date createDate;

    public Date updateDate;

    public String comment;

}
