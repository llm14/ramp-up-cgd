package cgd.rampupcgd;

import cgd.rampupcgd.exceptions.AccountNotFoundException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
@RequiredArgsConstructor
public class AccountsController {

  @Autowired
  private AccountService accountService;

  @GetMapping
  public ResponseEntity<List<AccountDto>> allAccounts() {
    return new ResponseEntity<>(accountService.allAccounts(), HttpStatus.OK);
  }

  @GetMapping("/{id}")
  public ResponseEntity<AccountDto> getAccountById(@PathVariable Long id) {
    AccountDto accountDto = accountService.getAccountById(id);
    return new ResponseEntity<>(accountDto, HttpStatus.OK);
  }

  @PostMapping
  public ResponseEntity<AccountDto> addAccount(@RequestBody AccountDto accountDto) {
    return new ResponseEntity<>(accountService.addAccount(accountDto), HttpStatus.CREATED);
  }

  @PutMapping("/{id}")
  @Operation(summary = "Update Account and test summary", responses = {
      @ApiResponse(responseCode = "200", description = "Account exists and is successfully updated",
          content = @Content(mediaType = "application/json",
              array = @ArraySchema(
                  schema = @Schema(implementation = Account.class)))),
      @ApiResponse(responseCode = "500", description = "test description on exception",
          content = @Content(mediaType = "application/json",
              array = @ArraySchema(
                  schema = @Schema(implementation = AccountNotFoundException.class))))
  })
  public ResponseEntity<AccountDto> updateAccount(@PathVariable Long id, @RequestBody AccountDto updateAccountDto) {
    return new ResponseEntity<>(accountService.updateAccount(id, updateAccountDto), HttpStatus.OK);
  }

  @DeleteMapping("/{id}")
  public void deleteAccount(@PathVariable Long id) {
    accountService.deletedAccount(id);
  }

  @GetMapping("/external")
  public ExternalRandomObject getRandomThingFromApi(){
    return accountService.getThings();
  }

}
