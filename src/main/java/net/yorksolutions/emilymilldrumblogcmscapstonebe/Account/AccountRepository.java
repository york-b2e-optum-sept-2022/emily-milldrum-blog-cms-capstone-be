package net.yorksolutions.emilymilldrumblogcmscapstonebe.Account;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends CrudRepository<Account, Long> {
    Optional<Account> findByEmailAndPassword(String email, String password);
}
