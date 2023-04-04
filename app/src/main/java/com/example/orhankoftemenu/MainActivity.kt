package com.example.orhankoftemenu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.LayoutManager

class MainActivity : AppCompatActivity() , MenuAdapter.MenuItemClickedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerViewMenus)
        val layout = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        val adapter = MenuAdapter(getMockData(),this)

        recyclerView.layoutManager = layout
        recyclerView.adapter = adapter
    }



    private fun getMockData() : List<MenuModel> = listOf(
        MenuModel.MenuHeader(header = "Ramazan Menüleri"),
        MenuModel.ItemMenu("İnegöl Köfte Menü", "(1 kişilik) Orhan Kofte, 1 Adet pacanga boregi, salata veya piyaz, mesrubat, sutlu tel kadayif veya kemal pasa tatlisi ile","330,00 TL",R.drawable.kofte_menu),
        MenuModel.ItemMenu("Döner Menü","(1 kisilik) et döner,pacanga boregi, salata veya piyaz,mesrubat, sutlu tel kadayif veya kemal pasa tatlisi ile", "375,00 TL", R.drawable.doner_meu),
        MenuModel.MenuHeader(header = "Ayın Menüsü"),
        MenuModel.ItemMenu("Piliç Menü","(1 kişilik)Piliç bonfile veya şiş, pacanga boregi, salata veya piyaz,mesrubat, sutlu tel kadayif veya kemal pasa tatlisi ile","330,00 TL", R.drawable.pilic_menu ),
        MenuModel.ItemMenu("Karışık Izgara Menü", "(1 parça bonfile 1 parca pirzola 3 adet inegöl köfte, pacanga boregi, salata veya piyaz,mesrubat, sutlu tel kadayif veya kemal pasa tatlisi ile","410,00 TL", R.drawable.karisik_izgara)
        )


    override fun onItemClickedListener(menuModel: MenuModel.ItemMenu) {
        Toast.makeText(this, "Siparişiniz oluşturuldu.",Toast.LENGTH_LONG).show()
    }
}