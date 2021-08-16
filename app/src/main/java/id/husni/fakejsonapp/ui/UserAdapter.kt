package id.husni.fakejsonapp.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import id.husni.fakejsonapp.R
import id.husni.fakejsonapp.databinding.ItemListBinding
import id.husni.fakejsonapp.data.model.Users

class UserAdapter : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {
    private val oldUser = ArrayList<Users>()
    fun setUserData(newUser: List<Users>) {
        val diffUtilCallback = DiffUtilUser(oldUser,newUser)
        val diffCalculate = DiffUtil.calculateDiff(diffUtilCallback)
        oldUser.clear()
        oldUser.addAll(newUser)
        diffCalculate.dispatchUpdatesTo(this)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserAdapter.UserViewHolder {
        val view = ItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return UserViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserAdapter.UserViewHolder, position: Int) {
        holder.bind(oldUser[position])
    }

    override fun getItemCount(): Int = oldUser.size

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