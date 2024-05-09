package com.instantcreditcard.easycreditcard.creditcardapply.binchecker.model

import androidx.annotation.Keep

@Keep
class BinList {
    var bank: Bank?= null
   var brand: String?= null
   var country: Country?= null
   var number: Number?= null
   var prepaid: String?= null
   var scheme: String?= null
   var type: String?= null
    override fun toString(): String {
        return "ClassPojo [number = $number, country = $country, bank = $bank, scheme = $scheme, prepaid = $prepaid, type = $type, brand = $brand]"
    }
}