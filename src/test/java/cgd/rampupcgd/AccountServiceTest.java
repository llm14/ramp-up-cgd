package cgd.rampupcgd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.doReturn;

class AccountServiceTest {
  private static final Account
      ACCOUNT = new Account(1L, "Luis", 1000L);
  private static final AccountDto
      ACCOUNT_DTO = new AccountDto("Luis", 1000L);
  private static final List<Account>
      ACCOUNT_LIST = new ArrayList<>();

  private static final List<AccountDto>
      ACCOUNT_DTO_LIST = new ArrayList<>();
  @InjectMocks
  private AccountService accountService;

  @BeforeEach
  public void setup() {
    MockitoAnnotations.initMocks(this);
    ACCOUNT_LIST.add(ACCOUNT);
    ACCOUNT_DTO_LIST.add(ACCOUNT_DTO);
  }

  @Mock
  private AccountsRepository accountsRepository;

  @Test
  void allAccounts() {
    doReturn(ACCOUNT_LIST).when(accountsRepository).findAll();

    List<AccountDto> expected = AccountDtoMapper.INSTANCE.toAccountDtoList(ACCOUNT_LIST);

    List<AccountDto> result = accountService.allAccounts();

    assertThat(expected).isEqualTo(result);

  }

  @Test
  void getAccountById() {
  }

  @Test
  void addAccount() {
  }

  @Test
  void updateAccount() {
  }

  @Test
  void deletedAccount() {
  }

  @Test
  void getThings() {
  }
}