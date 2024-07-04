import java.util.*;
import java.io.*;

public class Solution {


    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCount = in.nextInt();
        for (int t = 1; t <= testCount; ++t) {
            int n = in.nextInt();
            int[][] caseInput = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    caseInput[i][j] = in.nextInt();
                }
            }
            int[] res = calculate(n, caseInput);
            System.out.println("Case #" + t + ": " + res[0] + " " + res[1] + " " + res[2]);
        }
    }

    private static int[] calculate(int n, int[][] input)
    {
        int k = 0, r = 0, c = 0;

        // Calculate trace (diagonal sum)
        for (int i = 0; i < n; i++) {
            k += input[i][i];
        }

        //Duplicates in rows
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int elPos = Math.abs(input[i][j]) - 1;
                if (input[i][elPos] > 0) { // New element
                    // Mark element as visited
                    input[i][elPos] = -input[i][elPos];
                } else { // Duplicate detected
                    r++;
                    break;
                }
            }
            //Revert changes
            for (int j = 0; j < n; j++) {
                input[i][j] = Math.abs(input[i][j]);
            }
        }

        //Duplicates in cols
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int elPos = Math.abs(input[j][i]) - 1;
                if (input[elPos][i] > 0) { // New element
                    // Mark element as visited
                    input[elPos][i] = -input[elPos][i];
                } else { // Duplicate detected
                    c++;
                    break;
                }
            }
        }

        return new int[]{
            k,
            r,
            c
        };
    }
}
