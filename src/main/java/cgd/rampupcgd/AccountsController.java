package cgd.rampupcgd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/accounts")
public class AccountsController {

    @Autowired
    private AccountsRepository accountsRepository;

    @GetMapping
    public List<Account> allAccounts(){
        return  accountsRepository.findAll();
    }

    @PostMapping
    public Account addAccount(@RequestBody Account account){
        return accountsRepository.save(account);
    }
}
