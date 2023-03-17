package com.example.springbootpractice.factorypattern

import com.example.springbootpractice.factorypattern.ApproveParam
import com.example.springbootpractice.factorypattern.CancelParam
import com.example.springbootpractice.factorypattern.MainUseCaseFactory
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class RunClass(
    private val factory: MainUseCaseFactory,
) {
    fun runApprove() {
        factory.getUseCase("APPROVE_KAKAOPAY").create(ApproveParam("", LocalDateTime.now()))
    }

    fun runCancel() {
        factory.getUseCase("CANCEL_KAKAOPAY").create(CancelParam("", 1000))
    }
}
