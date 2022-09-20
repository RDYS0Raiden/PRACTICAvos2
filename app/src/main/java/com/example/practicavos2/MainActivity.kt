package com.example.practicavos2

import androidx.appcompat.app.AppCompatActivity
import android.speech.tts.TextToSpeech
import android.widget.Toast
import androidx.core.view.isGone
import android.os.Bundle
import android.view.View
import android.widget.Switch
import com.example.practicavos2.databinding.ActivityMainBinding
import java.util.*

class MainActivity : AppCompatActivity(), TextToSpeech.OnInitListener {


    private var mensaje:String?=null
    private var nombre:String?=null

    private lateinit var tts:TextToSpeech

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        val view=binding.root
        setContentView(view)
        tts = TextToSpeech(this, this)
        binding.btnProcesar.setOnClickListener {
            OPCIONSW()
        }

    }

private fun OPCIONSW(){

        mensaje = binding.pltxt1.text.toString()
        nombre = binding.pltxt2.text.toString()


            if (binding.Sw.isChecked == true) {

                binding.txtNombre.text = mensaje + nombre
                tts.speak(nombre + mensaje, TextToSpeech.QUEUE_FLUSH, null, "")
            } else {
                binding.txtNombre.text = mensaje
                tts.speak(mensaje, TextToSpeech.QUEUE_FLUSH, null, "")
            }

}

    override fun onInit(status: Int) {
        var resultado = if (status == TextToSpeech.SUCCESS) {
            //se puede escribir 500 lineas de codigo pero la ultima tiene que ser el
            //valor que quieres que asuma esa varianle
            //por defecto el lenguaje es ingles...
            //si quieres modificar el lenguaje se hace esto: tts.language= Locale.US
            //tts.language= Locale.US
            tts.language = Locale("ES")
            "Estado funcional correcto"
        } else "Algo salio mal,pruebe despues"

        Toast.makeText(this, resultado, Toast.LENGTH_SHORT).show()
        //ya funciona jajaja
    }
}