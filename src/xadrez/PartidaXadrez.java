package xadrez;

import tabuleiro.Posicao;
import tabuleiro.Tabuleiro;
import xadrez.pecas.Rei;
import xadrez.pecas.Torre;

public class PartidaXadrez {

    private Tabuleiro tabuleiro;

    public PartidaXadrez() {
        tabuleiro = new Tabuleiro(8, 8);
        configInicial();
    }

    /**
     * Retorna uma matriz de pecas de xadrez correspondente ao momento atual da
     * partida
     * @return
     */
    public PecaXadrez[][] getPecas() {
        PecaXadrez[][] mat = new PecaXadrez[tabuleiro.getLinhas()][tabuleiro.getColunas()];
        for (int i = 0; i < tabuleiro.getLinhas(); i++) {
            for (int j = 0; j < tabuleiro.getColunas(); j++) {
                // Downcasting (Peca para PecaXadrez)
                mat[i][j] = (PecaXadrez) tabuleiro.peca(i, j);
            }
        }
        return mat;
    }

    /**
     * Coloca as pecas no tabuleiro em suas posicoes iniciais
     * @return
     */
    private void configInicial() {
        tabuleiro.colocaPeca(new Torre(tabuleiro, Cor.BRANCO), new Posicao(2, 1));
        tabuleiro.colocaPeca(new Rei(tabuleiro, Cor.PRETO), new Posicao(0, 4));
        tabuleiro.colocaPeca(new Rei(tabuleiro, Cor.BRANCO), new Posicao(7, 4));
    }

}
