package com.example.springbootpractice.factorypattern

import com.example.springbootpractice.factorypattern.ApproveParam
import com.example.springbootpractice.factorypattern.CancelParam

abstract class MainClass {
    open fun approveKakaoPay(param: ApproveParam) {}
    open fun approveVirtualAccount(param: ApproveParam) {}
    open fun cancel(param: CancelParam) {}
    open fun partialCancel(param: CancelParam) {}
    open fun receipt(param: Boolean) {}
}
