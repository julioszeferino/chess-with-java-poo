package aplicacao;

import xadrez.PecaXadrez;

public class UI {

    /**
     * Mostra o tabuleiro na tela
     * @param pecas matriz de pecas do tabuleiro
     * @return
     */
    public static void mostraTabuleiro(PecaXadrez[][] pecas) {
        for (int i = 0; i < pecas.length; i++) {
            System.out.print((8 - i) + " ");
            for (int j = 0; j < pecas.length; j++) {
                mostraPeca(pecas[i][j]);
            }
            System.out.println();
        }
        System.out.println("  a b c d e f g h");
    }

    /**
     * Mostra uma peca na tela
     * @param peca
     * @return
     */
    private static void mostraPeca(PecaXadrez peca) {
        if (peca == null) {
            System.out.print("-");
        } else {
            System.out.print(peca);
        }
        System.out.print(" ");
    }
}
