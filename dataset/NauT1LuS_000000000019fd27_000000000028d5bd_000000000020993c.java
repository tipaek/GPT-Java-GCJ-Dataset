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
            for (int j = 1; j <= n; j++) {
                summ ^= j;
            }
            int[] colSumm = new int[n];

            for (int j = 0; j < n; j++) {
                int rowSumm = 0;
                for (int k = 0; k < n; k++) {
                    int cur = in.nextInt();
                    rowSumm ^= cur;
                    if(j == k) trace += cur;
                    colSumm[k] ^= cur;
                }
                if(rowSumm != summ) rows++;
            }
            for (int j = 0; j < n; j++) {
                if(colSumm[j] != summ) cols++;
            }
            System.out.printf("Case #%d: %d %d %d", i, trace, rows, cols);
            System.out.println();

        }

    }
    
}