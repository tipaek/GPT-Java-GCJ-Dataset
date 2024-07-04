import java.util.*;
import java.io.*;

class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = scan.nextInt();
        for (int i = 1; i <= t; i++) {
            solve(scan, i);
        }
    }

    static void solve(Scanner scan, int test) {
        int n = scan.nextInt();
        int trace = 0;
        int repRows = 0;
        int repCols = 0;
        HashMap<Integer, HashSet<Integer>> rows = new HashMap<>();
        HashMap<Integer, HashSet<Integer>> cols = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int value = scan.nextInt();
                if (i == j) {
                    trace += value;
                }
                addToMap(rows, i, value);
                addToMap(cols, j, value);
            }
        }
        for (HashSet<Integer> row: rows.values()) {
            if (row.size() != n) {
                repRows++;
            }
        }
        for (HashSet<Integer> col: cols.values()) {
            if (col.size() != n) {
                repCols++;
            }
        }
        System.out.println("Case #" + test + ": " + trace + " " + repRows + " " + repCols);
    }

    static void addToMap(HashMap<Integer, HashSet<Integer>> map, int key, int value) {
        if (map.containsKey(key)) {
            map.get(key).add(value);
        }
        else {
            HashSet<Integer> set = new HashSet<>();
            set.add(value);
            map.put(key, set);
        }
    }
}