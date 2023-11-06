package tabuleiro;

public class Tabuleiro {

    private int linhas;
    private int colunas;
    private Peca[][] pecas;

    public Tabuleiro(int linhas, int colunas) {
        if (linhas < 1 || colunas < 1) {
            throw new TabuleiroException("Erro ao criar tabuleiro: e necessario que haja pelo menos 1 linha e 1 coluna");
        }
        this.linhas = linhas;
        this.colunas = colunas;
        pecas = new Peca[linhas][colunas];
    }

    public int getLinhas() {
        return linhas;
    }

    public int getColunas() {
        return colunas;
    }

    public Peca peca(int linha, int coluna) {
        if (!posicaoExiste(linha, coluna)) {
            throw new TabuleiroException("Posicao nao existe no tabuleiro");
        }
        return pecas[linha][coluna];
    }

    public Peca peca(Posicao posicao) {
        if (!posicaoExiste(posicao)) {
            throw new TabuleiroException("Posicao nao existe no tabuleiro");
        }
        return pecas[posicao.getLinha()][posicao.getColuna()];
    }

    /**
     * Coloca uma peca na posicao
     * @param peca instancia da peca a ser colocada
     * @param posicao posicao onde a peca sera colocada no tabuleiro
     */
    public void colocaPeca(Peca peca, Posicao posicao) {
        if (existePeca(posicao)) {
            throw new TabuleiroException("Ja existe uma peca na posicao " + posicao);
        }
        pecas[posicao.getLinha()][posicao.getColuna()] = peca;
        peca.posicao = posicao; // peca recebe a posicao
    }

    /**
     * Verifica se existe a posicao no tabuleiro e se e uma posicao valida
     * @param linha posicao da linha no tabuleiro
     * @param coluna posicao da coluna no tabuleiro
     * @return true se existir uma peca na posicao
     */
    private boolean posicaoExiste(int linha, int coluna) {
        return linha >= 0 && linha < linhas && coluna >= 0 && coluna < colunas;
    }

    /**
     * Verifica se existe a posicao no tabuleiro e se e uma posicao valida
     * @param posicao instancia da posicao no tabuleiro
     * @return true se existir uma peca na posicao
     */
    public boolean posicaoExiste(Posicao posicao) {
        return posicao.getLinha() >= 0 && posicao.getLinha() < linhas && posicao.getColuna() >= 0
                && posicao.getColuna() < colunas;
    }

    /**
     * Verifica se existe uma peca na posicao do tabuleiro
     * @param posicao instancia da posicao no tabuleiro
     * @return true se existir uma peca na posicao
     */
    public boolean existePeca(Posicao posicao) {
        if (!posicaoExiste(posicao)) {
            throw new TabuleiroException("Posicao nao existe no tabuleiro");
        }
        return peca(posicao) != null;
    }
}

