package edu.temple.dicethrow

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity(), ButtonFragment.ButtonInterface {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (supportFragmentManager.findFragmentById(R.id.diceContainer) !is DieFragment){
            var fragmentTransaction = supportFragmentManager.beginTransaction()
            fragmentTransaction.add(R.id.diceContainer, DieFragment.newInstance(6))
            fragmentTransaction.commit()
        }

    }

    override fun buttonClicked() {
        (supportFragmentManager.findFragmentById(R.id.diceContainer) as DieFragment).throwDie()
    }
}