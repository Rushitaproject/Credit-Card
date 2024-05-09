package com.instantcreditcard.easycreditcard.creditcardapply.binchecker.model

import androidx.annotation.Keep

@Keep
class Number {
   var length: String?= null
   var luhn: String?= null
    override fun toString(): String {
        return "ClassPojo [length = $length, luhn = $luhn]"
    }
}