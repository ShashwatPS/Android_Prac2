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
import com.example.androidprac.databinding.FragmentSecondBinding
import com.example.androidprac.viewmodel.CountViewModel

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null

    private val countViewModel: CountViewModel by activityViewModels()

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonSecond.setOnClickListener {
            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
        }

        binding.decrement.setOnClickListener {
            countViewModel.decrement()
        }

        countViewModel.getMutableLiveData().observe(viewLifecycleOwner, Observer { incomingValue ->
            Log.i("HARRY","Received Value :"+incomingValue)
            Toast.makeText(view.context,"received Value: "+ incomingValue, Toast.LENGTH_SHORT).show()
            binding.textviewSecond.text = "Count : "+incomingValue
        })
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}