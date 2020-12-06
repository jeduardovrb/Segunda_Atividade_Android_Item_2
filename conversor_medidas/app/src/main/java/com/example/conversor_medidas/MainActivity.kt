package com.example.conversor_medidas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import kotlin.Double as Double1


class MainActivity : AppCompatActivity() {

    var vArrayUnidades = arrayOf("Quilômetros", "Metros", "Centímetros")

    var vSelecaoVlr       = 0
    var vSelecaoConversao = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val spinnerConversor = findViewById<Spinner>(R.id.cbConversor)
        val spinnerVlr       = findViewById<Spinner>(R.id.cbVlr)
        val txtResultado     = findViewById<TextView>(R.id.txtResultado)
        val txtValor         = findViewById<EditText>(R.id.txtValor)
        val btnCalcular      = findViewById<Button>(R.id.btnCalcular)

        val vAdaptador = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, vArrayUnidades)

        spinnerConversor.adapter = vAdaptador
        spinnerVlr.adapter       = vAdaptador

        spinnerVlr.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(p0: AdapterView<*>?) { // obrigatoria caso não selecione nenhum item
            }

            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, pSelecaoConversao: Int, pParametro: Long) {
                vSelecaoVlr = pSelecaoConversao; // posicao do vetor
            }
        }

        spinnerConversor.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(p0: AdapterView<*>?) {
            }

            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, pSelecaoConversao: Int, pParametro: Long) {
                vSelecaoConversao = pSelecaoConversao;// posicao do vetor
            }
        }

        btnCalcular.setOnClickListener{
            val vValor = txtValor.text.toString();
            var vTexto = ""

            if (vValor != ""){


                if(vSelecaoVlr == 0){ // km
                    if (vSelecaoConversao == 1) { // metros
                        vTexto = "Resultado: "
                        vTexto += Double.parseDouble(vValor) * 1000f
                        vTexto += " metros"

                        txtResultado.text = vTexto
                    } else if (vSelecaoConversao == 2) {// cm
                        vTexto = "Resultado: "
                        vTexto += Double.parseDouble(vValor) * 100000f
                        vTexto += " centímetros"

                        txtResultado.text = vTexto
                    }else {
                        txtResultado.text = "Resultado: " + vValor + " Km"// KM
                    }

                }else if(vSelecaoVlr == 1){ //metros
                        if (vSelecaoConversao == 0) { // KM
                            vTexto = "Resultado: "
                            vTexto += Double.parseDouble(vValor) / 1000f
                            vTexto += " Km"

                            txtResultado.text = vTexto
                        } else if (vSelecaoConversao == 2) {// cm
                            vTexto = "Resultado: "
                            vTexto += Double.parseDouble(vValor) * 100f
                            vTexto += " centímetros"

                            txtResultado.text = vTexto
                        }else {
                            txtResultado.text = "Resultado: " + vValor + " metros" // Metros
                        }

                }else if (vSelecaoVlr == 2) { // CM
                    if (vSelecaoConversao == 0) { // KM
                        vTexto = "Resultado: "
                        vTexto += Double.parseDouble(vValor) / 100000f
                        vTexto += " Km"

                        txtResultado.text = vTexto
                    } else if (vSelecaoConversao == 1) {// Metros
                        vTexto = "Resultado: "
                        vTexto += Double.parseDouble(vValor) / 100f
                        vTexto += " metros"

                        txtResultado.text = vTexto
                    }else {
                        txtResultado.text = "Resultado: " + vValor + " cm" // Cm
                    }
                }

            }else {
                txtResultado.text = "Digite 0 valor de comprimento!"
            }
        }

    }

}