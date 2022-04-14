package com.example.dogsco.ui.gallery

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
import com.example.dogsco.databinding.FragmentGalleryBinding

class GalleryFragment : Fragment() {

    private lateinit var galleryViewModel: GalleryViewModel
    private var _binding: FragmentGalleryBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        container?.removeAllViews()

        galleryViewModel = ViewModelProvider(this).get(GalleryViewModel::class.java)

        _binding = FragmentGalleryBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textGallery
        val textView2: TextView = binding.textGallery2
        val textView3: TextView = binding.textGallery3
        val textView4: TextView = binding.textGallery4
        val textView5: TextView = binding.textGallery5
        val textView6: TextView = binding.textGallery6

        val tv1 : TextView =  binding.textGalleryV
        val tv2 : TextView =  binding.textGalleryV2
        val tv3 : TextView =  binding.textGalleryV3
        val tv4 : TextView =  binding.textGalleryV4
        val tv5 : TextView =  binding.textGalleryV5
        val tv6 : TextView =  binding.textGalleryV6

        galleryViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        galleryViewModel.text2.observe(viewLifecycleOwner, Observer {
            textView2.text = it
        })
        galleryViewModel.text3.observe(viewLifecycleOwner, Observer {
            textView3.text = it
        })
        galleryViewModel.text4.observe(viewLifecycleOwner, Observer {
            textView4.text = it
        })
        galleryViewModel.text5.observe(viewLifecycleOwner, Observer {
            textView5.text = it
        })
        galleryViewModel.text6.observe(viewLifecycleOwner, Observer {
            textView6.text = it
        })
        galleryViewModel.text_v.observe(viewLifecycleOwner, Observer {
            tv1.text = it
        })
        galleryViewModel.text_v2.observe(viewLifecycleOwner, Observer {
            tv2.text = it
        })
        galleryViewModel.text_v3.observe(viewLifecycleOwner, Observer {
            tv3.text = it
        })
        galleryViewModel.text_v4.observe(viewLifecycleOwner, Observer {
            tv4.text = it
        })
        galleryViewModel.text_v5.observe(viewLifecycleOwner, Observer {
            tv5.text = it
        })
        galleryViewModel.text_v6.observe(viewLifecycleOwner, Observer {
            tv6.text = it
        })

        return root
    }

    override fun onStart() {
        super.onStart()
        MainActivity.Barf.setFragment(this)
        MainActivity.Barf.calculator()
    }

    override fun onResume() {
        super.onResume()
        MainActivity.Barf.setFragment(this)
        MainActivity.Barf.calculator()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}