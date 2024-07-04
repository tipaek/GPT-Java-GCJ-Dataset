import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            Set<Integer> row;
            Map<Integer, Set<Integer>> cols = new HashMap<>();
            int k, r, c;
            k = 0;
            r = 0;
            c = 0;
            for(int a = 0; a < n; a++) {
                row = new HashSet<>();
                for(int b = 0; b < n; b++) {
                    int val = in.nextInt();
                    if(a == b) k += val;
                    row.add(val);
                    if(!cols.containsKey(b)) {
                        cols.put(b, new HashSet<>());
                    }
                    cols.get(b).add(val);
                }
                if(row.size() < n) r++;
            }
            for(int key: cols.keySet()) {
                if (cols.get(key).size() < n) c++;
            }
            System.out.println("Case #" + i + ": " + k + " " + r + " " + c);
        }
    }
}