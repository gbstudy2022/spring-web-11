package com.geekbrains.spring.web.core.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

@ConstructorBinding
@ConfigurationProperties(prefix = "integrations.cart-service.timeouts")
@Data
public class CartServiceTimeoutProperties {
    private Integer connection;
    private Integer read;
    private Integer write;
}
