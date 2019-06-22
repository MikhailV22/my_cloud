package eurekaclient2.Controllers;


import eurekaclient2.Entity.Account;
import eurekaclient2.Services.AccountServise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Greeting {
    @Autowired
    private DiscoveryClient discoveryClient;
    private AccountServise accountServise;

    @Autowired
    public Greeting(AccountServise accountServise) {
        this.accountServise = accountServise;
    }

    @Value("${spring.application.name}")
    private String appName;

    @RequestMapping("/greeting")
    public String greeting() {
        appName = "a-bootiful-client";
        Account account;
        account = accountServise.findAccountByName("1");

        return String.format("Hello from  %s '%s'!",account.getEmail(), discoveryClient.getInstances(appName).get(0).getServiceId());
    }

    @RequestMapping("/test")
    public ResponseEntity<List<Account>> test() {
        List<Account> accounts = accountServise.findAll();
        System.out.println("accounts count:"+accounts.size());
//        String accountsCommaSeparated = accounts.stream()
//                .map(a->(a.getEmail()))
//                .collect(Collectors.joining(","));
        return ResponseEntity.ok().body(accounts);
    }

}
