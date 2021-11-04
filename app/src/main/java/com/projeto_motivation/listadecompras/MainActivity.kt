package com.projeto_motivation.listadecompras

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val list_view_produtos = findViewById<ListView>(R.id.list_view_produtos)
        val edtxt_produto = findViewById<EditText>(R.id.edtxt_produto)
        val btn_inserir = findViewById<Button>(R.id.btn_inserir)


        //val checkbox_meat = findViewById<CheckBox>(R.id.checkbox_meat)
        //val checkbox_cheese = findViewById<CheckBox>(R.id.checkbox_cheese)


        //  IMPLEMENTANDO O ADAPTADOR
        val produtosAdapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1)

        //  DEFININDO O ADAPTADOR DA LISTA
        list_view_produtos.adapter = produtosAdapter


        // DEFININDO O OUVINTE DO BOTÃO
        btn_inserir.setOnClickListener {
            // COLETANDO VALOR DIGITADO DO USUÁRIO
            val produto = edtxt_produto.text.toString()

            // VALIDANDO DIGITAÇÃO, INSERINDO E LIMPANDO CAMPO
            if (produto.isNotEmpty()) {
                produtosAdapter.add(produto)
                edtxt_produto.text.clear()
            } else{
                edtxt_produto.error = "Digite algum produto!"
            }
        }

        // 'LONG CLICK PARA' REMOVER UM ITEM DA LISTA
        list_view_produtos.setOnItemLongClickListener {
                adapterView: AdapterView<*>,
                view: View,
                position: Int,
                id: Long ->
            val item = produtosAdapter.getItem(position)
            produtosAdapter.remove(item)
            true
        }
    }
}
