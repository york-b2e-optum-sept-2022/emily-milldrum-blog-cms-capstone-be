package net.yorksolutions.emilymilldrumblogcmscapstonebe.Comment;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Comment {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    //author, post, date, update date, string

    public void setId(Long id) {
        this.id = id;
    }


    public Long getId() {
        return id;
    }
}
