package com.example.springbootpractice.factorypattern

import org.springframework.stereotype.Service

@Service
class ApproveVirtualAccountClass : MainUseCase<ApproveParam>, MainClass() {
    override val rule: MainUseCase.Rule
        get() = MainUseCase.Rule.APPROVE_VIRTUAL_ACCOUNT

    override fun create(param: ApproveParam) {
        println("CREATE")
        approveVirtualAccount(param)
    }

    override fun approveVirtualAccount(param: ApproveParam) {
        println("가상계좌 승인전표 생성")
    }

    override fun partialCancel(param: CancelParam) {
        // 구현
    }
}
