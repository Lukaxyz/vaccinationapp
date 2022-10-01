package com.example.vakcinacija

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.vakcinacija.databinding.FragmentUvodBinding

class UvodFragment : Fragment() {

    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentUvodBinding>(inflater, R.layout.fragment_uvod, container, false)
        binding.button1.setOnClickListener { view: View -> view.findNavController().navigate(R.id.action_uvodFragment_to_infoFragment)
        }
        binding.EnglishButton.setOnClickListener{
            binding.textView.text= "Welcome! This application simulates the vaccination registration during the Covid-19 pandemic. Press the button to continue."
            binding.button1.text = "Continue"
            binding.EnglishButton.setVisibility(View.GONE);
        }
        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.options_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.
                onNavDestinationSelected(item,requireView().findNavController())
                || super.onOptionsItemSelected(item)
    }



}