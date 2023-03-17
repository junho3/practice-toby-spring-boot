package com.example.springbootpractice.factorypattern

import java.time.LocalDateTime

data class ApproveParam(
    override val paymentNo: String,
    val transactionAt: LocalDateTime,
) : MainParam(paymentNo)
