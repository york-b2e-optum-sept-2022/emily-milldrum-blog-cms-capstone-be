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

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Account> membersList;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Message> messageList;
}
