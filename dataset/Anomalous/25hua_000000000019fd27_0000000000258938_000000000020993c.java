import java.util.*;
import java.io.*;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int caseCount = sc.nextInt();
        int[][] matrix = new int[100][100];
        int[] exists = new int[101];

        for (int index = 1; index <= caseCount; index++) {
            int k = 0, r = 0, c = 0;
            int n = sc.nextInt();
            
            // Read matrix and calculate trace
            for (int i = 0; i < n; i++) {
                Arrays.fill(exists, 0);
                boolean rowDuplicate = false;
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = sc.nextInt();
                    if (!rowDuplicate && exists[matrix[i][j]] == 1) {
                        r++;
                        rowDuplicate = true;
                    }
                    exists[matrix[i][j]] = 1;
                    if (i == j) {
                        k += matrix[i][j];
                    }
                }
            }

            // Check for column duplicates
            for (int j = 0; j < n; j++) {
                Arrays.fill(exists, 0);
                for (int i = 0; i < n; i++) {
                    if (exists[matrix[i][j]] == 1) {
                        c++;
                        break;
                    }
                    exists[matrix[i][j]] = 1;
                }
            }

            System.out.printf("Case #%d: %d %d %d\n", index, k, r, c);
        }
        sc.close();
    }
}