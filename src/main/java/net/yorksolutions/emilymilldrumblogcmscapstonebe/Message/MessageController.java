package net.yorksolutions.emilymilldrumblogcmscapstonebe.Message;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/msg")
@CrossOrigin
public class MessageController {

    MessageService service;

    public MessageController(MessageService messageService) {
        this.service = messageService;
    }

    @PostMapping
    public Message add(@RequestBody NewMessageDTO requestDTO) {
        return this.service.add(requestDTO);
    }

    //
//    @GetMapping("/getChat/")
//    public Chat getChat(@RequestBody ChatDTO requestDTO){
//        return this.service.getChat(requestDTO);
//    }
    @GetMapping
    List<Message> get(@RequestParam Long sender, @RequestParam Long receiver) {
        return this.service.getAll(sender, receiver);
    }
}
