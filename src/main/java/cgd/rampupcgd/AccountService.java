package cgd.rampupcgd;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AccountService {

  private final AccountsRepository accountsRepository;

  public List<Account> allAccounts(){
    return accountsRepository.findAll();
  }

  public Account getAccountById(Long id){
    return accountsRepository.findById(id).get();
  }

  public Account addAccount (Account account){
    return accountsRepository.save(account);
  }

  public Account updateAccount (Long id, Account updateAccount) throws AccountNotFoundException{

    Optional<Account> account = accountsRepository.findById(id);
    if (account.isPresent()) {
      account.get().setOwner(updateAccount.getOwner());
      account.get().setBalance(updateAccount.getBalance());
      return accountsRepository.save(account.get());
    } else
      throw new AccountNotFoundException("Account " + id + " does not exist");
  }

  public void deletedAccount(Long id){
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
