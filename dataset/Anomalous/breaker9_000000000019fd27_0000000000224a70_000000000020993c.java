import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    static StringBuilder answer = new StringBuilder();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int queryCount = in.nextInt();

        for (int i = 0; i < queryCount; i++) {
            int N = in.nextInt();
            int[][] matrix = new int[N][N];
            int trace = 0;
            int rowDuplicates = 0;

            for (int row = 0; row < N; row++) {
                Set<Integer> rowSet = new HashSet<>();
                for (int col = 0; col < N; col++) {
                    matrix[row][col] = in.nextInt();
                    if (row == col) {
                        trace += matrix[row][col];
                    }
                    rowSet.add(matrix[row][col]);
                }
                if (rowSet.size() != N) {
                    rowDuplicates++;
                }
            }

            int colDuplicates = findColDuplicates(matrix, N);
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

        for (int col = 0; col < size; col++) {
            Set<Integer> colSet = new HashSet<>();
            for (int row = 0; row < size; row++) {
                colSet.add(matrix[row][col]);
            }
            if (colSet.size() != size) {
                colDuplicates++;
            }
        }

        return colDuplicates;
    }
}