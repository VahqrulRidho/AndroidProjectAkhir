package com.example.projectapppembelajaran.ui.vidio

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.projectapppembelajaran.databinding.FragmentVidioBinding

class VidioFragment : Fragment() {

    private var _binding: FragmentVidioBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val vidioViewModel =
            ViewModelProvider(this).get(VidioViewModel::class.java)
            activity?.actionBar?.hide()
        _binding = FragmentVidioBinding.inflate(inflater, container, false)
        val root: View = binding.root

//        val textView: TextView = binding.textVidio
        vidioViewModel.text.observe(viewLifecycleOwner) {
//            textView.text = it
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
        activity?.actionBar?.show()
    }
}