package com.example.vakcinacija

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.vakcinacija.databinding.FragmentPrioritetBinding

class PrioritetFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentPrioritetBinding>(inflater, R.layout.fragment_prioritet, container, false)
        val args = PrioritetFragmentArgs.fromBundle(requireArguments())

        binding.DugmeDalje4.setOnClickListener {
            val checkedId = binding.radioGroup3.checkedRadioButtonId
            if (checkedId == R.id.radioButton1 || checkedId == R.id.radioButton2 || checkedId == R.id.radioButton3 || checkedId == R.id.radioButton4 || checkedId == R.id.radioButton5){
                val imeiprezime = "${args.imeiprezime}"
                val email="${args.email} "
                val prioritet="da"
                it.findNavController().navigate(PrioritetFragmentDirections.actionPrioritetFragmentToPitanje2Fragment(imeiprezime,email,prioritet))
            } else if(checkedId == R.id.radioButton6){
                val imeiprezime = "${args.imeiprezime}"
                val email="${args.email} "
                val prioritet="ne"
                it.findNavController().navigate(PrioritetFragmentDirections.actionPrioritetFragmentToPitanje2Fragment(imeiprezime,email,prioritet))
            }else{
                Toast.makeText(activity, "Molim vas odaberite odgovor", Toast.LENGTH_LONG).show()
            }

        }
        return binding.root
    }
}