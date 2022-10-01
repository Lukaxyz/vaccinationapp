package com.example.vakcinacija

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.vakcinacija.databinding.FragmentOdabirVakcineBinding
import com.example.vakcinacija.databinding.FragmentPitanje2Binding

class OdabirVakcineFragment : Fragment() {




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        val binding = DataBindingUtil.inflate<FragmentOdabirVakcineBinding>(
            inflater, R.layout.fragment_odabir_vakcine, container, false)
        val args = OdabirVakcineFragmentArgs.fromBundle(requireArguments())
        binding.EnglishButton2.setOnClickListener{
            binding.OdabirVakcine.text = "Choose which vaccine do you want:"
            binding.EnglishButton2.setVisibility(View.GONE);
            binding.DugmeDalje1.text = "Continue"
        }
        binding.DugmeDalje1.setOnClickListener{

            val checkedId = binding.radioGroup.checkedRadioButtonId
            if (checkedId == R.id.radioDugmeAZ){
                val vakcina = "AstraZeneca"
                val imeiprezime = "${args.imeiprezime}"
                val email="${args.email} "
                val prioritet="${args.prioritet}"
                it.findNavController().navigate(OdabirVakcineFragmentDirections.actionOdabirVakcineFragmentToFinishFragment(imeiprezime,email,vakcina,prioritet))
            } else if (checkedId == R.id.radioDugmeBIBP){
                val vakcina = "BIBP"
                val imeiprezime = "${args.imeiprezime}"
                val email="${args.email} "
                val prioritet="${args.prioritet}"
                it.findNavController().navigate(OdabirVakcineFragmentDirections.actionOdabirVakcineFragmentToFinishFragment(imeiprezime,email,vakcina,prioritet))
            } else if (checkedId == R.id.radioDugmePf){
                val vakcina = "Pfizer"
                val imeiprezime = "${args.imeiprezime}"
                val email="${args.email} "
                val prioritet="${args.prioritet}"
                it.findNavController().navigate(OdabirVakcineFragmentDirections.actionOdabirVakcineFragmentToFinishFragment(imeiprezime,email,vakcina,prioritet))
            }   else  if(checkedId == R.id.radioDugmeSV){
                val vakcina = "Sputnik V"
                val imeiprezime = "${args.imeiprezime}"
                val email="${args.email} "
                val prioritet="${args.prioritet}"
                it.findNavController().navigate(OdabirVakcineFragmentDirections.actionOdabirVakcineFragmentToFinishFragment(imeiprezime,email,vakcina,prioritet))
            }   else{
                Toast.makeText(activity, "Molim vas odaberite odgovor", Toast.LENGTH_LONG).show()
            }

        }
        return binding.root
}
}