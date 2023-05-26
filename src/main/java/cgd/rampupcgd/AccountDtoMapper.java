package cgd.rampupcgd;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface AccountDtoMapper {

  AccountDtoMapper INSTANCE = Mappers.getMapper(AccountDtoMapper.class);

  AccountDto toAccountDto(Account account);

  List<AccountDto> toAccountDtoList (List<Account> accountList);

  Account toAccount(AccountDto accountDto);

}
