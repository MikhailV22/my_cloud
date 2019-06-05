package eurekaclient2.Repo;


import eurekaclient2.Entity.Account;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AccountRepository extends CrudRepository<Account, Integer> {

    //    public Account findByLogin(String login,String password);
    List<Account> findAccountByPassword(String password);
    List<Account> findAccountByNameAndPassword(String name,String password);
    Account findAccountByName(String name);
}
