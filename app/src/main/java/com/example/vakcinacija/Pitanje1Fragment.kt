package com.example.vakcinacija

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.vakcinacija.databinding.FragmentInfoBinding
import com.example.vakcinacija.databinding.FragmentPitanje1Binding

class Pitanje1Fragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentPitanje1Binding>(
            inflater,
            R.layout.fragment_pitanje1,
            container,
            false
        )
        val args = Pitanje1FragmentArgs.fromBundle(requireArguments())
        if ("${args.spol}" == "hide"){
            binding.checkBox4.visibility=View.GONE
        }
        else if ("${args.spol}" == "show"){
            binding.checkBox4.visibility=View.VISIBLE
        }
        binding.daljeButton.setOnClickListener { view: View -> /*view.findNavController().navigate(R.id.action_pitanje1Fragment_to_prioritetFragment)*/
            val check1 = binding.checkBox1
            val check2 = binding.checkBox2
            val check3 = binding.checkBox3
            val check4 = binding.checkBox4
            val imeiprezime = "${args.imeiprezime}"
            val email="${args.email} "
            if (check1.isChecked()) {
                view.findNavController().navigate(Pitanje1FragmentDirections.actionPitanje1FragmentToCovidFragment())
            } else if (check2.isChecked()) {
                view.findNavController().navigate(Pitanje1FragmentDirections.actionPitanje1FragmentToCovidFragment())
            } else if (check3.isChecked()) {
                view.findNavController().navigate(Pitanje1FragmentDirections.actionPitanje1FragmentToCovidFragment())
            } else if (check4.isChecked()) {
                view.findNavController().navigate(Pitanje1FragmentDirections.actionPitanje1FragmentToCovidFragment())
            } else {
                view.findNavController().navigate(Pitanje1FragmentDirections.actionPitanje1FragmentToPrioritetFragment(imeiprezime, email))
            }
        }


        return binding.root
    }

}