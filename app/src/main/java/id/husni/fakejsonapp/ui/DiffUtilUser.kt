package id.husni.fakejsonapp.ui

import androidx.recyclerview.widget.DiffUtil
import id.husni.fakejsonapp.data.model.Users

class DiffUtilUser(private val oldUser: List<Users>, private val newUser: List<Users>): DiffUtil.Callback() {
    override fun getOldListSize(): Int = oldUser.size

    override fun getNewListSize(): Int = newUser.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldUser[oldItemPosition].id == newUser[newItemPosition].id
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldUser[oldItemPosition].id == newUser[newItemPosition].id
    }
}