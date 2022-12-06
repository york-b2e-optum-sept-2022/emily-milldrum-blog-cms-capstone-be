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

    private Date createDate;

    private Date updateDate;

    private String comment;

    public Comment()
    {

    }
    public Comment(Account author, Date createDate, Date updateDate, String comment) {
        setAuthor(author);
        setCreateDate(createDate);
        setUpdateDate(updateDate);
        setComment(comment);
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

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
