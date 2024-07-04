import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int nb = sc.nextInt();
        int[] res = new int[3 * nb];

        for (int w = 0; w < nb; w++) {
            int n = sc.nextInt();
            int[][] tab = new int[n][n];
            int trace = 0, rowRepeats = 0, colRepeats = 0;

            sc.nextLine(); // Consume the newline character

            for (int i = 0; i < n; i++) {
                String[] row = sc.nextLine().split(" ");
                boolean[] rowCheck = new boolean[n + 1];

                for (int j = 0; j < n; j++) {
                    tab[i][j] = Integer.parseInt(row[j]);
                    if (i == j) {
                        trace += tab[i][j];
                    }

                    if (rowCheck[tab[i][j]]) {
                        rowRepeats++;
                        break;
                    }
                    rowCheck[tab[i][j]] = true;
                }
            }

            for (int i = 0; i < n; i++) {
                boolean[] colCheck = new boolean[n + 1];
                for (int j = 0; j < n; j++) {
                    if (colCheck[tab[j][i]]) {
                        colRepeats++;
                        break;
                    }
                    colCheck[tab[j][i]] = true;
                }
            }

            res[3 * w] = trace;
            res[3 * w + 1] = rowRepeats;
            res[3 * w + 2] = colRepeats;
        }

        for (int w = 0; w < nb; w++) {
            System.out.println("Case #" + (w + 1) + ": " + res[3 * w] + " " + res[3 * w + 1] + " " + res[3 * w + 2]);
        }
    }
}