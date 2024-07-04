import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            List<Set<Integer>> rows = new ArrayList<>(n);
            List<Set<Integer>> columns = new ArrayList<>(n);
            for (int j = 0; j < n; j++) {
                rows.add(new HashSet<>());
                columns.add(new HashSet<>());
            }
            int trace = 0;

            for (int r = 0; r < n; r++) {
                for (int c = 0; c < n; c++) {
                    int number = in.nextInt();
                    rows.get(r).add(number);
                    columns.get(c).add(number);
                    if (r == c) {
                        trace += number;
                    }
                }
            }

            System.out.println(String.format("Case #%d: %d %d %d", i, trace, rows.stream().filter(set -> set.size() != n).count(), columns.stream().filter(set -> set.size() != n).count()));
        }
    }
}