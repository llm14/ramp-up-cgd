package cgd.rampupcgd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/accounts")
public class AccountsController {

    @Autowired
    private AccountsRepository accountsRepository;

    @GetMapping
    public List<Account> allAccounts() {
        return accountsRepository.findAll();
    }

    @GetMapping("/{id}")
    public Account getAccountById(@PathVariable Long id) {
        return accountsRepository.findById(id).get();
    }

    @PostMapping
    public Account addAccount(@RequestBody Account account) {
        return accountsRepository.save(account);
    }

    @PutMapping("/{id}")
    public Account updateAccount(@PathVariable Long id, @RequestBody Account updateAccount) throws AccountNotFoundException {
        Optional<Account> account = accountsRepository.findById(id);
        if (account.isPresent()) {
            account.get().setOwner(updateAccount.getOwner());
            account.get().setBalance(updateAccount.getBalance());
            return accountsRepository.save(account.get());
        } else
            throw new AccountNotFoundException("Account " + id + " does not exist");
    }

    @DeleteMapping("/{id}")
    public void deleteAccount(@PathVariable Long id) {
        accountsRepository.deleteById(id);
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(AccountNotFoundException.class)
    public Map<String, String> handleAccountNotFoundException(AccountNotFoundException exception) {
        Map<String, String> map =  new HashMap<>();
        map.put("errorMessage", exception.getMessage());
        return map;
    }
}
