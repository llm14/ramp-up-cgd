package cgd.rampupcgd.exceptions;

import java.net.URI;
import org.zalando.problem.Status;


public class AccountNotFoundException extends AbstractCustomThrowableProblem {

    private static final URI TYPE = URI.create("testURI");

    public AccountNotFoundException(Long id) {
        super(TYPE,
            "Account " + id + " not found",
            Status.NOT_FOUND);
    }


}
