package net.yorksolutions.emilymilldrumblogcmscapstonebe.Post;
import net.yorksolutions.emilymilldrumblogcmscapstonebe.Account.Account;
import net.yorksolutions.emilymilldrumblogcmscapstonebe.Comment.Comment;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Post {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @ManyToOne
    private Account author;
    private Date createDate;
    private Date updateDate;
    private String title;

    //@lob
    @Column(columnDefinition = "TEXT")
    private String body;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name="postId")
    private List<Comment> commentList;

    public Post() {

    }

    public Post(PostDTO post, Account author){
        setAuthor(author);
        setCreateDate(post.createDate);
        setUpdateDate(post.updateDate);
        setTitle(post.title);
        setBody(post.body);
        setComment(post.commentList);
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

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public List<Comment> getComment() {
        return commentList;
    }

    public void setComment(List<Comment> commentList) {
        this.commentList = commentList;
    }
}
