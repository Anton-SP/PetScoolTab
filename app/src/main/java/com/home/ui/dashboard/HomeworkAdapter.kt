package com.home.ui.dashboard

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.home.data.Classroom
import com.home.data.Homework
import com.home.databinding.ItemHomeworkBinding

class HomeworkAdapter(
    private val onCLick: (Homework) -> Unit
) : RecyclerView.Adapter<HomeworkAdapter.HomeworkViewHolder>() {

    private val homeworks = ArrayList<Homework>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeworkViewHolder {
        val binding = ItemHomeworkBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        val holder = HomeworkViewHolder(
            binding = binding,
            onCLick = onCLick
        )
        return holder
    }

    override fun getItemCount(): Int {
       return homeworks.size
    }

    override fun onBindViewHolder(holder: HomeworkViewHolder, position: Int) {
       holder.bind(homework = homeworks[position])
    }

    fun submitList(homework: List<Homework>) {
        homeworks.clear()
        homeworks.addAll(homework)
        notifyDataSetChanged()
    }


    inner class HomeworkViewHolder(
        private val binding: ItemHomeworkBinding,
        private val onCLick: (Homework) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(homework: Homework) {
            with(binding) {
                tvClassName.text = homework.name
                tvCountdown.text = homework.countdown
                tvHomeworkTask.text = homework.task
            }
        }
    }


}