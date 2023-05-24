package cgd.rampupcgd;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AccountDto {

  String owner;
  Long balance;

}
