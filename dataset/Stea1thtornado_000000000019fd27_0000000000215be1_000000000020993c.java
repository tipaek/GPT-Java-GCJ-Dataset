import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        int k = 0;
        int r = 0;
        int c = 0;
        Scanner scan = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = scan.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int a = 1; a <= t; ++a) {
            int n = scan.nextInt(); //size of matrix
            int arr[][] = new int[n][n]; //create array of NxN dims
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    arr[i][j] = scan.nextInt(); //inputs Mi,j into array
                }
            }
            
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (i == j) {
                        k += arr[i][j];
                    }
                }
            }
            
            for (int i = 0; i < n; i++) {
                int flag = 0;
                for (int ja = 0; ja < n - 1; ja++) {
                    for (int jb = ja + 1; jb < n; jb++) {
                        if ((flag == 0) && (arr[i][ja] == arr[i][jb])) {
                            flag = 1;
                            r++;
                        }
                    }
                }
            }
            
            for (int j = 0; j < n; j++) {
                int flag = 0;
                for (int ia = 0; ia < n - 1; ia++) {
                    for (int ib = ia + 1; ib < n; ib++) {
                        if ((flag == 0) && (arr[ia][j] == arr[ib][j])) {
                            flag = 1;
                            c++;
                        }
                    }
                }    
            }
            
        System.out.println("Case #" + a + ": " + (k) + " " + (r)+ " " + (c));
        }
    }
}