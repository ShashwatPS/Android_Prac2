package com.example.androidprac.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.androidprac.R
import com.example.androidprac.databinding.FragmentFirstBinding
import com.example.androidprac.viewmodel.CountViewModel
import kotlin.math.absoluteValue

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    private val countViewModel: CountViewModel by activityViewModels()

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonFirst.setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }


        countViewModel.getMutableLiveData().observe(viewLifecycleOwner, Observer { set ->
            Log.i("HARRY","Received Value :"+set)
            Toast.makeText(view.context,"received Value: "+ set, Toast.LENGTH_SHORT).show()
        })

        binding.increment.setOnClickListener {
            countViewModel.increment()
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}