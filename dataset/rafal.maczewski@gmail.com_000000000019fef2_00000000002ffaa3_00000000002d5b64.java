import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            solve(i, in);
        }
    }

    static StringBuffer response;

    private static void solve(int caseNr, Scanner in) {
        int r = in.nextInt();
        int s = in.nextInt();

        response = new StringBuffer();

        int result = solveCase(r, s);
        System.out.println("Case #1: " + result);
        System.out.print(response);


    }

    private static int solveCase(int r, int s) {
        for (int i = s - 1; i > 0; i--) {
            int rowsMoved = s - i - 1;

            response.append((r * i + (rowsMoved * (r-1)))  + " " + (r - 1) + "\n");
        }

        if (r - 1 > 1) {
            return s - 1 + solveCase(r - 1, s);
        } else {
            return s - 1;
        }
    }
}