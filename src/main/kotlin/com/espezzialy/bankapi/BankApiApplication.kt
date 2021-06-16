package com.espezzialy.bankapi

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaAuditing

@SpringBootApplication
@EnableJpaAuditing
class BankApiApplication

fun main(args: Array<String>) {
	runApplication<BankApiApplication>(*args)
}
