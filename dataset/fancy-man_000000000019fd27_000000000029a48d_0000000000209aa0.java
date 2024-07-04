

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    private static boolean solve (int[][] matrix, int n, int t)
    {
        matrix[0][0] =1;
        int val = n;
        for (int i=1; i<n; i++) {
            matrix[0][i] = val;
            val--;
        }

        for (int i=1; i<n; i++)
        {
            for (int j=1; j<n; j++)
                matrix[i][j] = matrix[i-1][j-1];
            matrix[i][0] = matrix[i-1][n-1];
        }

        if (t == n) return true;

        int trace = n;
        int diff = Math.abs(t - trace);


        while (diff > 0) {


            int c1 = 0, c2 = 0;

            for (int i = 0; i < n; i++)
                for (int j = i+1; j < n; j++) {
                    int nTrace = trace - matrix[i][i] - matrix[j][j] + matrix[i][j] + matrix[j][i];
                    int nDiff = Math.abs(t - nTrace);
                    if (nDiff < diff) {
                        c1 = i;
                        c2 = j;
                        diff = nDiff;
                    }
                }

            if (c1 == 0 && c2 == 0)
                return false;

            //swap
            for (int i=0; i<n; i++)
            {
                int tmp = matrix[i][c1];
                matrix[i][c1] = matrix[i][c2];
                matrix[i][c2] = tmp;
            }

            // ntrace
            trace = 0;
            for (int i=0; i<n; i++)
                trace += matrix[i][i];
        }
        return true;
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        in.nextLine();
        for (int c = 1; c <= t; ++c) {

            String[] tokens = in.nextLine().split(" ");

            int n = Integer.parseInt(tokens[0]);
            int k = Integer.parseInt(tokens[1]);

            int[][] matrix = new int[n][n];

            boolean isok = solve(matrix, n, k);
            if (isok)
            {
                System.out.println("Case #" + c + ": POSSIBLE");

                for (int i=0; i<n; i++)
                {
                    for (int j=0; j<n-1;j++)
                        System.out.print(matrix[i][j] + " ");
                    System.out.println(matrix[i][n-1]);
                }
            }
            else
                System.out.println("Case #" + c + ": IMPOSSIBLE");

        }
    }

}
