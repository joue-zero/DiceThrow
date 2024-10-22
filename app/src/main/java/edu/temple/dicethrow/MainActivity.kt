package edu.temple.dicethrow

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.rollDiceButton).setOnClickListener {
            // so the findFragmentById returns a Fragment, we need to cast it to DieFragment
//            val fragment = supportFragmentManager.findFragmentById(R.id.dieContainer) as DieFragment
//            fragment.throwDie()
            if(supportFragmentManager.findFragmentById(R.id.dieContainer) !is DieFragment) {
                supportFragmentManager.beginTransaction()
                .add(R.id.dieContainer, DieFragment.newInstance(20))
                .commit()
            }
            else {
                val fragment = supportFragmentManager.findFragmentById(R.id.dieContainer) as DieFragment
                fragment.throwDie()
            }
//            if(savedInstanceState == null)
        }
    }
}