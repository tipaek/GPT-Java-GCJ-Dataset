import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int testCase = 1; testCase <= testCases; testCase++) {
            int diagonalSum = 0;
            int rowDuplicates = 0;
            int columnDuplicates = 0;
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];
            
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                    if (i == j) {
                        diagonalSum += matrix[i][j];
                    }
                }
            }
            
            // Check for duplicate elements in rows
            for (int i = 0; i < n; i++) {
                Set<Integer> rowSet = new HashSet<>();
                for (int j = 0; j < n; j++) {
                    if (!rowSet.add(matrix[i][j])) {
                        rowDuplicates++;
                        break;
                    }
                }
            }
            
            // Check for duplicate elements in columns
            for (int j = 0; j < n; j++) {
                Set<Integer> columnSet = new HashSet<>();
                for (int i = 0; i < n; i++) {
                    if (!columnSet.add(matrix[i][j])) {
                        columnDuplicates++;
                        break;
                    }
                }
            }
            
            System.out.println("Case #" + testCase + ": " + diagonalSum + " " + rowDuplicates + " " + columnDuplicates);
        }
        
        scanner.close();
    }
}