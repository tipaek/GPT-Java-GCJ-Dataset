import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        int[][][] tests = new int[t][][];

        for (int k = 0; k < t; k++) { //add one to the test number
            int n = in.nextInt();
            tests[k] = new int[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    tests[k][i][j] = in.nextInt();
                }
            }

            int trace = 0;
            for (int i = 0; i < n; i++) {
                trace += tests[k][i][i];
            }

            int numRows = 0;
            for (int i = 0; i < n; i++) {
                boolean duplicate = false;
                ArrayList<Integer> pNums = new ArrayList<Integer>();

                for (int j = 0; j < n; j++) {
                    if (pNums.contains(tests[k][i][j])) duplicate = true;
                    else pNums.add(tests[k][i][j]);
                }

                if(duplicate) numRows++;
            }

            int numCols = 0;
            for (int j = 0; j < n; j++) {
                boolean duplicate = false;
                ArrayList<Integer> pNums = new ArrayList<Integer>();

                for (int i = 0; i < n; i++) {
                    if (pNums.contains(tests[k][i][j])) duplicate = true;
                    else pNums.add(tests[k][i][j]);
                }

                if(duplicate) numCols++;
            }

            System.out.println("Case #" + (k+1) + ": " + trace + " " + numRows + " " + numCols);
        }
    }
}