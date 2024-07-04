import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        int k = 0;
        int r = 0;
        int c = 0;
      	//int t = 1;
      	//int n = 3;
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
      	//Scanner in = new Scanner(System.in);
      	//System.out.println("Enter t: ");
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int a = 1; a <= t; ++a) {
            //System.out.println("Enter n: ");
            int n = in.nextInt(); //size of matrix
            int arr[][] = new int[n][n]; //create array of NxN dims
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    //System.out.println("Enter m: ");
                    arr[i][j] = in.nextInt(); //inputs Mi,j into array
                }
            }
            
            /*
            int[][] arr = {
                {2, 1, 3},
                {1, 3, 2},
                {1, 2, 3}
                };*/
                
            for (int i = 0; i < n; i++) {//calculate trace
                for (int j = 0; j < n; j++) {
                    if (i == j) {
                        k += arr[i][j];
                    }
                }
            }
            
            for (int i = 0; i < n; i++) {//check for repeats in rows
                int flag = 0;
                for (int ja = 0; ja < n - 1; ja++) {
                    for (int jb = ja + 1; jb < n; jb++) {
                        if ((flag == 0) && (arr[i][ja] == arr[i][jb])) {
                            flag = 1; //so r only incremented max of once per row
                            r++;
                        }
                    }
                }
            }
            
            for (int j = 0; j < n; j++) {//check for repeats in cols
                int flag = 0;
                for (int ia = 0; ia < n - 1; ia++) {
                    for (int ib = ia + 1; ib < n; ib++) {
                        if ((flag == 0) && (arr[ia][j] == arr[ib][j])) {
                            flag = 1; //so c only incremented max of once per column
                            c++;
                        }
                    }
                }    
            }
            
        System.out.println("Case #" + a + ": " + (k) + " " + (r)+ " " + (c));
        }
    }
}