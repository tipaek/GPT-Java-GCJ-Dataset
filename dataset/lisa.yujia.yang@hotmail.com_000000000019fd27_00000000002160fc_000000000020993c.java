import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner
        (new BufferedReader(new InputStreamReader(System.in)));
        int tests = in.nextInt();
        int num = 1;
                while (tests > 0) {
            int n = in.nextInt();
            int trace = 0;
            List<Set<Integer>> rows = new ArrayList<>();
            List<Set<Integer>> cols = new ArrayList<>();
            
            for (int i = 0; i < n; i++) {
                rows.add(new HashSet<Integer>());
                cols.add(new HashSet<Integer>());
            }
            
            int row = 0;
            int col = 0;
            while (row < n) {
                int next = in.nextInt();
                if (row == col) {
                    trace += next;
                }
                rows.get(row).add(next);
                cols.get(col).add(next);
                if (col == n - 1) {
                    row++;
                    col = 0;
                } else {
                    col++;
                }
            }
            
            int rp = 0;
            int cp = 0;
            
            for (int i = 0; i < n; i++) {
                if (rows.get(i).size() != n) {
                    rp++;
                }
                if (cols.get(i).size() != n) {
                    cp++;
                }
            }
            
            System.out.println("Case #" + num + ": " +
            trace + " " + rp + " " + cp);
            
            tests--;
            num++;
        }
    }
}