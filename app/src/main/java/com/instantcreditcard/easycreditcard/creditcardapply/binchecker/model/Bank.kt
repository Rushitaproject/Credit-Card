package com.instantcreditcard.easycreditcard.creditcardapply.binchecker.model

import androidx.annotation.Keep

@Keep
class Bank {
   var name: String?= null
   var phone: String?= null
   var url: String?= null
    override fun toString(): String {
        return "ClassPojo [phone = $phone, name = $name, url = $url]"
    }
}