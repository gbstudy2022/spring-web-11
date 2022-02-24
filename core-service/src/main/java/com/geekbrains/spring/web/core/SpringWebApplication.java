package com.geekbrains.spring.web.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringWebApplication {
	// Домашнее задание:
	// 1. Покрыть код кор-сервиса и карт-сервиса доками сваггера

	// Ближайшие доработки:
	// . Поговорить про докер и подготовить docker-compose
	// . Добавить PayPal
	// . Categories (до след занятия)
	// . Фронт кнопки назад вперед в пагинации (до след занятия)
	// . Безопасность на уровне Gateway
	// . Посмотреть на Wiremock
	// . WebClient

	public static void main(String[] args) {
		SpringApplication.run(SpringWebApplication.class, args);
	}
}
