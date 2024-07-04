import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    public static void vestigium(int testCase, int[][] a){
        int rows=0, cols=0, trace=0;
        final int SUM = (a.length*(a.length + 1))/2;
        for(int i=0; i<a.length; i++){
            int rowSum = 0, colSum = 0;
            for(int j=0; j<a.length; j++){
                if(i == j){
                    trace += a[i][j];
                }
                rowSum += a[i][j];
                colSum += a[j][i];
            }
            if(rowSum != SUM){
                rows += 1;
            }
            if(colSum != SUM){
                cols += 1;
            }
        }
        System.out.println("Case #" + (testCase+1) + ": " + trace + " " + rows + " " + cols);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[][] q = new int[n][n];

            for (int i = 0; i < n; i++) {
                String[] qItems = scanner.nextLine().split(" ");
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
                for (int j = 0; j < n; j++) {
                    int qItem = Integer.parseInt(qItems[j]);
                    q[i][j] = qItem;
                }
            }

            vestigium(tItr, q);
        }

        scanner.close();
    }
}
