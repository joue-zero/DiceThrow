package edu.temple.dicethrow

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import kotlin.random.Random

const val DIESIDE = "sidenumber"
class DieFragment : Fragment() {


    lateinit var dieTextView: TextView
    private var rollValue = 0
    private val key = "rollValue"
    var dieSides: Int = 6

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            it.getInt(DIESIDE).run {
                dieSides = this
            }
        }
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
        savedInstanceState?.run {
            rollValue = getInt(key)
        }
        if(rollValue == 0){
            throwDie()
        }else{
            dieTextView.text = rollValue.toString()
        }
    }

    // onsave instance state
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(key, rollValue)
    }

    fun throwDie() {
        val number = (Random.nextInt(dieSides) + 1)
        rollValue = number
        dieTextView.text = number.toString()
    }

    companion object {
        fun newInstance(sides: Int) =
            DieFragment().apply {
                arguments = Bundle().apply {
                    putInt(DIESIDE, sides)
                }
            }
    }
}