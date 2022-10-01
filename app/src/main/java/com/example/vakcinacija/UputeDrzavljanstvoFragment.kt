package com.example.vakcinacija

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.vakcinacija.databinding.FragmentUputeDrzavljanstvoBinding


class UputeDrzavljanstvoFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? { val binding = DataBindingUtil.inflate<FragmentUputeDrzavljanstvoBinding>(inflater, R.layout.fragment_upute_drzavljanstvo, container, false)
        binding.povratakButton2.setOnClickListener{ view: View -> view.findNavController().navigate(R.id.action_uputeDrzavljanstvoFragment_to_uvodFragment)
        }
        return binding.root


}}