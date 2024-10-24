package edu.temple.dicethrow

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import kotlin.random.Random

class DieFragment : Fragment() {

    val DIESIDE = "sidenumber"
    val CURRENTSIDE = "currentside"

    lateinit var dieTextView: TextView

    var dieSides: Int = 6
    var currentSide: Int = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            it.getInt(DIESIDE).run {
                dieSides = this
            }
        }

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(CURRENTSIDE,currentSide)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

         return inflater.inflate(R.layout.fragment_die, container, false).apply {
            dieTextView = findViewById(R.id.dieTextView)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        savedInstanceState?.run{
            currentSide = this.getInt(CURRENTSIDE,-1)
            view.findViewById<TextView>(R.id.dieTextView).text = currentSide.toString()
        }
        if (currentSide==-1){
            throwDie()
        }
        view.setOnClickListener{
            throwDie()
        }
    }

    fun throwDie() {
        currentSide = Random.nextInt(dieSides)+1
        dieTextView.text = currentSide.toString()
    }


    companion object {
        fun newInstance(sides: Int): DieFragment {
            return DieFragment().apply{
                var bundleTemp = Bundle()
                bundleTemp.putInt(this.DIESIDE, sides)
                arguments = bundleTemp
            }
        }
    }
}