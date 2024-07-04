import java.util.Scanner;

public class Solution {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int T = scanner.nextInt();
        for (int i = 1; i <= T; i++) {
            int N = scanner.nextInt();
            int[][] matrice = new int[N][N];
            int trace = 0, ligne = 0, colonne = 0;

            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    int c = scanner.nextInt();
                    matrice[j][k] = c-1;
                    if (j == k) {
                        trace += c;
                    }
                }
            }

            for (int j = 0; j < N; j++) {
                boolean[] check = new boolean[N];
                for (int k = 0; k < N; k++) {
                    int c = matrice[j][k];
                    if (check[c]) {
                        ligne ++;
                        break;
                    }
                    check[c] = true;
                }
            }

            for (int j = 0; j < N; j++) {
                boolean[] check = new boolean[N];
                for (int k = 0; k < N; k++) {
                    int c = matrice[k][j];
                    if (check[c]) {
                        colonne ++;
                        break;
                    }
                    check[c] = true;
                }
            }

            System.out.println("Case #" + i + ": " + trace + " " + ligne + " " + colonne);


        }
    }
}
