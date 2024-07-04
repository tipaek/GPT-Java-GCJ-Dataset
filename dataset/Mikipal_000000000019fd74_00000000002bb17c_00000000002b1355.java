
import java.util.*;
import java.io.*;

public class Solution {

    static int casec = 1;

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int r = in.nextInt();
            int c = in.nextInt();

            int sq[][] = new int[r][c];
            for (int j = 0; j < r; j++) {
                for (int k = 0; k < c; k++) {
                    sq[j][k] = in.nextInt();
                }
            }

            Solve(sq);

        }
    }

    public static void Solve(int[][] s) {
        int el = 0, rint = 0, cint = 0;
        int round[][] = new int[s.length][s[0].length];
        int orig[][] = new int[s.length][s[0].length];
        for (int i = 0; i < s.length; i++) {
            for (int j = 0; j < s[i].length; j++) {
                round[i][j] = s[i][j];
                orig[i][j] = s[i][j];
            }
        }
        while (el != -1) {
            el = -1;
            rint = 0;
            for (int i = 0; i < orig.length; i++) {
                for (int j = 0; j < orig[i].length; j++) {
                    if (orig[i][j] != -1) {
                        rint += orig[i][j];
                        float neig = calcNeigh(orig, i, j);
                        if (neig != 0 && neig > orig[i][j]) {
                            el++;
                            round[i][j] = -1;
                        }
                    }
                }
            }

            for (int i = 0; i < round.length; i++) {
                for (int j = 0; j < round[i].length; j++) {
                    orig[i][j] = round[i][j];
                }
            }

            cint += rint;
        }

        System.out.println("Case #" + casec + ": " + cint);
        casec++;

    }

    public static float calcNeigh(int[][] s, int r, int c) {
        float res = 0, count = 0;

        try {
            for (int i = r - 1; i >= 0; i--) {
                if (s[i][c] != -1) {
                    res += s[i][c];
                    count++;
                    break;
                }
            }
        } catch (Exception e) {

        }

        try {
            for (int i = c - 1; i >= 0; i--) {
                if (s[r][i] != -1) {
                    res += s[r][i];
                    count++;
                    break;

                }
            }

        } catch (Exception e) {

        }

        try {
            for (int i = r+1; i < s.length; i++) {
                if (s[i][c] != -1) {
                    res += s[i][c];
                    count++;
                    break;

                }
            }

        } catch (Exception e) {

        }

        try {
            for (int i = c+1; i < s[0].length; i++) {
                if (s[r][i] != -1) {
                    res += s[r][i];
                    count++;
                    break;
                }
            }

        } catch (Exception e) {

        }
        return res / count;
    }
}
