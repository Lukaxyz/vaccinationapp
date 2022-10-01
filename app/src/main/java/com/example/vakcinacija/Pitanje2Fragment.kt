package com.example.vakcinacija

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.vakcinacija.databinding.FragmentPitanje2Binding


class Pitanje2Fragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentPitanje2Binding>(
            inflater, R.layout.fragment_pitanje2, container, false)
        val args = Pitanje2FragmentArgs.fromBundle(requireArguments())
        binding.DugmeDalje3.setOnClickListener { view: View ->
            val checkedId = binding.radioGroup2.checkedRadioButtonId
            if (checkedId == R.id.radioButtonDa){
                val imeiprezime = "${args.imeiprezime}"
                val email="${args.email} "
                val prioritet="${args.prioritet}"
                view.findNavController().navigate(Pitanje2FragmentDirections.actionPitanje2FragmentToOdabirVakcineFragment(imeiprezime, email, prioritet))
            }else if (checkedId == R.id.radioButtonNe){
                view.findNavController().navigate(Pitanje2FragmentDirections.actionPitanje2FragmentToUputeDrzavljanstvoFragment())
            }else{
                Toast.makeText(activity, "Molim vas odaberite odgovor", Toast.LENGTH_LONG).show()
            }
        }
        return binding.root
        
    }


}