package com.espezzialy.bankapi.repository

import com.espezzialy.bankapi.model.Account
import org.springframework.data.jpa.repository.JpaRepository

interface AccountRepository : JpaRepository<Account, Long> {

}