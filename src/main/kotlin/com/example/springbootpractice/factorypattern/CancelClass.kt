package com.example.springbootpractice.factorypattern

import org.springframework.stereotype.Service

@Service
class CancelClass : MainUseCase<CancelParam>, MainClass() {
    override val rule: MainUseCase.Rule
        get() = MainUseCase.Rule.CANCEL_KAKAOPAY

    override fun create(param: CancelParam) {
        println("CREATE")
        cancel(param)
    }

    override fun cancel(param: CancelParam) {
        println("취소전표생성")
    }
}
