import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        List<Integer[][]> lista = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        int cases = scanner.nextInt();

        for (int i = 0; i < cases; i++) {
            int size = scanner.nextInt();

            Integer matriz[][] = new Integer[size][size];

            for (int j = 0; j < size; j++) {
                for (int k = 0; k < size; k++) {
                    matriz[j][k] = scanner.nextInt();
                }
            }
            lista.add(matriz);
        }

        for (int i = 0; i < cases; i++) {

            int soma = 0;
            int coluna = 0;
            int linha = 0;

            for (int j = 0; j < lista.get(i).length; j++) {

                boolean checkColuna = false, checkLinha = false;

                for (int k = 0; k < lista.get(i).length; k++) {
                    if (j == k) {
                        soma += lista.get(i)[j][k];
                    }

                    for (int l = 0; l < k; l++) {
                        if (k != l) {
                            if (lista.get(i)[j][k] == lista.get(i)[j][l]) {
                                checkLinha = true;
                            }
                            if (lista.get(i)[k][j] == lista.get(i)[l][j]) {
                                checkColuna = true;
                            }
                        }
                    }
                }

                if (checkColuna) coluna++;
                if (checkLinha) linha++;

            }
            System.out.println("Case #" + (i + 1) + ": " + soma + " " + linha + " " + coluna);
        }
    }
}