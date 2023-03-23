package com.example.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

/**
 * Aktivity ini mengizinkan user dapat menggulirkan dadu
 * dan melihat hasilnya di layar
 */
class MainActivity : AppCompatActivity() {
    // metod ini akan langsung dipanggil saat aktivity tadi dibuat
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //mencari tombol di layout
        val rollButton: Button = findViewById(R.id.button)
        //menggunakan setOnClickListener agar ketika user menekan tombol program akan menggulirkan dadu
        rollButton.setOnClickListener { rollDice() }

        //langsung menggulir dadu saat aplikasi dibuka
        rollDice()
    }

//Menggulirkan dadu dan memperbaharui layar dengan hasil nya
    private fun rollDice() {
        //Membuat objek dadu baru dengan 6 sisi dan menggulikan nya
        val dice = Dice(6)
        val diceRoll = dice.roll()
        //mencari ImageView di layout
        val diceImage: ImageView = findViewById(R.id.imageView)
        //menentukan id dari variabel sesuai dengan guliran dadu
        val drawableResource = when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        //memperbaharui ImageView sesuai dengan id variabel drawableResourche
        diceImage.setImageResource(drawableResource)
        //memperbaharui deskripsi konten sesuai dengan guliran dadu
        diceImage.contentDescription = diceRoll.toString()
    }
}
//clas dadu dengan angka sisi yang sudah ditentukan
class Dice(private val numSide: Int) {
    //fungsi yang melakukan gulir dadu secara acak dengan batas yang sesuai jumlah sisi
    fun roll(): Int {
        return (1..numSide).random()
    }
}
