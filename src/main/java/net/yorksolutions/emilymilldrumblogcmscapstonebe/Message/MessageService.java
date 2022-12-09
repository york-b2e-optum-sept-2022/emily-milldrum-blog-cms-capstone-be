package net.yorksolutions.emilymilldrumblogcmscapstonebe.Message;
import net.yorksolutions.emilymilldrumblogcmscapstonebe.Account.Account;
import net.yorksolutions.emilymilldrumblogcmscapstonebe.Account.AccountService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MessageService {

    MessageRepository messageRepository;
    AccountService accountService;

    public MessageService(MessageRepository messageRepository, AccountService accountService){
        this.messageRepository = messageRepository;
        this.accountService = accountService;
    }

    //add message
    public Message add(NewMessageDTO messageDTO){
        return this.messageRepository.save(new Message(messageDTO));
    }

    //get messages
    public List<Message> getAll(Long senderId, Long receiverId){

        Account sender = this.accountService.getAccountById(senderId);
        Account receiver = this.accountService.getAccountById(receiverId);
        Iterable<Message> first = this.messageRepository.findAllBySenderAndReceiver(sender, receiver);
        Iterable<Message> second = this.messageRepository.findAllBySenderAndReceiver(receiver, sender);

        List<Message> messageList = new ArrayList<>();
        for (Message message: first)
        {
            messageList.add(message);
        }
        for (Message message: second)
        {
            messageList.add(message);
        }

       // return this.messageRepository.findAllBySenderAndReceiver(sender, receiver);
        return messageList;
    }


}
