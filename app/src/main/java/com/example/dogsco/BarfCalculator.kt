package com.example.dogsco

import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.dogsco.ui.gallery.GalleryFragment
import com.example.dogsco.ui.home.HomeFragment
import kotlin.math.ceil

class BarfCalculator(a: Fragment, poids: Double, age: Double, rjour: Double) {

    private lateinit var a: Fragment
    private var poids: Double = 0.0
    private var age: Double = 0.0
    private var rjour: Double = 0.0

    fun calculator(): Double {
        if (this.a is HomeFragment) {
            if (this. age > 1.0)
                return (this.poids * this.rjour / 100)
            else
                return (this.poids * this.rjour / 100) * 2.0
        }

        else if (this.a is GalleryFragment) {
            val tv1: TextView? = a.activity?.findViewById(R.id.text_gallery_v)
            val tv2: TextView? = a.activity?.findViewById(R.id.text_gallery_v2)
            val tv3: TextView? = a.activity?.findViewById(R.id.text_gallery_v3)
            val tv4: TextView? = a.activity?.findViewById(R.id.text_gallery_v4)
            val tv5: TextView? = a.activity?.findViewById(R.id.text_gallery_v5)
            val tv6: TextView? = a.activity?.findViewById(R.id.text_gallery_v6)

            if (this.age > 1.0) {
                tv1?.text = (this.poids * this.rjour * 5.0).toString() + " g"
                tv2?.text = (this.poids * this.rjour * 5.0 - this.poids * this.rjour).toString() + " g"
                tv3?.text = (this.poids * this.rjour).toString() + " g"
                tv4?.text = (this.poids).toString() + " mL"
                tv5?.text = (this.poids / 10.0).toString() + " g"
                tv6?.text = ceil(this.age / 11.0).toString()

                return (this.poids * this.rjour / 100)
            }
            else {
                tv1?.text = (this.poids * this.rjour * 10).toString() + " g"
                tv2?.text = (this.poids * this.rjour * 10 - this.poids * this.rjour * 2.0).toString() + " g"
                tv3?.text = (this.poids * this.rjour * 2.0).toString() + " g"
                tv4?.text = (this.poids).toString() + " mL"
                tv5?.text = (this.poids / 10.0).toString() + " g"
                tv6?.text = "1.0"

                return (this.poids * this.rjour / 100) * 2.0
            }
        }

        else
            return 0.0
    }

    fun getFragment(): Fragment { return this.a }
    fun getPoids(): Double { return this.poids }
    fun getAge(): Double { return this.age }
    fun getRjour(): Double { return this.rjour }

    fun setFragment(a: Fragment) { this.a = a }
    fun setPoids(poids: Double) { this.poids = poids }
    fun setAge(age: Double) { this.age = age }
    fun setRjour(rjour: Double) { this.rjour = rjour }

}