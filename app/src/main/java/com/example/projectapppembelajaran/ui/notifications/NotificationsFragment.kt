package com.example.projectapppembelajaran.ui.notifications

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.projectapppembelajaran.LoginActivity
import com.example.projectapppembelajaran.R
import com.example.projectapppembelajaran.databinding.FragmentNotificationsBinding

class NotificationsFragment : Fragment(), View.OnClickListener {

    private var _binding: FragmentNotificationsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val notificationsViewModel =
            ViewModelProvider(this).get(NotificationsViewModel::class.java)

        _binding = FragmentNotificationsBinding.inflate(inflater, container, false)
        val root: View = binding.root

        // Find your button by ID
        val btn: Button = root.findViewById(R.id.btn_logout)

        // Set OnClickListener for the button
        btn.setOnClickListener(this)



//        val textView: TextView = binding.textNotifications
        notificationsViewModel.text.observe(viewLifecycleOwner) {
//            textView.text = it
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.btn_logout -> {
                val intent = Intent(requireContext(), LoginActivity::class.java)
                // Start the LoginActivity
                startActivity(intent)
                // Finish the current Activity (optional, depends on your navigation flow)
                activity?.finish()
            }
        }
    }
}