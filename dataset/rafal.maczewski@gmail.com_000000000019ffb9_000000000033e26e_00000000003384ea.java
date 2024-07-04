import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            solve(i, in);
        }
    }



    private static void solve(int caseNr, Scanner in) {
        int l = in.nextInt();
        int r = in.nextInt();

        int j = 0;
        while (true) {
            if (j+1 > l && j+1 > r) break;
            j++;
            if (l >= r) {
                l -= j;
            } else {
                r -= j;
            }
        }
       System.out.println("Case #" + caseNr + ": " + j + " " + l + " " + r);

    }

}