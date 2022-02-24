package com.geekbrains.spring.web.cart.integrations;

import com.geekbrains.spring.web.api.core.ProductDto;
import com.geekbrains.spring.web.api.exceptions.ResourceNotFoundException;
import com.geekbrains.spring.web.api.exceptions.ServiceUnavailableException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Optional;

@Component
public class ProductsServiceIntegration {

    private final WebClient webClient;

    public ProductsServiceIntegration(@Qualifier("coreServiceWebClient") WebClient webClient) {
        this.webClient = webClient;
    }

    public ProductDto findById(Long id) {
        return webClient.get()
                .uri("/api/v1/products/"+ id)
                .retrieve()
                .onStatus(status -> status.value() == HttpStatus.NOT_FOUND.value(),
                        response -> Mono.error(new ResourceNotFoundException("Невозможно добавить продукт в корзину. Продукт не найден, id: " + id)))
                .onStatus(status -> status.value() == HttpStatus.INTERNAL_SERVER_ERROR.value(),
                        response -> Mono.error(new ServiceUnavailableException("Невозможно добавить продукт в корзину. Продуктовый сервис недоступен")))
                .bodyToMono(ProductDto.class)
                .block();
    }
}
