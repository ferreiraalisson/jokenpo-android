package com.senac.jokenpo;

import android.os.Bundle;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;


public class Tela3Activity extends AppCompatActivity {

    ImageView iconeDoUsuario, iconeCpu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela3);

        iconeDoUsuario = findViewById(R.id.userResult);
        iconeCpu  = findViewById(R.id.cpuResult);

        String escolhaUser = getIntent().getStringExtra("user");
        String escolhaCpu = LogicaDoJogo.EscolhaCpu();

        if (escolhaUser == null) {
            escolhaUser = "Vazio";
        }

        int imgUser = LogicaDoJogo.getImgEscolha(escolhaUser);
        if (imgUser != -1) {
            iconeDoUsuario.setImageResource(imgUser);
        }

        int imgCpu = LogicaDoJogo.getImgEscolha(escolhaCpu);
        if (imgCpu != -1) {
            iconeCpu.setImageResource(imgCpu);
        }

    }
}