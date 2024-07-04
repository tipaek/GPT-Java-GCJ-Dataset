import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int T = scanner.nextInt();
            for (int t = 1; t <= T; t++) {
                int N = scanner.nextInt();
                int[][] matrix = new int[N][N];
                int trace = 0;
                
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < N; j++) {
                        matrix[i][j] = scanner.nextInt();
                        if (i == j) {
                            trace += matrix[i][j];
                        }
                    }
                }
                
                int rowCount = countDuplicates(matrix, N, true);
                int colCount = countDuplicates(matrix, N, false);
                
                System.out.println("Case #" + t + ": " + trace + " " + rowCount + " " + colCount);
            }
        }
    }

    private static int countDuplicates(int[][] matrix, int n, boolean isRow) {
        Set<Integer> set = new HashSet<>();
        int duplicateCount = 0;
        
        for (int i = 0; i < n; i++) {
            set.clear();
            for (int j = 0; j < n; j++) {
                int value = isRow ? matrix[i][j] : matrix[j][i];
                if (set.contains(value)) {
                    duplicateCount++;
                    break;
                }
                set.add(value);
            }
        }
        
        return duplicateCount;
    }
}