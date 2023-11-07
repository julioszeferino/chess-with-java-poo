package xadrez;

import tabuleiro.Posicao;

public class PosicaoXadrez {

    private char coluna;
    private int linha;

    public PosicaoXadrez(char coluna, int linha) {
        if (coluna < 'a' || coluna > 'h' || linha < 1 || linha > 8) {
            throw new XadrezException("Erro ao instanciar a posicao do xadrez. Valores validos sao de a1 ate h8");
        }
        this.coluna = coluna;
        this.linha = linha;
    }

    public char getColuna() {
        return coluna;
    }

    public int getLinha() {
        return linha;
    }

    /**
     * Converte a posicao do xadrez para uma posicao de matriz.
     * Ex: Posicao Xadrez: a1 -> Posicao Matriz (Tabuleiro): 7, 0
     * @return instancia de posicao
     */
    protected Posicao toPosicao() {
        return new Posicao(8 - linha, coluna - 'a');
    }

    /**
     * Converte uma posicao de matriz para uma posicao do xadrez.
     * Ex: Posicao Matriz (Tabuleiro): 7, 0 -> Posicao Xadrez: a1
     * @param posicao instancia de posicao
     * @return instancia de posicao do xadrez
     */
    protected static PosicaoXadrez fromPosicao(Posicao posicao) {
        return new PosicaoXadrez((char) ('a' - posicao.getColuna()), 8 - posicao.getLinha());
    }

    @Override
    public String toString() {
        return "" + coluna + linha;
    }
}
