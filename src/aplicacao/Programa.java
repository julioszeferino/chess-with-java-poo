package aplicacao;
import tabuleiro.Posicao;
import tabuleiro.Tabuleiro;
import xadrez.PartidaXadrez;

public class Programa {

    public static void main(String[] args) {
        // Posicao posicao = new Posicao(3, 5);
        // System.out.println(posicao);

        // Tabuleiro tabuleiro = new Tabuleiro(8, 8);

        PartidaXadrez partidaXadrez = new PartidaXadrez();
        UI.mostraTabuleiro(partidaXadrez.getPecas());
    }

}
