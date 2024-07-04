import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int t = 1; t <= testCases; t++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];
            int[][] transposedMatrix = new int[n][n];
            int trace = 0, rowDuplicates = 0, colDuplicates = 0;
            
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                    transposedMatrix[j][i] = matrix[i][j];
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                }
                if (!isUnique(matrix[i])) {
                    rowDuplicates++;
                }
            }
            
            for (int i = 0; i < n; i++) {
                if (!isUnique(transposedMatrix[i])) {
                    colDuplicates++;
                }
            }
            
            System.out.printf("Case #%d: %d %d %d%n", t, trace, rowDuplicates, colDuplicates);
        }
        
        scanner.close();
    }
    
    private static boolean isUnique(int[] array) {
        Set<Integer> set = new HashSet<>();
        for (int num : array) {
            if (!set.add(num)) {
                return false;
            }
        }
        return true;
    }
}