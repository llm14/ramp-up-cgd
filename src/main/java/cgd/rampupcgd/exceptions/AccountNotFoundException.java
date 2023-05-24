package cgd.rampupcgd.exceptions;

import org.zalando.problem.Status;

import java.net.URI;


public class AccountNotFoundException extends AbstractCustomThrowableProblem {

  private static final URI TYPE = URI.create("testURI");

  public AccountNotFoundException(Long id) {
    super(TYPE,
        "Account " + id + " not found",
        Status.NOT_FOUND);
  }


}
