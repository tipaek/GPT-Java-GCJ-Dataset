import java.util.HashSet;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        for (int caseNumber = 1; caseNumber <= T; caseNumber++) {
            int N = sc.nextInt();
            int[][] arr = new int[N][N];
            int trace = 0, rowDuplicates = 0, colDuplicates = 0;

            // Read the matrix and calculate the trace
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    arr[i][j] = sc.nextInt();
                    if (i == j) {
                        trace += arr[i][j];
                    }
                }
            }

            // Check for duplicate values in rows
            for (int i = 0; i < N; i++) {
                HashSet<Integer> set = new HashSet<>();
                boolean hasDuplicate = false;
                for (int j = 0; j < N; j++) {
                    if (!set.add(arr[i][j])) {
                        hasDuplicate = true;
                        break;
                    }
                }
                if (hasDuplicate) {
                    rowDuplicates++;
                }
            }

            // Check for duplicate values in columns
            for (int i = 0; i < N; i++) {
                HashSet<Integer> set = new HashSet<>();
                boolean hasDuplicate = false;
                for (int j = 0; j < N; j++) {
                    if (!set.add(arr[j][i])) {
                        hasDuplicate = true;
                        break;
                    }
                }
                if (hasDuplicate) {
                    colDuplicates++;
                }
            }

            System.out.println("Case #" + caseNumber + ": " + trace + " " + rowDuplicates + " " + colDuplicates);
        }
    }
}