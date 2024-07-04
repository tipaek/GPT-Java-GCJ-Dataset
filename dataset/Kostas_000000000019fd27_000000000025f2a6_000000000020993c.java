import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            int[][] matrix = new int[n][n];
            int trace = 0;
            int rows = 0;
            int columns = 0;
            Hashtable<Integer, HashSet<Integer>> c = new Hashtable<Integer, HashSet<Integer>>();

            for (int j = 0; j < n; j++) {
                HashSet r = new HashSet<Integer>();
                for (int k = 0; k < n; k++) {
                    int number = in.nextInt();
                    r.add(number);
                    if (j == k) {
                        trace += number;
                    }
                    if (c.containsKey(k)) {
                        c.get(k).add(number);
                    } else {
                        c.put(k, new HashSet<Integer>());
                        c.get(k).add(number);
                    }
                }
                if (r.size() < n) {
                    rows++;
                }
            }
            for (HashSet<Integer> column: c.values()) {
                if (column.size() < n) {
                    columns++;
                }
            }
            System.out.println("Case #" + i + ":" + trace + " " + rows + " " + columns);
        }
    }
}