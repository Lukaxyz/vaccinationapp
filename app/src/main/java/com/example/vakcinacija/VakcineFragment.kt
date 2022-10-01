package com.example.vakcinacija

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.vakcinacija.databinding.FragmentAboutBinding
import com.example.vakcinacija.databinding.FragmentVakcineBinding

class VakcineFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentVakcineBinding>(
            inflater,
            R.layout.fragment_vakcine,
            container,
            false
        )

        return binding.root
    }
}