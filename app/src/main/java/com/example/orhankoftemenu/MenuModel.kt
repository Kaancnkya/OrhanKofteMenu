package com.example.orhankoftemenu

sealed class MenuModel {

    data class MenuHeader(
        val header : String
    ) : MenuModel()

    data class ItemMenu(
        val menuName : String,
        val menuDesc :String,
        val amount  :String,
        val imageView:Int
    ) : MenuModel()
}

