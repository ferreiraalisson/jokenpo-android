package com.senac.jokenpo;

import java.util.Random;

public class LogicaDoJogo {
    public static int getImgEscolha(String escolha){
        switch (escolha){
            case "Pedra":
                return R.drawable.ic_pedra;
            case "Papel":
                return R.drawable.ic_papel;
            case "Tesoura":
                return R.drawable.ic_tesoura;
            default:
                return -1;
        }
    }

    public static String EscolhaCpu(){
        String[] opcoes = {"Pedra", "Papel", "Tesoura"};
        int numero = new Random().nextInt(3);
        return opcoes[numero];
        }
}
