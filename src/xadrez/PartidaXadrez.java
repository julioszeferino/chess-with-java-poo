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
     * Coloca uma peca nova no tabuleiro
     * @param coluna coluna da posicao
     * @param linha linha da posicao
     * @param peca instancia da peca a ser colocada
     */
    private void colocaPecaNova(char coluna, int linha, PecaXadrez peca) {
        tabuleiro.colocaPeca(peca, new PosicaoXadrez(coluna, linha).toPosicao());
    }

    /**
     * Coloca as pecas no tabuleiro em suas posicoes iniciais
     * @return
     */
    private void configInicial() {
        colocaPecaNova('b', 6, new Torre(tabuleiro, Cor.BRANCO));
        colocaPecaNova('e', 8, new Rei(tabuleiro, Cor.PRETO));
        colocaPecaNova('e', 1, new Rei(tabuleiro, Cor.BRANCO));
    }

}
