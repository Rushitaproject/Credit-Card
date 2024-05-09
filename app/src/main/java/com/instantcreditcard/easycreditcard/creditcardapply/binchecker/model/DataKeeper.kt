package com.instantcreditcard.easycreditcard.creditcardapply.binchecker.model


class DataKeeper {
    var appliedCredit = 0
    var autoLoans = 0
    var creditCards = 0
    var creditLimit = 0
    var firstOpenCredit = 0
    var lastNegativeItem = 0
    var mortgages = 0
    var otherLoans = 0
    var recentBalances = 0
    var retailFinances = 0
    val score = -1
        get() = if (field > 0) {
            field
        } else calculateScore()
    var studentLoans = 0

    private fun calculateScore(): Int {
        val i: Int
        i = if (lastNegativeItem == 0) {
            80
        } else {
            lastNegativeItem * 10
        }
        val creditCards2 =
            i + 590 + creditCards * 3 + mortgages - retailFinances + autoLoans * 1 - studentLoans * 2 - otherLoans - recentBalances / 70000 - appliedCredit * 5 + firstOpenCredit * 10
        if (creditCards2 > 800) {
            return 800
        }
        return if (creditCards2 < 500) {
            500
        } else creditCards2
    }

}