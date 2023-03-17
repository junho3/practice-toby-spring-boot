package com.example.springbootpractice.factorypattern

import org.springframework.stereotype.Service

@Service
class ApproveKakaoPayClass : MainUseCase<ApproveParam>, MainClass() {
    override val rule: MainUseCase.Rule
        get() = MainUseCase.Rule.APPROVE_KAKAOPAY

    override fun create(param: ApproveParam) {
        println("CREATE")
        approveKakaoPay(param)
    }

    override fun approveKakaoPay(param: ApproveParam) {
        println("카카오페이 승인전표 생성")
        // 구현
    }
}
