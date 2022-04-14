package com.example.dogsco.ui.slideshow

import android.os.Bundle
import android.view.*
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import com.example.dogsco.R
import com.example.dogsco.databinding.FragmentSlideshowBinding
import android.widget.RadioGroup
import android.view.MotionEvent

class SlideshowFragment : Fragment() {

    private var _binding: FragmentSlideshowBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        container?.removeAllViews()

        _binding = FragmentSlideshowBinding.inflate(inflater, container, false)
        val root: View = binding.root

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val myWebView: WebView = view.findViewById(R.id.WebView1)
        myWebView.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(
                view: WebView,
                url: String
            ): Boolean {
                view.loadUrl(url)
                return true
            }
        }
        val webSetting: WebSettings = myWebView.settings
        webSetting.javaScriptEnabled = true
        myWebView.webViewClient = WebViewClient()

        myWebView.canGoBack()
        myWebView.setOnKeyListener(View.OnKeyListener { v , keyCode, event ->
            if (keyCode == KeyEvent.KEYCODE_BACK
                && event.action == MotionEvent.ACTION_UP
                && myWebView.canGoBack()){
                myWebView.goBack()
                return@OnKeyListener true
            }
            false
        })

        val myRadioView: RadioGroup = view.findViewById(R.id.radioGroup)
        println(myRadioView.checkedRadioButtonId)
        when (myRadioView.checkedRadioButtonId) {
            -1 -> {
                myRadioView.check(R.id.radio_animaleries)
                myWebView.loadUrl("https://www.google.fr/maps/search/animaleries")
            }
        }

        myWebView.settings.javaScriptEnabled = true
        myWebView.settings.allowContentAccess = true
        myWebView.settings.domStorageEnabled = true
        myWebView.settings.useWideViewPort = true

        myRadioView.setOnCheckedChangeListener { myRadioView, checkedId -> // checkedId is the RadioButton selected
            when (checkedId) {
                R.id.radio_animaleries -> {
                    myWebView.loadUrl("https://www.google.fr/maps/search/animaleries")
                }
                R.id.radio_veterinaires -> {
                    myWebView.loadUrl("https://www.google.fr/maps/search/veterinaires")
                }
            }
        }

        myWebView.setOnTouchListener { v, event ->
            if (myWebView.url!!.contains("https://www.google.fr/maps/@")) {
                when (myRadioView.checkedRadioButtonId) {
                    R.id.radio_animaleries -> {
                        myWebView.loadUrl("https://www.google.fr/maps/search/animaleries")
                    }
                    R.id.radio_veterinaires -> {
                        myWebView.loadUrl("https://www.google.fr/maps/search/veterinaires")
                    }
                }
            }
            false
        }
    }
}