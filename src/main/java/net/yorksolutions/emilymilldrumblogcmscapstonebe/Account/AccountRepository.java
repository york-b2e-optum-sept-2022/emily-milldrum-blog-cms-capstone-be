package net.yorksolutions.emilymilldrumblogcmscapstonebe.Account;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends CrudRepository<Account, Long> {
}
