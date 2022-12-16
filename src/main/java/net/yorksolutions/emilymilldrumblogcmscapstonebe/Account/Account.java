package net.yorksolutions.emilymilldrumblogcmscapstonebe.Account;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.*;
import java.util.Objects;

//em
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

    public Account(){

    }

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
        if (Objects.equals(fName, ""))
        {
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        }
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        if (Objects.equals(lName, ""))
        {
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        }
        this.lName = lName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (Objects.equals(email, ""))
        {
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        }
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        if (Objects.equals(password, ""))
        {
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        }
        if (password.length() < 4){
            throw new ResponseStatusException(HttpStatus.LENGTH_REQUIRED);
        }
        this.password = password;
    }

    public String getProfilePic() {
        return profilePic;
    }

    public void setProfilePic(String profilePic) {
        this.profilePic = profilePic;
    }
}
