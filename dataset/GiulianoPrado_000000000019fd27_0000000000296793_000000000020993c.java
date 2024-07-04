import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class Solution {


    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int N = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int prob = 1; prob <= N; ++prob) {
            int x = in.nextInt();
            int trace = 0;
            int repeatLine = 0;
            int repeatColumn = 0;
            int[][] matrix = new int[x][x];
            for (int i = 1; i <= x; ++i) {
                for (int j = 1; j <= x; j++) {
                    matrix[i-1][j-1] = in.nextInt();
                    if (i==j) trace+=matrix[i-1][j-1];
                }
            }
            for (int i = 1; i <= x; ++i) {
                HashSet hashLine = new LinkedHashSet<Integer>();
                HashSet hashColumn = new LinkedHashSet<Integer>();
                boolean repeatedLine = false;
                boolean repeatedColumn = false;
                for (int j = 1; j <= x; j++) {
                    if (hashLine.contains(matrix[i-1][j-1])) repeatedLine = true;
                    hashLine.add(matrix[i-1][j-1]);
                    if (hashColumn.contains(matrix[j-1][i-1])) repeatedColumn = true;
                    hashColumn.add(matrix[j-1][i-1]);
                }
                if (repeatedLine) repeatLine++;
                if (repeatedColumn) repeatColumn++;
            }

            System.out.println("Case #" + prob + ": " + trace + " " + repeatLine + " " + repeatColumn);
        }
    }
}
