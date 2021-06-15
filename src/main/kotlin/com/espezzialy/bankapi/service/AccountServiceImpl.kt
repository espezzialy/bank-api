package com.espezzialy.bankapi.service

import com.espezzialy.bankapi.model.Account
import com.espezzialy.bankapi.repository.AccountRepository
import org.springframework.stereotype.Service
import org.springframework.util.Assert
import java.lang.RuntimeException
import java.util.*

@Service
class AccountServiceImpl(private val repository: AccountRepository) : AccountService {
    override fun create(account: Account): Account {
        Assert.hasLength(account.name, "Name can not be empty")
        Assert.isTrue(account.name.length >= 5 , "Name should have at least 5 character")

        Assert.hasLength(account.document, "Document can not be empty")
        Assert.isTrue(account.document.length >= 11 , "Document should have at least 11 character")

        Assert.hasLength(account.phone, "Phone can not be empty")
        Assert.isTrue(account.phone.length >= 8 , "Phone should have at least 8 character")

        return repository.save(account)
    }

    override fun getAll(): List<Account> {
        return repository.findAll()
    }

    override fun getById(id: Long): Optional<Account> {
        return repository.findById(id)

    }

    override fun update(id: Long, account: Account): Optional<Account> {
        val optional = getById(id)
        if (optional.isEmpty) {
            return optional
        }

        return optional.map {
            val accountToUpdate = it.copy(
                name = account.name,
                document = account.document,
                phone = account.phone
            )
            repository.save(accountToUpdate)
        }
    }

    override fun delete(id: Long) {
        repository.findById(id).map {
            repository.delete(it)
        }.orElseThrow { throw RuntimeException("Id: $id not found") }
    }

}