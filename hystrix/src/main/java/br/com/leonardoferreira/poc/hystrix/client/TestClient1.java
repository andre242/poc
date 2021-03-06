package br.com.leonardoferreira.poc.hystrix.client;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author s2it_leferreira
 * @since 25/06/18 17:09
 */
@FeignClient(name = "test-client-1", url = "https://api.github.com", fallback = TestClient1.ClientFallback.class)
public interface TestClient1 {

    @GetMapping("/users/{name}")
    String searchRepos(@PathVariable String name);

    @Component
    class ClientFallback implements TestClient1 {

        @Override
        public String searchRepos(String name) {
            return ":(";
        }
    }
}
