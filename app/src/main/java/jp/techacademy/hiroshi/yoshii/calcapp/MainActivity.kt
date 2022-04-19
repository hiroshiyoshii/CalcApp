package jp.techacademy.hiroshi.yoshii.calcapp

import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import android.content.Intent

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button1.setOnClickListener(this)
        button2.setOnClickListener(this)
        button3.setOnClickListener(this)
        button4.setOnClickListener(this)

    }

    override fun onClick(v: View) {
        val intent = Intent(this, SecondActivity::class.java)

        if (editText1.text.toString() == "" || editText2.text.toString() == "") {
            val rootLayout: View = findViewById(android.R.id.content)
            val snackbar = Snackbar.make(rootLayout, "数字をいれてください", Snackbar.LENGTH_LONG)
            snackbar.show()

        } else {


            val x: Double = editText1.text.toString().toDouble()
            val y: Double = editText2.text.toString().toDouble()

            var z: Double = 0.0


            when (v.id) {
                R.id.button1 -> {
                    z = (x + y)
                }
                R.id.button2 -> {
                    z = (x - y)
                }
                R.id.button3 -> {
                    z = (x * y)
                }
                R.id.button4 -> {
                    z = (x / y)
                }
            }

            intent.putExtra("VALUE", z)
            startActivity(intent)

        }
    }
}


