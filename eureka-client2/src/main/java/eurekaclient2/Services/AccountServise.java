package eurekaclient2.Services;

import eurekaclient2.Entity.Account;

import java.util.List;

public interface AccountServise {
    public List<Account> findAccountByNameAndPassword(String name, String password);
    public List<Account> findAll();

    void save(Account account);
    Account findAccountByName(String name);
}
