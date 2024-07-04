import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            int sum = n*(n+1)*(2*n+1)/6;

            int rowsNot = 0;
            int colsNot = 0;
            int trace = 0;

            int sumRow = 0;
            int sumCol[] = new int[n];
            int a_jk = 0;

            for(int j = 0; j < n; j++) {
                sumRow = 0;
                for(int k = 0; k < n; k++) {
                    a_jk = in.nextInt();
                    if(j == k) {
                        trace += a_jk;
                    }
                    sumRow += a_jk*a_jk;
                    sumCol[k] += a_jk*a_jk;

                    if(j == n-1) {
                        if(sumCol[k] != sum) {
                            colsNot++;
                        }
                    }
                }
                if(sumRow != sum) {
                    rowsNot++;

                }
            }

            System.out.println("Case #" + i + ": " + trace + " " + rowsNot + " " + colsNot);
        }
    }
}