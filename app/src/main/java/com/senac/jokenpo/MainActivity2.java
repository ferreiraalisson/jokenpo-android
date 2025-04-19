package com.senac.jokenpo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity2 extends AppCompatActivity {

    ImageView selecionado;
    String escolhaUsuario = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        selecionado = findViewById(R.id.iconeSelecionado);
    }

    public void selecionarPedra(View view){
        this.opcaoSelecionada("Pedra");
    }
    public void selecionarPapel(View view){
        this.opcaoSelecionada("Papel");
    }
    public void selecionarTesoura(View view){
        this.opcaoSelecionada("Tesoura");
    }
    public void opcaoSelecionada(String selecao){

        escolhaUsuario = selecao;

        int img = LogicaDoJogo.getImgEscolha(selecao);
        if (img != -1){
            selecionado.setBackgroundResource(img);
        }
    }
    public void jogar(View view) {
        Intent i = new Intent(this, Tela3Activity.class);
        i.putExtra("user", escolhaUsuario);
        startActivity(i);
    }
}