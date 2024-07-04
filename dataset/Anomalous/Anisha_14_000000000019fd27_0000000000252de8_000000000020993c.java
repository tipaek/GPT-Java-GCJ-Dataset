import java.util.Scanner;

class Ques {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter number of test cases: ");
        int testCases = scanner.nextInt();
        
        while (testCases > 0) {
            System.out.print("Enter the size of the square matrix: ");
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];
            
            System.out.println("Enter the matrix elements:");
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }
            
            int diagonalSum = calculateDiagonalSum(matrix, n);
            System.out.print(diagonalSum + " ");
            
            String rowCounts = calculateCounts(matrix, n, true);
            String colCounts = calculateCounts(matrix, n, false);
            
            int maxRowCount = getMaxCount(rowCounts);
            int maxColCount = getMaxCount(colCounts);
            
            System.out.print(maxRowCount + " ");
            System.out.print(maxColCount + " ");
            System.out.println();
            
            testCases--;
        }
        
        scanner.close();
    }
    
    private static int calculateDiagonalSum(int[][] matrix, int size) {
        int sum = 0;
        for (int i = 0; i < size; i++) {
            sum += matrix[i][i];
        }
        return sum;
    }
    
    private static String calculateCounts(int[][] matrix, int size, boolean isRow) {
        StringBuilder counts = new StringBuilder();
        
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                int value = matrix[i][j];
                int count = 0;
                
                for (int k = 0; k < size; k++) {
                    if (isRow) {
                        if (value == matrix[i][k]) count++;
                    } else {
                        if (value == matrix[k][j]) count++;
                    }
                }
                
                counts.append(count);
            }
        }
        
        return counts.toString();
    }
    
    private static int getMaxCount(String counts) {
        int maxCount = Integer.MIN_VALUE;
        
        for (char ch : counts.toCharArray()) {
            int count = Character.getNumericValue(ch);
            if (count > maxCount) {
                maxCount = count;
            }
        }
        
        return maxCount;
    }
}