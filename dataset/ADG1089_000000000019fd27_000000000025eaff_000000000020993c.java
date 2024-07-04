import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int x = 1;
        while (t-- > 0) {
            int n = sc.nextInt();
            int k = 0; // trace
            int r = 0; // rows
            int c = 0; // columns
            List<HashSet<Integer>> cols = new ArrayList<>();
            List<HashSet<Integer>> rows = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                cols.add(new HashSet<>());
                rows.add(new HashSet<>());
            }
            Set<Integer> dupRows = new HashSet<>();
            Set<Integer> dupCols = new HashSet<>();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    int a = sc.nextInt();
                    if (i == j) {
                        k += a;
                    }
                    if (cols.get(i).contains(a)) {
                        dupCols.add(i);
                    } else {
                        cols.get(i).add(a);
                    }
                    if (rows.get(j).contains(a)) {
                        dupRows.add(j);
                    } else {
                        rows.get(j).add(a);
                    }
                }
            }
            c = dupRows.size();
            r = dupCols.size();

            System.out.printf("Case #%d: %d %d %d\n", x, k, r, c);
            x += 1;
        }


    }
}