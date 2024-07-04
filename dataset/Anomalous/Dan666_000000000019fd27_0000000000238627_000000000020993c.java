import java.util.*;

public class Main {
    
    public static void ref(int[][] ar, int n, int caseNumber) {
        int trace = 0, rowCount = 0, colCount = 0;
        int[] rowFrequency = new int[10];
        int[] colFrequency = new int[10];

        for (int i = 0; i < n; i++) {
            Arrays.fill(rowFrequency, 0);
            Arrays.fill(colFrequency, 0);
            boolean rowHasDuplicate = false;
            boolean colHasDuplicate = false;

            for (int j = 0; j < n; j++) {
                // Calculate trace
                if (i == j) {
                    trace += ar[i][j];
                }

                // Check row duplicates
                rowFrequency[ar[i][j]]++;
                if (rowFrequency[ar[i][j]] > 1) {
                    rowHasDuplicate = true;
                }

                // Check column duplicates
                colFrequency[ar[j][i]]++;
                if (colFrequency[ar[j][i]] > 1) {
                    colHasDuplicate = true;
                }
            }

            if (rowHasDuplicate) {
                rowCount++;
            }
            if (colHasDuplicate) {
                colCount++;
            }
        }

        System.out.printf("Case #%d: %d %d %d%n", caseNumber, trace, rowCount, colCount);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        for (int i = 1; i <= t; i++) {
            int n = sc.nextInt();
            int[][] arr = new int[n][n];
            
            for (int row = 0; row < n; row++) {
                for (int col = 0; col < n; col++) {
                    arr[row][col] = sc.nextInt();
                }
            }
            
            ref(arr, n, i);
        }
        
        sc.close();
    }
}