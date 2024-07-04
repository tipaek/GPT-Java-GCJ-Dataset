import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Vestigium {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();

        Vestigium solution = new Vestigium();
        for (int i = 1; i <= t; ++i) {
            Integer M = in.nextInt();
            Integer[][] matrix = new Integer[M][M];
            for (int j = 0; j < M; j++) {
                for (int k = 0; k < M; k++) {
                    Integer val = in.nextInt();
                    matrix[j][k] = val;
                }
            }
            System.out.println("Case #" + i + ": " + solution.test(M, matrix));
        }
    }

    public String test(Integer M, Integer[][] matrix) {
        int sum = 0;
        for (int i = 0; i < M; i++)
            sum += matrix[i][i];

        boolean[] row = new boolean[M];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < M; j++) {
                if (row[i]) continue;
                for (int k = j + 1; k < M; k++) {
                    if (matrix[i][j].equals(matrix[i][k])) {
                        row[i] = true;
                    }
                }
            }
        }

        boolean[] col = new boolean[M];
        for (int k = 0; k < M; k++) {
            for (int i = 0; i < M; i++) {
                if (col[k]) continue;
                for (int j = i + 1; j < M; j++) {
                    if (matrix[i][k].equals(matrix[j][k])) {
                        col[k] = true;
                    }
                }
            }
        }

        int countR = 0;
        int countC = 0;
        for (int i = 0; i < M; i++) {
            if (row[i]) countR++;
            if (col[i]) countC++;
        }
        return String.format("%d %d %d", sum, countR, countC);
    }
}