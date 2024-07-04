import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    static int[] check(int[][] m) {
        
        int trace = 0;
        for (int i = 0; i < m.length; i++) {
            trace += m[i][i];
        }
        int repeatRow = 0;
        for (int i = 0; i < m.length; i++) {
            int[] row = new int[m.length];      
            for (int j = 0; j < m.length; j++) {
                int val = m[i][j];
                row[val - 1]++;
            }
            for (int j = 0; j < row.length; j++) {
                if (row[j] > 1) {
                    repeatRow++;
                    break;
                }
            }
        }
        
        int repeatCol = 0;
        for (int i = 0; i < m.length; i++) {
            int[] col = new int[m.length];
            for (int j = 0; j < m.length; j++) {
                int val = m[j][i];
                col[val - 1]++;
            }
            for (int j = 0; j < col.length; j++) {
                if (col[j] > 1) {
                    repeatCol++;
                    break;
                }
            }
        }
        
        return new int[]{trace,repeatRow,repeatCol};
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int ntests = in.nextInt();
        for (int i = 0; i < ntests; i++) {
            int msize = in.nextInt();
            int[][] matrix = new int[msize][msize];
            for (int j = 0; j < msize; j++) {
                for (int k = 0; k < msize; k++) {
                    matrix[j][k] = in.nextInt();
                }
            }
            int[] answer = check(matrix);
            System.out.printf("Case #%d: %d %d %d\n",i+1,answer[0],answer[1],answer[2]);
        }
    }

}