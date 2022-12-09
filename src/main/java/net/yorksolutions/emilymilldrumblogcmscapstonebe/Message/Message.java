package net.yorksolutions.emilymilldrumblogcmscapstonebe.Message;

import net.yorksolutions.emilymilldrumblogcmscapstonebe.Account.Account;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Message {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private Date createDate;

    @ManyToOne
    private Account sender;
    @ManyToOne
    private Account receiver;
    private String message;

    public Message(NewMessageDTO messageDTO) {
        setCreateDate(new Date());
        setReceiver(messageDTO.receiver);
        setSender(messageDTO.sender);
        setMessage(messageDTO.message);
    }

    public Message() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Account getSender() {
        return sender;
    }

    public void setSender(Account sender) {
        this.sender = sender;
    }

    public Account getReceiver() {
        return receiver;
    }

    public void setReceiver(Account receiver) {
        this.receiver = receiver;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
