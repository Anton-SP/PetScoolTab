package com.home.ui.dashboard

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.home.data.Classroom
import com.home.databinding.ItemClassBinding

class ClassroomAdapter(
    private val onCLick: (Classroom) -> Unit
) : RecyclerView.Adapter<ClassroomAdapter.ClassroomViewHolder>() {

    private val rooms = ArrayList<Classroom>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClassroomViewHolder {
        val binding = ItemClassBinding.inflate(
            LayoutInflater.from(parent.context),parent,false
        )
        val holder = ClassroomViewHolder(
            binding = binding,
            onCLick = onCLick
        )
        return  holder
    }

    override fun getItemCount(): Int {
        return rooms.size
    }

    override fun onBindViewHolder(holder: ClassroomViewHolder, position: Int) {
        holder.bind(classroom = rooms[position])
    }

    fun submitList(classroom: List<Classroom>) {
        rooms.clear()
        rooms.addAll(classroom)
        notifyDataSetChanged()
    }


    inner class ClassroomViewHolder(
        private val binding: ItemClassBinding,
        private val onCLick: (Classroom) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(classroom:Classroom) {
            with(binding) {
                tvClassName.text = classroom.name
                tvClassTeacherName.text = classroom.teacher
            }

        }



    }


}