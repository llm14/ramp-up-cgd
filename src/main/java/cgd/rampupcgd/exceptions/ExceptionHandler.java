package cgd.rampupcgd.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.NativeWebRequest;
import org.zalando.problem.Problem;
import org.zalando.problem.ThrowableProblem;
import org.zalando.problem.spring.web.advice.ProblemHandling;

@ControllerAdvice
public class ExceptionHandler implements ProblemHandling {

  @Override
  public ResponseEntity<Problem> handleThrowable(final Throwable throwable, final NativeWebRequest request) {
    return this.create(throwable, request);
  }

  @Override
  public ResponseEntity<Problem> handleProblem(final ThrowableProblem problem, final NativeWebRequest request) {

    return this.create(problem, request);
  }
}
