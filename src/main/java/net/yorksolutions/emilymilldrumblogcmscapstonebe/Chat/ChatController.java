package net.yorksolutions.emilymilldrumblogcmscapstonebe.Chat;
import net.yorksolutions.emilymilldrumblogcmscapstonebe.Account.Account;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/chat")
@CrossOrigin
public class ChatController {

    ChatService service;

    public ChatController(ChatService chatService){
        this.service = chatService;
    }

    @PostMapping
    public Chat create(@RequestBody ChatDTO requestDTO){
        return this.service.create(requestDTO);
    }
//
//    @GetMapping("/getChat/")
//    public Chat getChat(@RequestBody ChatDTO requestDTO){
//        return this.service.getChat(requestDTO);
//    }

}
