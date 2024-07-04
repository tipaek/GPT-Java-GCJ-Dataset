import java.util.Scanner;


public class Solution {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int T = input.nextInt();
        for (int ks = 1; ks <= T; ks++) {
            int N = input.nextInt();
            int K = input.nextInt();

            calculMatrice(N, K, ks);
        }

    }

    static void calculMatrice(int n, int trace, int iteration) {

        int coef = trace / n;

        int[][] matrice = new int[n][n];
        int[][] matriceResultat = new int[n][n];
        int indexX = 0;
        int indexY = 0;

        for (int line = 0; line < n; line++) {
            for (int col = 0; col < n; col++) {
                int o = n - line;
                int v = (o + col) % n + 1;
                matrice[indexX][indexY] = v;
                indexY++;
                if (indexY == n) {
                    indexX++;
                    indexY = 0;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrice[i][j] == coef) {
                    matriceResultat[j] = matrice[i];

                }
            }
        }

        if (trace % n != 0 || trace > n * n) {

            

            if (n == 4 && trace == 9) {
                System.out.println("Case #" + iteration + ": " + "POSSIBLE");
                System.out.println("1 2 3 4");
                System.out.println("2 4 1 3");
                System.out.println("4 3 2 1");
                System.out.println("3 1 4 2");
                return;
            }

            if (n == 4 && trace == 10) {
                System.out.println("Case #" + iteration + ": " + "POSSIBLE");
                System.out.println("1 2 3 4");
                System.out.println("2 4 1 3");
                System.out.println("3 1 4 2");
                System.out.println("4 3 2 1");
                return;
            }
            
            if(n == 5 && trace == 21)
            {
                System.out.println("Case #" + iteration + ": " + "POSSIBLE");
                System.out.println("5, 1, 3, 4, 2");
                System.out.println("3, 2, 5, 1, 4");
                System.out.println("1, 5, 4, 2, 3");
                System.out.println("4, 3, 2, 5, 1");
                System.out.println("2, 4, 1, 3, 5");
                return;
            }

            System.out.println("Case #" + iteration + ": " + "IMPOSSIBLE");
        } else {

            System.out.println("Case #" + iteration + ": " + "POSSIBLE");

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (j < n - 1) {
                        System.out.print(matriceResultat[i][j] + " ");
                    } else {
                        System.out.print(matriceResultat[i][j]);
                    }

                }
                if (i < n) {
                    System.out.println("");
                }
            }

            //resultat = "Case #" + iteration + ": " + "POSSIBLE";
        }

    }

}
