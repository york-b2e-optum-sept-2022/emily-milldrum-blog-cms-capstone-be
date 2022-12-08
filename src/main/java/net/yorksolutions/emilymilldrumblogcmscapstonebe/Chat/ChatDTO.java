package net.yorksolutions.emilymilldrumblogcmscapstonebe.Chat;

import net.yorksolutions.emilymilldrumblogcmscapstonebe.Account.Account;
import net.yorksolutions.emilymilldrumblogcmscapstonebe.Message.Message;

import java.util.List;

public class ChatDTO {
//
//    public Long senderId;
//    public Long recipientId;

    public List<Long> accountList;
    public List<Message> messageList;

    @Override
    public String toString() {
        return "ChatDTO{" +
                "accountList=" + accountList +
                ", messageList=" + messageList +
                '}';
    }
}
