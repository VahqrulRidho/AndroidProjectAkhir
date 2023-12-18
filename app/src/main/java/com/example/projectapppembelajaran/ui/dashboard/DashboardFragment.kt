package com.example.projectapppembelajaran.ui.dashboard

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.projectapppembelajaran.DetailModulActivity
import com.example.projectapppembelajaran.R
import com.example.projectapppembelajaran.databinding.FragmentDashboardBinding

class DashboardFragment : Fragment() {

    private var _binding: FragmentDashboardBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val dashboardViewModel =
            ViewModelProvider(this).get(DashboardViewModel::class.java)

        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        val root: View = binding.root

//        val textView: TextView = binding.textDashboard
        dashboardViewModel.text.observe(viewLifecycleOwner) {
//            textView.text = it
        }

        val cardViewModul1: CardView = root.findViewById(R.id.cardViewModul1)
        val cardViewModul2: CardView = root.findViewById(R.id.cardViewModul2)
        val cardViewModul3: CardView = root.findViewById(R.id.cardViewModul3)
        val cardViewModul4: CardView = root.findViewById(R.id.cardViewModul4)
        val cardViewModul5: CardView = root.findViewById(R.id.cardViewModul5)


        cardViewModul1.setOnClickListener{
            val intent = Intent(context, DetailModulActivity::class.java)
            startActivity(intent)
        }
        cardViewModul2.setOnClickListener{
            val intent = Intent(context, DetailModulActivity::class.java)
            startActivity(intent)
        }
        cardViewModul3.setOnClickListener{
            val intent = Intent(context, DetailModulActivity::class.java)
            startActivity(intent)
        }
        cardViewModul4.setOnClickListener{
            val intent = Intent(context, DetailModulActivity::class.java)
            startActivity(intent)
        }
        cardViewModul5.setOnClickListener{
            val intent = Intent(context, DetailModulActivity::class.java)
            startActivity(intent)
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}