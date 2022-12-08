package net.yorksolutions.emilymilldrumblogcmscapstonebe.Account;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import net.yorksolutions.emilymilldrumblogcmscapstonebe.Chat.Chat;
import net.yorksolutions.emilymilldrumblogcmscapstonebe.Comment.Comment;
import net.yorksolutions.emilymilldrumblogcmscapstonebe.Post.Post;

import javax.persistence.*;
import java.util.List;

@Entity
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String fName;
    private String lName;
    private String email;

    @JsonIgnore
    private String password;

    private String profilePic;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name="accountId")
    private List<Post> postList;

//    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
//    @JoinColumn(name="accountId")
//    private List<Comment> commentList;


//    //todo PM system
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name="accountId")
    private List<Chat> chatList;

    public Account(){

    }

//    public Account(Long id, String fName, String lName, String email, String password) {
//        this.id = id;
//        this.fName = fName;
//        this.lName = lName;
//        this.email = email;
//        this.password = password;
//    }

    public Account(AccountDTO requestDTO) {
        setfName(requestDTO.fName);
        setlName(requestDTO.lName);
        setEmail(requestDTO.email);
        setPassword(requestDTO.password);
        setProfilePic(requestDTO.profilePic);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getProfilePic() {
        return profilePic;
    }

    public void setProfilePic(String profilePic) {
        this.profilePic = profilePic;
    }

    public List<Post> getPostList() {
        return postList;
    }

    public void setPostList(List<Post> postList) {
        this.postList = postList;
    }

//    public List<Comment> getCommentList() {
//        return commentList;
//    }
//
//    public void setCommentList(List<Comment> commentList) {
//        this.commentList = commentList;
//    }


    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", fName='" + fName + '\'' +
                ", lName='" + lName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", profilePic='" + profilePic + '\'' +
                ", postList=" + postList +
                ", chatList=" + chatList +
                '}';
    }
}
