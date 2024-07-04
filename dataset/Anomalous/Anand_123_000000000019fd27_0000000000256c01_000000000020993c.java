import java.util.*;

class CodeJam {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int t = 0; t < testCases; t++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];
            
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }
            
            int diagonalSum = calculateDiagonalSum(matrix, n);
            int duplicateRows = countDuplicateRows(matrix, n);
            int duplicateCols = countDuplicateCols(matrix, n);
            
            System.out.println(diagonalSum + " " + duplicateRows + " " + duplicateCols);
        }
        
        scanner.close();
    }
    
    private static int calculateDiagonalSum(int[][] matrix, int n) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += matrix[i][i];
        }
        return sum;
    }
    
    private static int countDuplicateRows(int[][] matrix, int n) {
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (containsDuplicate(matrix[i])) {
                count++;
            }
        }
        return count;
    }
    
    private static int countDuplicateCols(int[][] matrix, int n) {
        int count = 0;
        for (int i = 0; i < n; i++) {
            int[] colArray = new int[n];
            for (int j = 0; j < n; j++) {
                colArray[j] = matrix[j][i];
            }
            if (containsDuplicate(colArray)) {
                count++;
            }
        }
        return count;
    }
    
    private static boolean containsDuplicate(int[] array) {
        Set<Integer> set = new HashSet<>();
        for (int value : array) {
            if (!set.add(value)) {
                return true;
            }
        }
        return false;
    }
}