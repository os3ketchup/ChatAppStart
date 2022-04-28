package uz.os3ketchup.chatappstart.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import uz.os3ketchup.chatappstart.databinding.ItemFromBinding
import uz.os3ketchup.chatappstart.databinding.ItemToBinding
import uz.os3ketchup.chatappstart.models.Message

class MessageAdapter(var list: List<Message>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    inner class FromVH(var itemFromBinding: ItemFromBinding) :
        RecyclerView.ViewHolder(itemFromBinding.root) {
        fun onBind(message: Message) {
            itemFromBinding.tvItemFrom.text = message.text
        }
    }

    inner class ToVH(var itemToBinding: ItemToBinding) :
        RecyclerView.ViewHolder(itemToBinding.root) {
        fun onBind(message: Message) {
            itemToBinding.tvItemTo.text = message.text
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == 1) {
            FromVH(ItemFromBinding.inflate(LayoutInflater.from(parent.context), parent, false))
        } else {
            ToVH(ItemToBinding.inflate(LayoutInflater.from(parent.context), parent, false))
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (getItemViewType(position) == 1) {
            val fromVH = holder as FromVH
            fromVH.onBind(list[position])
        } else {
            (holder as ToVH).onBind(list[position])
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun getItemViewType(position: Int): Int {
        if (list[position].fromUID == "1") {
            return 1
        } else {
            return 2
        }

    }
}