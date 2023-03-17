package com.example.springbootpractice.factorypattern

data class CancelParam(
    override val paymentNo: String,
    val cancelAmount: Long,
) : MainParam(paymentNo)
