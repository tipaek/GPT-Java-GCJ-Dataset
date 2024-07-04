import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = Integer.valueOf(in.nextLine());
        for (int t = 1; t <= T; t++) {
            int N = Integer.valueOf(in.nextLine());
            List<Set<Integer>> columns = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                columns.add(new HashSet<>());
            }
            int trace = 0;
            int rr = 0;
            for (int n = 0; n < N; n++) {
                String line = in.nextLine().trim();
                String[] cells = line.split(" ");
                trace += Integer.valueOf(cells[n]);
                Set<Integer> row = new HashSet<>();
                for (int i = 0; i < N; i++) {
                    int val = Integer.valueOf(cells[i]);
                    columns.get(i).add(val);
                    row.add(val);
                }
                if (row.size() < N) {
                    rr++;
                }
            }
            int rc = 0;
            for (int i = 0; i < N; i++) {
                if (columns.get(i).size() < N) {
                    rc++;
                }
            }
            System.out.printf("Case #%d: %d %d %d\n", t, trace, rr, rc);
        }
    }
}