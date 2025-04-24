package com.senac.jokenpo;


import java.util.Random;

public class LogicaDoJogo {

    public static String embate(String escolhaJogador, String escolhaCPU) {
        if (escolhaJogador.equals(escolhaCPU)) return "Empate!";
        if ((escolhaJogador.equals("pedra") && escolhaCPU.equals("tesoura")) ||
                (escolhaJogador.equals("papel") && escolhaCPU.equals("pedra")) ||
                (escolhaJogador.equals("tesoura") && escolhaCPU.equals("papel"))) {
            return "Você venceu!";
        } else {
            return "Você perdeu!";
        }
    }

    public static int[] atualizarPlacar(String resultado, int[] placar) {
        switch (resultado) {
            case "Você venceu!":
                placar[0]++;
                break;
            case "Empate!":
                placar[1]++;
                break;
            case "Você perdeu!":
                placar[2]++;
                break;
        }
        return placar;
    }

    public static String ResultadoFinal(String nome, int[] placar) {
        return nome + ", aqui está seu placar final:\n\nVitórias: " + placar[0] +
                "\nEmpates: " + placar[1] +
                "\nDerrotas: " + placar[2];
    }

    public static int getImagemEscolha(String escolha) {
        switch (escolha) {
            case "pedra": return R.drawable.ic_pedra;
            case "papel": return R.drawable.ic_papel;
            case "tesoura": return R.drawable.ic_tesoura;
            default: return R.drawable.ic_vazio;
        }
    }

    public static String escolhaCPU() {
        String[] opcoes = {"pedra", "papel", "tesoura"};
        int numero = new Random().nextInt(3);
        return opcoes[numero];
    }
}

