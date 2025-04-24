package com.senac.jokenpo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    private String escolhaJogador = "";
    private EditText editNome;

    String nomeJogador;
    private int vitorias, empates, derrotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        editNome = findViewById(R.id.input_nome);
        ImageView imgEscolha = findViewById(R.id.iconeSelecionado);

        Intent dadosRecebidos = getIntent();
        nomeJogador = dadosRecebidos.getStringExtra("nomeJogador");
        vitorias = dadosRecebidos.getIntExtra("vitorias", 0);
        empates = dadosRecebidos.getIntExtra("empates", 0);
        derrotas = dadosRecebidos.getIntExtra("derrotas", 0);

        if (nomeJogador != null && !nomeJogador.isEmpty()) {
            editNome.setText(nomeJogador);
            editNome.setEnabled(false); // Desativar edição se nome já foi definido
        }

        findViewById(R.id.view_pedra).setOnClickListener(v -> {
            escolhaJogador = "pedra";
            imgEscolha.setImageResource(LogicaDoJogo.getImagemEscolha("pedra"));
        });

        findViewById(R.id.view_papel).setOnClickListener(v -> {
            escolhaJogador = "papel";
            imgEscolha.setImageResource(LogicaDoJogo.getImagemEscolha("papel"));
        });

        findViewById(R.id.view_tesoura).setOnClickListener(v -> {
            escolhaJogador = "tesoura";
            imgEscolha.setImageResource(LogicaDoJogo.getImagemEscolha("tesoura"));
        });

        findViewById(R.id.btn_jogar).setOnClickListener(v -> {
            String nome = editNome.getText().toString().trim();

            if (escolhaJogador.isEmpty() || nome.isEmpty()) {
                Toast.makeText(this, "Escolha uma opção e digite seu nome", Toast.LENGTH_SHORT).show();
            } else {
                Intent intentTela3 = new Intent(this, Tela3Activity.class);
                intentTela3.putExtra("NOME", nome);
                intentTela3.putExtra("ESCOLHA_JOGADOR", escolhaJogador);
                intentTela3.putExtra("vitorias", vitorias);
                intentTela3.putExtra("empates", empates);
                intentTela3.putExtra("derrotas", derrotas);
                startActivity(intentTela3);
                finish(); // Fecha a Tela 2 para evitar retorno duplicado
            }
        });
    }
}
