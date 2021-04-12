package id.husni.fakejsonapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import id.husni.fakejsonapp.R
import id.husni.fakejsonapp.databinding.ItemListBinding
import id.husni.fakejsonapp.model.Users

class UserAdapter : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {
    private val listData = ArrayList<Users>()
    fun setUserData(items: List<Users>) {
        if (items.isNullOrEmpty()) return
        listData.clear()
        listData.addAll(items)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserAdapter.UserViewHolder {
        val view = ItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return UserViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserAdapter.UserViewHolder, position: Int) {
        holder.bind(listData[position])
    }

    override fun getItemCount(): Int = listData.size

    class UserViewHolder(private val binding: ItemListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(users: Users) {
            with(binding) {
                tvName.text = itemView.context.getString(R.string.name, users.name)
                tvEmail.text = itemView.context.getString(R.string.email, users.email)
                tvWebsite.text = itemView.context.getString(R.string.website, users.website)
            }
            binding.root.setOnClickListener {
                Toast.makeText(itemView.context, users.name, Toast.LENGTH_SHORT).show()
            }
        }

    }
}