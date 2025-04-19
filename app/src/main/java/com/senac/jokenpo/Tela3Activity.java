package com.senac.jokenpo;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Tela3Activity extends AppCompatActivity {

    ImageView iconeDoUsuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela3);

        iconeDoUsuario = findViewById(R.id.userResult);

        String escolhaUser = getIntent().getStringExtra("user");

        if (escolhaUser != null) {
            switch (escolhaUser) {
                case "Pedra":
                    iconeDoUsuario.setImageResource(R.drawable.ic_pedra);
                    break;
                case "Papel":
                    iconeDoUsuario.setImageResource(R.drawable.ic_papel);
                    break;
                case "Tesoura":
                    iconeDoUsuario.setImageResource(R.drawable.ic_tesoura);
                    break;
                default:
                    iconeDoUsuario.setImageResource(R.drawable.ic_vazio);
                    break;
            }
        }

    }
}