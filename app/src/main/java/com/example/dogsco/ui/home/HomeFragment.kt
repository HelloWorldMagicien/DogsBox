package com.example.dogsco.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.dogsco.BarfCalculator
import com.example.dogsco.MainActivity
import com.example.dogsco.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel
    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private lateinit var edt1: EditText
    private lateinit var edt2: EditText
    private lateinit var edt3: EditText
    private lateinit var textView5: TextView

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        container?.removeAllViews()

        homeViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textHome
        val textView2: TextView = binding.textHome2
        val textView3: TextView = binding.textHome3
        val textView4: TextView = binding.textHome4

        textView5 = binding.textHome5
        edt1 = binding.editText
        edt2 = binding.editText2
        edt3 = binding.editText3

        homeViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        homeViewModel.text2.observe(viewLifecycleOwner, Observer {
            textView2.text = it
        })
        homeViewModel.text3.observe(viewLifecycleOwner, Observer {
            textView3.text = it
        })
        homeViewModel.text4.observe(viewLifecycleOwner, Observer {
            textView4.text = it
        })
        homeViewModel.text5.observe(viewLifecycleOwner, Observer {
            textView5.text = it
        })

        val btn : Button = binding.button
        btn.setOnClickListener {
            //suite du code
            //création de l'objet BarfCalculator
            MainActivity.Barf.setFragment(this)
            MainActivity.Barf.setPoids(edt1.text.toString().toDouble())
            MainActivity.Barf.setAge(edt2.text.toString().toDouble())
            MainActivity.Barf.setRjour(edt3.text.toString().toDouble())
            println(MainActivity.Barf.getFragment())
            textView5.text = (Math.round(MainActivity.Barf.calculator() * 1000.0) / 1000.0).toString() + " kg"
        }

        return root
    }

    override fun onStart() {
        super.onStart()
        MainActivity.Barf.setFragment(this)
        edt1.setText(MainActivity.Barf.getPoids().toString())
        edt2.setText(MainActivity.Barf.getAge().toString())
        edt3.setText(MainActivity.Barf.getRjour().toString())
        textView5.text = (Math.round(MainActivity.Barf.calculator() * 1000.0) / 1000.0).toString() + " kg"
    }

    override fun onResume() {
        super.onResume()
        MainActivity.Barf.setFragment(this)
        edt1.setText(MainActivity.Barf.getPoids().toString())
        edt2.setText(MainActivity.Barf.getAge().toString())
        edt3.setText(MainActivity.Barf.getRjour().toString())
        textView5.text = (Math.round(MainActivity.Barf.calculator() * 1000.0) / 1000.0).toString() + " kg"
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}