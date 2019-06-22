package eurekaclient2.Services;

import eurekaclient2.Entity.Account;
import eurekaclient2.Entity.Role;
import eurekaclient2.Repo.AccountRepository;
import eurekaclient2.Repo.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AccountServiseImpl implements AccountServise {
    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private RoleRepository roleRepository;


    public List<Account> findAccountByNameAndPassword(String name, String password){
        return accountRepository.findAccountByNameAndPassword(name,password);
    }

    @Override
    public void save(Account account) {
        Set<Role> roles = new HashSet<>();
        roles.add(roleRepository.findOne(Integer.valueOf(1)));
        account.setRoles(roles);
        accountRepository.save(account);
    }

    @Override
    public Account findAccountByName(String name) {
        return accountRepository.findAccountByName(name);
    }

    @Override
    public List<Account> findAll() {
        List<Account> result = new LinkedList<>();
        accountRepository.findAll().forEach(result::add);
        return result;
    }
}
