import java.util.HashSet;
import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int i = 0; i < testCases; i++) {
            int N = scanner.nextInt();
            int[][] matrix = new int[N][N];
            
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {
                    matrix[r][c] = scanner.nextInt();
                }
            }
            
            int diagonalSum = calculateDiagonalSum(matrix, N);
            int rowDuplicates = countDuplicates(matrix, N, true);
            int colDuplicates = countDuplicates(matrix, N, false);
            
            System.out.println("Case #" + (i + 1) + ": " + diagonalSum + " " + rowDuplicates + " " + colDuplicates);
        }
        
        scanner.close();
    }

    private static int calculateDiagonalSum(int[][] matrix, int N) {
        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum += matrix[i][i];
        }
        return sum;
    }

    private static int countDuplicates(int[][] matrix, int N, boolean checkRows) {
        int duplicates = 0;
        
        for (int i = 0; i < N; i++) {
            HashSet<Integer> set = new HashSet<>();
            boolean hasDuplicate = false;
            
            for (int j = 0; j < N; j++) {
                int value = checkRows ? matrix[i][j] : matrix[j][i];
                
                if (!set.add(value)) {
                    hasDuplicate = true;
                }
            }
            
            if (hasDuplicate) {
                duplicates++;
            }
        }
        
        return duplicates;
    }
}