import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int k = 1; k <= t; ++k) {
            int n = in.nextInt();
            int[][] arr = new int[n][n];

            int rowRep = 0, colRep = 0, trace = 0;
            int[] repeatedRow = new int[n];
            int[] repeatedCol = new int[n];
            for (int i = 0; i < n; i++) {
                HashSet<Integer> row = new HashSet<>();
                for (int j = 0; j < n; j++) {
                    arr[i][j] = in.nextInt();
                    if (row.contains(arr[i][j])) repeatedRow[i] = 1;
                    else row.add(arr[i][j]);
                    if (i == j) trace += arr[i][j];
                }
            }

            //Checking for column
            for (int i = 0; i < n; i++) {
                HashSet<Integer> col = new HashSet<>();
                for(int j = 0; j < n; j++) {
                    if(col.contains(arr[j][i])) repeatedCol[i] = 1;
                    col.add(arr[j][i]);
                }
            }

            for(int i = 0; i < n; i++) {
                if(repeatedCol[i] == 1) colRep++;
                if(repeatedRow[i] == 1) rowRep++;
            }

            System.out.println("Case #" + k + ": " + trace + " " + rowRep + " " + colRep);
        }
    }
}