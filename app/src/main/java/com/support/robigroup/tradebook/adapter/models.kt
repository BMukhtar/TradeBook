package com.support.robigroup.tradebook.adapter

data class Tovar(
        var image: Int,
        var name: String,
        var skidka: String,
        var price: Int,
        var count: Int = 1
)