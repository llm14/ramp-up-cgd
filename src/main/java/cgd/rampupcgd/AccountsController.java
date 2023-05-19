package cgd.rampupcgd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/accounts")
public class AccountsController {

  @Autowired

  private AccountService accountService;

  @GetMapping
  public List<Account> allAccounts() {
    return accountService.allAccounts();
  }

  @GetMapping("/{id}")
  public Account getAccountById(@PathVariable Long id) {
    return accountService.getAccountById(id);
  }

  @PostMapping
  public Account addAccount(@RequestBody Account account) {
    return accountService.addAccount(account);
  }

  @PutMapping("/{id}")
  public Account updateAccount(@PathVariable Long id, @RequestBody Account updateAccount) throws AccountNotFoundException {
    return accountService.updateAccount(id, updateAccount);
  }

  @DeleteMapping("/{id}")
  public void deleteAccount(@PathVariable Long id) {
    accountService.deletedAccount(id);
  }


}
