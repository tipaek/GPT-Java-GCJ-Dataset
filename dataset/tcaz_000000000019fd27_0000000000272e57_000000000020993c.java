import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {
        new Solution().start();
    }

    void start() {
        Scanner scan = new Scanner(System.in);
        int cases = scan.nextInt();
        for (int i = 0; i < cases; i++) {
            Set<String> seen = new HashSet<>();
            Set<Integer> rows = new HashSet<>();
            Set<Integer> cols = new HashSet<>();
            int trace = 0;
            int n = scan.nextInt();
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    int val = scan.nextInt();
                    String seenRow = "r" + j + ":" + val;
                    String seenCol = "c" + k + ":" + val;
                    if (j == k) {
                        trace += val;
                    }
                    if (seen.contains(seenRow)) {
                        rows.add(j);
                    }
                    if (seen.contains(seenCol)) {
                        cols.add(k);
                    }
                    seen.add(seenRow);
                    seen.add(seenCol);
                }
            }
            System.out.println("Case #" + (i+1) + ": " + trace + " " + rows.size() + " " + cols.size());
        }
    }

}
