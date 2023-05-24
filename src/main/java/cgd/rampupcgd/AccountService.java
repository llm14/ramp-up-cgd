package cgd.rampupcgd;

import cgd.rampupcgd.exceptions.AccountNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AccountService {

  @Autowired
  private AccountsRepository accountsRepository;

  private ExternalApiService externalApiService;

  public List<AccountDto> allAccounts() {
    return AccountDtoMapper.INSTANCE.toAccountDtoList(accountsRepository.findAll());
  }

  public AccountDto getAccountById(Long id) {
    Optional<Account> accountOptional = accountsRepository.findById(id);
    if (accountOptional.isPresent()) {
      Account account = accountOptional.get();
      return AccountDtoMapper.INSTANCE.toAccountDto(account);
    } else
      throw new IllegalArgumentException("This account does not exist");
  }

  public AccountDto addAccount(Account account) {
    return AccountDtoMapper.INSTANCE.toAccountDto(accountsRepository.save(account));
  }

  public AccountDto updateAccount(Long id, Account updateAccount) throws AccountNotFoundException {
      Account account = accountsRepository.findById(id)
          .orElseThrow(() -> new AccountNotFoundException(id));

      account.setOwner(updateAccount.getOwner());
      account.setBalance(updateAccount.getBalance());
      return AccountDtoMapper.INSTANCE.toAccountDto(account);
  }

  public void deletedAccount(Long id) {
    accountsRepository.deleteById(id);

  }

  public AccountDto getThings() {
    return externalApiService.getJsonFromExternalApi();
  }

}
