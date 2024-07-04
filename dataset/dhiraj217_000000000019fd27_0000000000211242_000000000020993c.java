import java.util.*;

public class Solution {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        int currentT = 1;
        while(currentT <= T) {
            int n = sc.nextInt();
            int matrix[][] = new int[n][n];

            for (int i=0; i<n; i++) {
                for (int j = 0; j < n; j++) {
                    int nextInt = sc.nextInt();
                    matrix[i][j] = nextInt;
                }
            }
            int trace = 0;
            for (int i=0; i<n; i++) {
                trace += matrix[i][i];
            }

            int numRows = 0;
            for (int i=0; i<n; i++) {
                Set<Integer> uniqueElements = new HashSet<>();
                for (int j = 0; j < n; j++) {
                    uniqueElements.add(matrix[i][j]);
                }
                if (uniqueElements.size() != n) {
                    numRows++;
                }
            }

            int numColumns = 0;
            for (int i=0; i<n; i++) {
                Set<Integer> uniqueElements = new HashSet<>();
                for (int j = 0; j < n; j++) {
                    uniqueElements.add(matrix[j][i]);
                }
                if (uniqueElements.size() != n) {
                    numColumns++;
                }
            }

            System.out.println("Case #" + currentT++ + ": " + trace + " " + numRows + " " + numColumns);
        }
    }
}
