import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            int[] sol = new int[]{0, 0, 0};
            if(n > 0) {
                sol = inputMatrix(n, in);
            }
            System.out.println("Case #" + i + ": " + sol[0] + " " + sol[1] + " " + sol[2]);
        }
    }

    private static int[] inputMatrix(int n, Scanner in) {
        int x;
        int k = 0;
        int r = 0;
        int c = 0;
        Set<Integer> row;
        Map<Integer, Set<Integer>> col = new HashMap<>();
        for (int i = 0; i < n; i++) {
            col.put(i, new HashSet<>());
        }
        for (int i = 0; i < n; i++) {
            row = new HashSet<>();
            for (int j = 0; j < n; j++) {
                x = in.nextInt();
                if (i == j) {
                    k += x;
                }
                row.add(x);
                col.get(j).add(x);

            }
            if (row.size() < n) {
                r++;
            }
        }
        for (int i = 0; i < n; i++) {
            if (col.get(i).size() < n) {
                c++;
            }
        }
        return new int[] { k, r, c };
    }
}