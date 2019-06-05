package eurekaclient2.Services;

import eurekaclient2.Entity.Account;
import eurekaclient2.Entity.Role;
import eurekaclient2.Repo.AccountRepository;
import eurekaclient2.Repo.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
}
