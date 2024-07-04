import java.util.BitSet;
import java.util.Scanner;

class Vest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = Integer.parseInt(scanner.nextLine());
        
        while (testCases-- > 0) {
            int n = Integer.parseInt(scanner.nextLine());
            int[][] matrix = new int[n][n];
            
            for (int i = 0; i < n; i++) {
                String[] numbers = scanner.nextLine().split("\\s+");
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = Integer.parseInt(numbers[j]);
                }
            }
            
            solve(n, matrix);
        }
        
        scanner.close();
    }

    public static void solve(int n, int[][] matrix) {
        BitSet[] rows = new BitSet[n];
        BitSet[] cols = new BitSet[n];
        
        for (int i = 0; i < n; i++) {
            rows[i] = new BitSet(n + 1);
            cols[i] = new BitSet(n + 1);
        }
        
        int diagonalSum = 0;
        int duplicateRows = 0;
        int duplicateCols = 0;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int num = matrix[i][j];
                if (i == j) {
                    diagonalSum += num;
                }
                rows[i].set(num);
                cols[j].set(num);
            }
        }
        
        for (BitSet row : rows) {
            if (row.cardinality() != n) {
                duplicateRows++;
            }
        }
        
        for (BitSet col : cols) {
            if (col.cardinality() != n) {
                duplicateCols++;
            }
        }
        
        System.out.println(diagonalSum + " " + duplicateRows + " " + duplicateCols);
    }
}