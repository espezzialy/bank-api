package com.espezzialy.bankapi.model

import javax.persistence.*


@Entity
    data class Account(
    @Id
    @GeneratedValue
    var id: Long? = null,
    @Column(name = "name")
    val name: String,
    @Column(name = "document")
    val document: String,
    @Column(name = "phone")
    val phone: String
)