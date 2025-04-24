package com.senac.jokenpo;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;


public class Tela3Activity extends AppCompatActivity {

    private int[] placar = new int[3]; // {vitórias, empates, derrotas}
    ImageView imgUser, imgCpu;
    TextView resultadoEmbate, nomeUser;
    Button btnVoltarInicio, btnJogarNovamente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela3);

        imgUser = findViewById(R.id.userResult);
        imgCpu = findViewById(R.id.cpuResult);
        nomeUser = findViewById(R.id.textView2);
        resultadoEmbate = findViewById(R.id.msg);
        btnVoltarInicio = findViewById(R.id.btn_voltar_inicio);
        btnJogarNovamente = findViewById(R.id.btn_jogar_novamente);

        Intent intent = getIntent();
        String nome = intent.getStringExtra("NOME");
        String escolhaJogador = intent.getStringExtra("ESCOLHA_JOGADOR");

        if (escolhaJogador == null) {
            escolhaJogador = "Vazio";
        }

        if (nome != null && !nome.isEmpty()) {
            nomeUser.setText(nome);
        }

        placar[0] = intent.getIntExtra("vitorias", 0); // vitórias acumuladas
        placar[1] = intent.getIntExtra("empates", 0);  // empates acumulados
        placar[2] = intent.getIntExtra("derrotas", 0); // derrotas acumuladas

        String escolhaCPU = LogicaDoJogo.escolhaCPU();
        String resultado = LogicaDoJogo.embate(escolhaJogador, escolhaCPU);
        placar = LogicaDoJogo.atualizarPlacar(resultado, placar);

        imgUser.setImageResource(LogicaDoJogo.getImagemEscolha(escolhaJogador));
        imgCpu.setImageResource(LogicaDoJogo.getImagemEscolha(escolhaCPU));
        resultadoEmbate.setText(resultado);

        btnJogarNovamente.setOnClickListener(v -> {
            Intent intentJogarNovamente = new Intent(Tela3Activity.this, MainActivity2.class);
            intentJogarNovamente.putExtra("nomeJogador", nome);
            intentJogarNovamente.putExtra("vitorias", placar[0]);
            intentJogarNovamente.putExtra("empates", placar[1]);
            intentJogarNovamente.putExtra("derrotas", placar[2]);
            startActivity(intentJogarNovamente);
            finish();
        });


        btnVoltarInicio.setOnClickListener(v -> {
            String mensagem = LogicaDoJogo.ResultadoFinal(nome, placar);

            new AlertDialog.Builder(Tela3Activity.this)
                    .setTitle("Resultado Final")
                    .setMessage(mensagem)
                    .setPositiveButton("OK", (dialog, which) -> {
                        Intent i = new Intent(Tela3Activity.this, MainActivity.class);
                        startActivity(i);
                        finish();
                    })
                    .show();
        });
    }
}
