import java.util.HashSet;
import java.util.Scanner;

public class Code {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        
        while (testCases-- > 0) {
            int n = sc.nextInt();
            int[][] matrix = new int[n][n];
            int diagonalSum = 0;
            
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = sc.nextInt();
                    if (i == j) {
                        diagonalSum += matrix[i][j];
                    }
                }
            }
            
            int duplicateRows = countDuplicateRows(matrix, n);
            int duplicateCols = countDuplicateCols(matrix, n);
            
            System.out.println(diagonalSum + " " + duplicateRows + " " + duplicateCols);
        }
        
        sc.close();
    }

    private static int countDuplicateRows(int[][] matrix, int n) {
        int duplicateRows = 0;
        
        for (int i = 0; i < n; i++) {
            HashSet<Integer> uniqueElements = new HashSet<>();
            for (int j = 0; j < n; j++) {
                if (!uniqueElements.add(matrix[i][j])) {
                    duplicateRows++;
                    break;
                }
            }
        }
        
        return duplicateRows;
    }

    private static int countDuplicateCols(int[][] matrix, int n) {
        int duplicateCols = 0;
        
        for (int i = 0; i < n; i++) {
            HashSet<Integer> uniqueElements = new HashSet<>();
            for (int j = 0; j < n; j++) {
                if (!uniqueElements.add(matrix[j][i])) {
                    duplicateCols++;
                    break;
                }
            }
        }
        
        return duplicateCols;
    }
}