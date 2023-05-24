package cgd.rampupcgd.exceptions;

import lombok.Data;
import lombok.ToString;
import org.zalando.problem.AbstractThrowableProblem;
import org.zalando.problem.StatusType;

import java.net.URI;

@Data
@ToString(callSuper = true)
public abstract class AbstractCustomThrowableProblem extends AbstractThrowableProblem {

  AbstractCustomThrowableProblem(URI uriType, String message, StatusType statusType) {
    super(uriType, message, statusType);
  }
}
