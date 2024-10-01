package com.bnp.movimento_produto_service.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories("com.bnp.movimento_produto_service.domain.repository")
public class DatabaseConfig {
}
