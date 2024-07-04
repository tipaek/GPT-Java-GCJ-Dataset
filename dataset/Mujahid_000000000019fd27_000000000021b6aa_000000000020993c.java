import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        ArrayList<ArrayList<Integer>> elems = new ArrayList<>();
        
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            int[][] matrix = new int[n][n];
            int lineNo = 0;
            while (lineNo <= n) {
                lineNo++;

                String elem = in.nextLine().replaceAll("\\s", "");
                char[] values = elem.toCharArray();
                for (char value : values) {
                    for (int a = 0; a < n; a++) {
                        for (int b = 0; b < n; b++) {
                            matrix[a][b] = Character.getNumericValue(value);
                        }
                    }
                }
            }
            int sum = 0;
            int rows = 0;
            int cols = 0;
            for (int x = 0; x < n; x++) {
                for (int y = 0; y < n; y++) {
                    if (x == y) {
                        sum += matrix[x][y];
                    }
                }
            }
            
            System.out.println("Case #" + i + ": " + (sum) + " " + (rows) + " " + (cols));
            sum = 0;
        }
    }
}