package coding_challenge;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class VestigiumTrace {
    static StringBuilder answer = new StringBuilder();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int query = in.nextInt();

        for (int i = 0; i < query; i++) {
            int N = in.nextInt();
            int[][] matrix = new int[N][N];
            int trace = 0;
            int rowDuplicates = 0;
            int colDuplicates = 0;

            for (int j = 0; j < N; j++) {
                Set<Integer> rowSet = new HashSet<>();
                for (int k = 0; k < N; k++) {
                    matrix[j][k] = in.nextInt();
                    if (j == k) {
                        trace += matrix[j][k];
                    }
                    rowSet.add(matrix[j][k]);
                }
                if (rowSet.size() != N) {
                    rowDuplicates++;
                }
            }

            colDuplicates = findColDuplicates(matrix, N);
            answer.append("Case #").append(i + 1).append(": ")
                   .append(trace).append(" ")
                   .append(rowDuplicates).append(" ")
                   .append(colDuplicates).append("\n");
        }

        System.out.print(answer);
        in.close();
    }

    private static int findColDuplicates(int[][] matrix, int size) {
        int colDuplicates = 0;

        for (int j = 0; j < size; j++) {
            Set<Integer> colSet = new HashSet<>();
            for (int k = 0; k < size; k++) {
                colSet.add(matrix[k][j]);
            }
            if (colSet.size() != size) {
                colDuplicates++;
            }
        }

        return colDuplicates;
    }
}