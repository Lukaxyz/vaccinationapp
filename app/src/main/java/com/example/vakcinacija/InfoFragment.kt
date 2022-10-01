package com.example.vakcinacija

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.EditText
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.vakcinacija.databinding.FragmentInfoBinding
import java.util.*


class InfoFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentInfoBinding>(
            inflater,
            R.layout.fragment_info,
            container,
            false
        )

        binding.posaljiButton.setOnClickListener {
            fun Godine(uneseni_datum: String): Int {
                val lista: List<String> = uneseni_datum.split("/").toList()
                val uneseni_dan = lista.elementAt(0).toInt()
                val uneseni_mjesec = lista.elementAt(1).toInt()
                val unesena_godina = lista.elementAt(2).toInt()
                val sadasnji_dan = Calendar.getInstance().get(Calendar.DAY_OF_MONTH)
                val sadasnji_mjesec = Calendar.getInstance().get(Calendar.MONTH)
                val sadasnja_godina = Calendar.getInstance().get(Calendar.YEAR)
                var godine_korisnika = sadasnja_godina - unesena_godina
                if (uneseni_mjesec > sadasnji_mjesec) {
                    godine_korisnika -= 1
                } else if (uneseni_mjesec == sadasnji_mjesec) {
                    if (uneseni_dan > sadasnji_dan) {
                        godine_korisnika -= 1
                    }
                }
                return godine_korisnika
            }

            val checkedId = binding.infoSpolSlanje.checkedRadioButtonId
            val ime = binding.infoImePrezimeSlanje.text.toString()
            val email = binding.infoEmailSlanje.text.toString()
            val uneseni_datum = binding.infoDatumSlanje.text.toString()

            if(ime == "" || email == "" || uneseni_datum == ""){
                Toast.makeText(activity, "Molim vas unesite sve podatke", Toast.LENGTH_LONG).show()
            }else {
                if (checkedId == R.id.info_spol_1) {
                    val spol = "hide"
                    val godine = Godine(uneseni_datum)
                    if(godine < 16){
                        Toast.makeText(activity, "Žao nam je morate imati preko 16 godina", Toast.LENGTH_LONG).show()
                    }else {
                        it.findNavController().navigate(
                            InfoFragmentDirections.actionInfoFragmentToPitanje1Fragment(
                                ime,
                                email,
                                spol
                            )
                        )
                    }
                } else if (checkedId == R.id.info_spol_2) {
                    val spol = "show"
                    val godine = Godine(uneseni_datum)
                    if (godine < 16) {
                        Toast.makeText(activity, "Žao nam je morate imati preko 16 godina", Toast.LENGTH_LONG).show()
                    } else {
                        it.findNavController().navigate(
                            InfoFragmentDirections.actionInfoFragmentToPitanje1Fragment(
                                ime,
                                email,
                                spol
                            )
                        )
                    }
                }
            }
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