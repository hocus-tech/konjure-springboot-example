package ai.hocus.examples.sprintboot.repository;

import ai.hocus.examples.sprintboot.model.Account;
import org.springframework.data.repository.CrudRepository;

public interface AccountRepository extends CrudRepository<Account, String> {}
