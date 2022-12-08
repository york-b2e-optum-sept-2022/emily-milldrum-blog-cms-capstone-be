package net.yorksolutions.emilymilldrumblogcmscapstonebe.Chat;

import net.yorksolutions.emilymilldrumblogcmscapstonebe.Account.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ChatRepository extends CrudRepository<Chat, Long> {

   // Optional<Chat> findByAccountListContaining(Account account, Account account2);
    //findByAccountList(List<Account> accountList);
}
