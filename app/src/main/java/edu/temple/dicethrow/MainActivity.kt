package edu.temple.dicethrow

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity(), ButtonInterface {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun buttonClick(){
        if(supportFragmentManager.findFragmentById(R.id.dieContainer) !is DieFragment) {
            supportFragmentManager.beginTransaction()
                .add(R.id.dieContainer, DieFragment.newInstance(20))
                .commit()
        } else {
            val fragment = supportFragmentManager.findFragmentById(R.id.dieContainer) as DieFragment
            fragment.throwDie()
        }
    }
}