import java.util.*;

public class Solution{
    

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int cases = in.nextInt();
        for (int i = 1; i <= cases; i++) {
            int n = in.nextInt();
            int trace = 0;
            int cols = 0;
            int rows = 0;
            int summ = 0;


            int[][] matrix = new int[n][n+1];

            for (int j = 0; j < n; j++) {
                int[] rowBuff = new int[n+1];
                boolean rowDuplicates = false;
                for (int k = 0; k < n; k++) {
                    int cur = in.nextInt();
                    if(j == k) trace += cur;
                    if(rowBuff[cur] != 0) rowDuplicates = true;
                    rowBuff[cur] = cur;
                    if(matrix[k][cur] != 0) matrix[k][0] = -1;
                    matrix[k][cur] = cur;
                }
                if(rowDuplicates) rows++;
            }

            for (int j = 0; j < n; j++) {
                if(matrix[j][0] == -1) cols++;
            }
            System.out.printf("Case #%d: %d %d %d", i, trace, rows, cols);
            System.out.println();

        }

    }
    
}