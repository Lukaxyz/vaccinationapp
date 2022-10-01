package com.example.vakcinacija

import android.content.Intent
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.vakcinacija.databinding.FragmentFinishBinding
import android.os.Handler
import android.os.Looper
import android.view.*


class FinishFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentFinishBinding>(
            inflater, R.layout.fragment_finish, container, false)
        val args = FinishFragmentArgs.fromBundle(requireArguments())
        binding.textView5.text = " ${args.imeiprezime} "
        binding.textView7.text = " ${args.email}"
        binding.textView9.text = " ${args.vakcina}"
        val rand = (1..30).random()
        if ( "${args.prioritet}"=="da"){
            binding.textView12.text = rand.toString()+".6.2021. Sarajevo"
        } else {
            binding.textView12.text = rand.toString()+".7.2021. Sarajevo"
        }


        val h = Handler(Looper.getMainLooper())
        val r: Runnable = object : Runnable {
            var brojac = 135
            override fun run() {
                brojac++
                binding.textView13.setText("" + brojac)
                h.postDelayed(this, 1500) //ms
            }
        }
        h.postDelayed(r, 1500)
        setHasOptionsMenu(true)

        return binding.root
    }
    private fun getShareIntent(): Intent {
        val args = FinishFragmentArgs.fromBundle(requireArguments())
        val shareIntent = Intent(Intent.ACTION_SEND)
        shareIntent.setType("text/plain")
            .putExtra(Intent.EXTRA_TEXT, getString(R.string.share, args.imeiprezime, args.vakcina))
        return shareIntent
    }
    private fun shareMessage(){
        startActivity(getShareIntent())
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.finish, menu)
        if(getShareIntent().resolveActivity(requireActivity().packageManager)==null){
            menu.findItem(R.id.share).isVisible= false
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
            when (item.itemId){
                R.id.share -> shareMessage()
            }
            return super.onOptionsItemSelected(item)
        }

    }


