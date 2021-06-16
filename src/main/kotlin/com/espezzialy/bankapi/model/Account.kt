package com.espezzialy.bankapi.model

import javax.persistence.*


@Entity
@Table(name = "accounts")
data class Account(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,
    @Column(name = "name")
    val name: String,
    @Column(name = "document")
    val document: String,
    @Column(name = "phone")
    val phone: String
)