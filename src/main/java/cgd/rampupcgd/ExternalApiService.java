package cgd.rampupcgd;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;


@FeignClient(name = "external-api-service", url = "https://dummyjson.com/")
public interface ExternalApiService {

  @GetMapping(value = "carts",  consumes = "applicaiton/json")
  AccountDto getJsonFromExternalApi();
}
