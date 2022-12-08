package net.yorksolutions.emilymilldrumblogcmscapstonebe.Chat;

import net.yorksolutions.emilymilldrumblogcmscapstonebe.Account.Account;
import net.yorksolutions.emilymilldrumblogcmscapstonebe.Account.AccountRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ChatService {

    ChatRepository repository;
    AccountRepository accountRepository;

    public ChatService(){}
    public ChatService(ChatRepository chatRepository, AccountRepository accountRepository) {
        this.repository = chatRepository;
        this.accountRepository = accountRepository;
    }

    public List<Account> makeAcctList(List<Long> requestList){
        List<Account> accountList = new ArrayList<>();
        for (Long id: requestList)
        {
            Optional<Account> accountOpt = this.accountRepository.findById(id);
            if(accountOpt.isEmpty()){
                throw new ResponseStatusException(HttpStatus.NOT_FOUND);
            } else {
                Account account = accountOpt.get();
                accountList.add(account);
            }
        }
        return accountList;
    }

    public Chat create(ChatDTO requestDTO) {
        List<Account> accountList = this.makeAcctList(requestDTO.accountList);
        //for each requestdto. id, find account add to list account
//        List<Account> accountList = new ArrayList<>();
//        for (Long id: requestDTO.accountList)
//        {
//            Optional<Account> accountOpt = this.accountRepository.findById(id);
//            if(accountOpt.isEmpty()){
//                throw new ResponseStatusException(HttpStatus.NOT_FOUND);
//            } else {
//                Account account = accountOpt.get();
//                accountList.add(account);
//            }
//        }
        Chat newChat = new Chat(requestDTO, accountList);
        System.out.println(newChat);
        //todo create chat in db ... id is null...
      //  return this.repository.save(newChat);
        return repository.save(newChat);
    }


    //TODO can we just use this
//    public Chat getChat(ChatDTO requestDTO) {
//        //find chat by
//
//        List<Account> accountList = this.makeAcctList(requestDTO.accountList);
//        Optional<Chat> chatOpt = this.repository.findChatByAccountList(accountList);
//        if(chatOpt.isEmpty()) {
//            return create(requestDTO);
//        } else {
//            Chat chat = chatOpt.get();
//            return chat;
//        }
//    }
}
