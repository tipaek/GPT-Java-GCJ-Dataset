import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            while (scanner.hasNext()) {
                int T = scanner.nextInt();
                for (int i = 0; i < T; i++) {
                    int N = scanner.nextInt();
                    int[][] matrix = new int[N][N];
                    int traceSum = 0;
                    int duplicateRows = 0;
                    Set<Integer> set = new HashSet<>();

                    for (int row = 0; row < N; row++) {
                        set.clear();
                        boolean rowHasDuplicate = false;
                        for (int col = 0; col < N; col++) {
                            matrix[row][col] = scanner.nextInt();
                            if (!rowHasDuplicate && set.contains(matrix[row][col])) {
                                rowHasDuplicate = true;
                                duplicateRows++;
                            }
                            set.add(matrix[row][col]);
                            if (row == col) {
                                traceSum += matrix[row][col];
                            }
                        }
                    }

                    int duplicateCols = 0;
                    for (int col = 0; col < N; col++) {
                        set.clear();
                        boolean colHasDuplicate = false;
                        for (int row = 0; row < N; row++) {
                            if (!colHasDuplicate && set.contains(matrix[row][col])) {
                                colHasDuplicate = true;
                                duplicateCols++;
                            }
                            set.add(matrix[row][col]);
                        }
                    }

                    System.out.printf("Case #%d: %d %d %d%n", (i + 1), traceSum, duplicateRows, duplicateCols);
                }
            }
        }
    }
}