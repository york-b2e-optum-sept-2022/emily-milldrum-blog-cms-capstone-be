package net.yorksolutions.emilymilldrumblogcmscapstonebe.Chat;

import net.yorksolutions.emilymilldrumblogcmscapstonebe.Account.Account;
import net.yorksolutions.emilymilldrumblogcmscapstonebe.Message.Message;

import javax.persistence.*;
import java.util.List;

@Entity
public class Chat {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

   // private Long senderId;
    //private Long recipientId;
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Account> accountList;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Message> messageList;

    public Chat() {

    }

    public Chat(List<Account> accountList, List<Message> messageList) {
       // setAccountList(accountList);
        setMessageList(messageList);
    }

    public Chat(ChatDTO incChat, List<Account> accountList) {
        setAccountList(accountList);
       // setRecipientId(incChat.recipientId);
       // setSenderId(incChat.senderId);
        setMessageList(incChat.messageList);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

//    public Long getSenderId() {
//        return senderId;
//    }
//
//    public void setSenderId(Long senderId) {
//        this.senderId = senderId;
//    }
//
//    public Long getRecipientId() {
//        return recipientId;
//    }
//
//    public void setRecipientId(Long recipientId) {
//        this.recipientId = recipientId;
//    }

        public List<Account> getAccountList() {
        return accountList;
    }

    public void setAccountList(List<Account> accountList) {
        this.accountList = accountList;
    }

    public List<Message> getMessageList() {
        return messageList;
    }

    public void setMessageList(List<Message> messageList) {
        this.messageList = messageList;
    }

    @Override
    public String toString() {
        return "Chat{" +
                "id=" + id +
//                ", accountList=" + accountList +
                ", messageList=" + messageList +
                '}';
    }
}
