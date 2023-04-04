package com.example.orhankoftemenu

import android.content.Context
import android.provider.ContactsContract.CommonDataKinds.Im
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MenuAdapter(private val menuList: List<MenuModel>,private val menuItemClicked: MenuItemClickedListener) :
    RecyclerView.Adapter<MenuAdapter.ViewHolder>() {

    val menuItemClickedListener: MenuItemClickedListener
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuAdapter.ViewHolder {
        val layout = when (viewType) {
            TYPE_HEADER -> R.layout.item_header_menu
            TYPE_ITEM_MENU -> R.layout.item_row
            else -> throw java.lang.IllegalArgumentException("Wrong view type")
        }
        return ViewHolder(LayoutInflater.from(parent.context).inflate(layout, parent, false))
    }

    override fun onBindViewHolder(holder: MenuAdapter.ViewHolder, position: Int) {
        holder.bind(menuList[position])

    }

    override fun getItemCount(): Int {
        return menuList.size
    }

    override fun getItemViewType(position: Int) = when (menuList[position]) {
        is MenuModel.MenuHeader -> TYPE_HEADER
        is MenuModel.ItemMenu -> TYPE_ITEM_MENU
    }

    init {
        this.menuItemClickedListener = menuItemClicked
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val menuName = itemView.findViewById<TextView>(R.id.textViewMenuTitle)
        private val menuDesc = itemView.findViewById<TextView>(R.id.textviewMenuDesc)
        private val amount = itemView.findViewById<TextView>(R.id.textViewAmount)
        private val menuImage = itemView.findViewById<ImageView>(R.id.imageViewProductImage)
        private val getTheOrder = itemView.findViewById<ImageView>(R.id.imageViewPlus)

        private val menuHeader = itemView.findViewById<TextView>(R.id.textViewHeader)

        fun bind(menuModel: MenuModel) {
            when (menuModel) {
                is MenuModel.MenuHeader -> {
                    menuHeader.text = menuModel.header
                }
                is MenuModel.ItemMenu -> {
                    menuName.text = menuModel.menuName
                    menuDesc.text = menuModel.menuDesc
                    amount.text = menuModel.amount
                    menuImage.setImageResource(menuModel.imageView)

                    getTheOrder.setOnClickListener {
                        menuItemClickedListener.onItemClickedListener(menuModel)
                    }

                }

            }
        }
    }

    companion object {
        private const val TYPE_HEADER = 0
        private const val TYPE_ITEM_MENU = 1
    }

    interface MenuItemClickedListener{
        fun onItemClickedListener(menuModel: MenuModel.ItemMenu)
    }

}