package net.yorksolutions.emilymilldrumblogcmscapstonebe.Comment;

import net.yorksolutions.emilymilldrumblogcmscapstonebe.Account.Account;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Comment {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @ManyToOne
    private Account author;

    private Long postId;

    private Date createDate;

    private Date updateDate;

    private String comment;

    public Comment()
    {

    }
    public Comment(CommentDTO requestDTO){ //create comment object
        setAuthor(requestDTO.author);
        setPostId(requestDTO.postId);
        setCreateDate(requestDTO.createDate);
        setComment(requestDTO.comment);
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Long getId() {
        return id;
    }

    public Account getAuthor() {
        return author;
    }

    public void setAuthor(Account author) {
        this.author = author;
    }

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {

        this.createDate = new Date();
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate() {
        this.updateDate = new Date();
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
