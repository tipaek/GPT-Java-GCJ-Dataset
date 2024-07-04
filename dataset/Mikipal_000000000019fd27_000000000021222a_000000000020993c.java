import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            in.nextLine();
            int matr[][] = new int[n][n];
            int r = 0, c = 0;
            for (int j = 0; j < n; j++) {
                String m[] = in.nextLine().split(" ");
                for (int l = 0; l < n; l++) {
                    matr[j][l] = Integer.parseInt(m[l]);
                }
            }

            int k = 0;
            for (int j = 0; j < n; j++) {
                k += matr[j][j];
                r += duplicates(matr[j]);
                    int col[] = new int[n];
                    for (int l = 0; l < n; l++) {
                        col[l] = matr[l][j];

                    }
                    c += duplicates(col);
            }

            System.out.println("Case #" + i + ": " + k + " " + r + " " + c);
        }
    }

    public static int duplicates(int comparator[]) {
        int count = 0;
        for (int i = 0; i < comparator.length; i++) {
            for (int j = i; j < comparator.length; j++) {
                if (comparator[j] == comparator[i] && i!=j) {
                    count = 1;
                    j=comparator.length;
                }

            }
        }
        return count;
    }
}