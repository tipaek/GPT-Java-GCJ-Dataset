import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            int k = 0, r = 0, c = 0;
            ArrayList<HashSet<Integer>> cols = new ArrayList<>(n);
            for (int p = 0; p < n; p++) {
                cols.add(new HashSet<>());
            }
            boolean[] colsSeen = new boolean[n];
            for (int row = 0; row < n; row++) {
                HashSet<Integer> seen = new HashSet<>();
                boolean saw = false;
                for (int col = 0; col < n; col++) {
                    int num = in.nextInt();
                    if (row == col) {
                        k += num;
                    }
                    if (seen.contains(num)) {
                        saw = true;
                    }
                    seen.add(num);
                    if (cols.get(col).contains(num)) {
                        colsSeen[col] = true;
                    }
                    cols.get(col).add(num);
                }
                if (saw) {
                    r++;
                }
            }
            for (boolean b : colsSeen) {
                if (b) {
                    c++;
                }
            }
            System.out.println("Case #" + i + ": " + k + " " + r + " " + c);
        }
    }
}