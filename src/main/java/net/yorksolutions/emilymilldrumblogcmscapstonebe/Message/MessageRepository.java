package net.yorksolutions.emilymilldrumblogcmscapstonebe.Message;

import net.yorksolutions.emilymilldrumblogcmscapstonebe.Account.Account;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends CrudRepository<Message, Long> {

    Iterable<Message> findAllBySenderAndReceiver (Account sender, Account receiver);
}
