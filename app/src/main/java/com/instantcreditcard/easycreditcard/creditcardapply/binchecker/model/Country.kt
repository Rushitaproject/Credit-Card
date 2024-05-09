package com.instantcreditcard.easycreditcard.creditcardapply.binchecker.model

import androidx.annotation.Keep

@Keep
class Country {
   var alpha2: String?= null
   var currency: String?= null
   var emoji: String?= null
   var latitude: String?= null
   var longitude: String?= null
   var name: String?= null
   var numeric: String?= null
    override fun toString(): String {
        return "ClassPojo [emoji = $emoji, latitude = $latitude, alpha2 = $alpha2, name = $name, numeric = $numeric, currency = $currency, longitude = $longitude]"
    }
}