import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];
            
            // Read the matrix
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }
            
            int trace = calculateTrace(matrix, n);
            int rowDuplicates = countRowDuplicates(matrix, n);
            int columnDuplicates = countColumnDuplicates(matrix, n);
            
            System.out.printf("Case #%d: %d %d %d%n", caseNumber, trace, rowDuplicates, columnDuplicates);
        }
    }

    private static int calculateTrace(int[][] matrix, int n) {
        int trace = 0;
        for (int i = 0; i < n; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    private static int countRowDuplicates(int[][] matrix, int n) {
        int rowDuplicates = 0;
        for (int i = 0; i < n; i++) {
            Set<Integer> uniqueElements = new HashSet<>();
            for (int j = 0; j < n; j++) {
                if (!uniqueElements.add(matrix[i][j])) {
                    rowDuplicates++;
                    break;
                }
            }
        }
        return rowDuplicates;
    }

    private static int countColumnDuplicates(int[][] matrix, int n) {
        int columnDuplicates = 0;
        for (int j = 0; j < n; j++) {
            Set<Integer> uniqueElements = new HashSet<>();
            for (int i = 0; i < n; i++) {
                if (!uniqueElements.add(matrix[i][j])) {
                    columnDuplicates++;
                    break;
                }
            }
        }
        return columnDuplicates;
    }
}