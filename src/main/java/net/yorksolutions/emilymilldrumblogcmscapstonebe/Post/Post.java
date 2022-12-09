package net.yorksolutions.emilymilldrumblogcmscapstonebe.Post;
import net.yorksolutions.emilymilldrumblogcmscapstonebe.Account.Account;
import net.yorksolutions.emilymilldrumblogcmscapstonebe.Comment.Comment;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

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

    @ElementCollection(fetch = FetchType.EAGER)
    private Set<Long> views;

    public Post() {

    }

    public void removeComment(Comment incComment){
        commentList.remove(incComment);
    }
    public void addComment(Comment incComment){
        List<Comment> list = getComment();
        list.add(incComment);
        setComment(list);
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

    public Set<Long> getViews() {
        return views;
    }

    public void setViews(Set<Long> views) {
        this.views = views;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", author=" + author +
                ", createDate=" + createDate +
                ", updateDate=" + updateDate +
                ", title='" + title + '\'' +
                ", body='" + body + '\'' +
                ", commentList=" + commentList +
                ", views=" + views +
                '}';
    }
}
