package com.example.springbootpractice.factorypattern

import io.kotest.core.spec.style.DescribeSpec
import java.time.LocalDateTime

class RunClassTest(
    private val approveKakaoPayClass: ApproveKakaoPayClass = ApproveKakaoPayClass(),
    private val approveVirtualAccountClass: ApproveVirtualAccountClass = ApproveVirtualAccountClass(),
    private val cancelClass: CancelClass = CancelClass(),
    private val factory: MainUseCaseFactory = MainUseCaseFactory(
        listOf(
            approveKakaoPayClass,
            approveVirtualAccountClass,
            cancelClass,
    //            ApproveClass<ApproveParam>(),
    //            CancelClass<CancelParam>(),
        ) as List<MainUseCase<Any>>,
    ),
) : DescribeSpec({

    describe("runApprove") {
        context("카카오페이인 경우") {
            it("결제승인전표 생성") {
                factory.getUseCase("APPROVE_KAKAOPAY").create(ApproveParam("", LocalDateTime.now()))
            }
        }

        context("가상계좌인 경우") {
            it("가상계좌전표 생성") {
                factory.getUseCase("APPROVE_VIRTUAL_ACCOUNT").create(ApproveParam("", LocalDateTime.now()))
            }
        }
    }

    describe("runCancel") {
        context("cc") {
            it("cc1") {
                factory.getUseCase("CANCEL_KAKAOPAY").create(CancelParam("", 1000))
            }
        }
    }
})
