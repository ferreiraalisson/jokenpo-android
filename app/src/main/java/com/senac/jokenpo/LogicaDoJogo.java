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

    public static String resultados(String user, String cpu) {
        if (user.equals(cpu)) {
            return "Empate!";
        } else if ((user.equals("Pedra") && cpu.equals("Tesoura")) ||
                (user.equals("Tesoura") && cpu.equals("Papel")) ||
                (user.equals("Papel") && cpu.equals("Pedra"))) {
            return "Você venceu!";
        } else {
            return "Você perdeu!";
        }
    }

}
