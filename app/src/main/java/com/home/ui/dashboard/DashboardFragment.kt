package com.home.ui.dashboard

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.home.R
import com.home.data.repo.ClassroomRepo
import com.home.data.repo.FakeClassroomRepo
import com.home.data.repo.FakeHomeworkRepo
import com.home.data.repo.HomeworkRepo
import com.home.databinding.FragmentDashboardBinding

class DashboardFragment : Fragment(R.layout.fragment_dashboard) {

    private val binding: FragmentDashboardBinding by viewBinding()
    private val repoClasses:ClassroomRepo = FakeClassroomRepo ()
    private val repoHomework:HomeworkRepo = FakeHomeworkRepo()

    private val classroomAdapter: ClassroomAdapter by lazy {
        ClassroomAdapter(
            onCLick = { classroom ->
                Toast.makeText(requireContext(), "CLICK", Toast.LENGTH_SHORT).show()
            }
        )
    }

    private val homeworkAdapter: HomeworkAdapter by lazy {
        HomeworkAdapter(
            onCLick = {homework ->
                Toast.makeText(requireContext(),"CLIK",Toast.LENGTH_SHORT).show()
            }
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initClassesAdapter()
        initHomeworkAdapter()

    }

    private fun initHomeworkAdapter() {
        binding.rvHomework.adapter = this@DashboardFragment.homeworkAdapter
        binding.rvHomework.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false)
        homeworkAdapter.submitList(repoHomework.getClassroom())
    }

    private fun initClassesAdapter() {
        binding.rvClasses.adapter =this@DashboardFragment.classroomAdapter
        binding.rvClasses.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false)
        classroomAdapter.submitList(repoClasses.getClassroom())
    }

}