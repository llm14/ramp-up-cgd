package cgd.rampupcgd;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;


@FeignClient(name = "external-api-service", url = "https://jsonplaceholder.typicode.com/todos")
public interface ExternalApiService {

    @GetMapping(value = "/1")
    ExternalRandomObject getJsonFromExternalApi();
}
