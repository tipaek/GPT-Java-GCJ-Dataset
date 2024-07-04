import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int cases = in.nextInt();

        // Solve each test case
        for (int i=1; i<cases+1; i++) {
            solve(i, in);
        }
    }

    public static void solve(int i, Scanner in) {
        int n = in.nextInt();

        int arr[][] = new int[n][n];
        for (int j=0; j<n; j++) {
            for (int k=0; k<n; k++) {
                arr[j][k] = in.nextInt();
            }
        }

        int repeat_rows = 0, repeat_col = 0, trace = 0;

        for (int j=0; j<n; j++) {
            trace += arr[j][j];

            ArrayList<Integer> row = new ArrayList<Integer>();
            for (int k=0; k<n; k++) {
                if (row.contains(arr[j][k])) {
                    repeat_rows++;
                    break;
                }
                row.add(arr[j][k]);
            }

            ArrayList<Integer> col = new ArrayList<Integer>();
            for (int m=0; m<n; m++) {
                if (col.contains(arr[m][j])) {
                    repeat_col++;
                    break;
                }
                col.add(arr[m][j]);
            }
        }

        System.out.println("Case #:" + i + " " + trace + " " + repeat_rows + " " + repeat_col);
    }
}