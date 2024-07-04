
import java.sql.SQLOutput;
import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            int[][] a = new int[n][n];
            int sum = 0;
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    a[j][k] = in.nextInt();
                    if (j == k) {
                        sum += a[j][k];
                    }
                }
            }
            System.out.println("Case #" + i + ": " + sum +" "+countRow(a,n)+" "+countCol(a,n));
        }
    }

    private static int countRow(int a[][], int size) {

        int count = 0;
        for (int i = 0; i < size; i++) {
            long distinct = Arrays.stream(a[i]).distinct().count();
            if (size != distinct) {
                count++;
            }
        }
        return count;
    }

    private static int countCol(int a[][], int size) {

        int count = 0;

        for (int j = 0; j < size; j++) {
            ArrayList<Integer> col=new ArrayList<>();
            for (int i = 0; i < size; i++) {
                col.add(a[i][j]);
            }
            long distinct = col.stream().distinct().count();
            if (size != distinct) {
                count++;
            }
        }
        return count;
    }

}
