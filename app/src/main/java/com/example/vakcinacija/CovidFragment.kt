package com.example.vakcinacija

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.vakcinacija.databinding.FragmentCovidBinding
import com.example.vakcinacija.databinding.FragmentPitanje1Binding


class CovidFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ):  View? {val binding = DataBindingUtil.inflate<FragmentCovidBinding>(inflater, R.layout.fragment_covid, container, false)
        binding.povratakButton.setOnClickListener { view: View -> view.findNavController().navigate(R.id.action_covidFragment_to_uvodFragment)
        }
        return binding.root
    }

}
