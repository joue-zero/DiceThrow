package edu.temple.dicethrow

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button


class ButtonFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_button, container, false).apply {
            findViewById<Button>(R.id.button).setOnClickListener { // every fragement can access
                (activity as ButtonInterface).buttonClick()
                // the difference between activity and requireActivity is that requireActivity will throw an exception if the activity is null
            }
        }
    }

}

interface ButtonInterface {
    fun buttonClick()
}