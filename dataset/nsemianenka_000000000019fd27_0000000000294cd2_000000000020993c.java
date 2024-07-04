import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int tc = in.nextInt();
        for (int t = 1; t <= tc; ++t) {
            int n = in.nextInt();

            List<List<Integer>> arr = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                List<Integer> row = new ArrayList<>();
                for (int j = 0; j < n; j++) {
                    row.add(in.nextInt());
                }
                arr.add(row);
            }

            int sum = 0, rCount = 0, cCount = 0;
            for (int i = 0; i < n; i++) {
                sum += arr.get(i).get(i);
            }

            Set<Integer> cols = new HashSet<>();
            Set<Integer> rows = new HashSet<>();

            for (int i = 0; i < n; i++) {
                boolean rowRepeat = false;
                boolean colRepeat = false;
                for (int j = 0; j < n; j++) {
                    rowRepeat |= !rows.add(arr.get(i).get(j));
                    colRepeat |= !cols.add(arr.get(j).get(i));
                }
                rCount += rowRepeat ? 1 : 0;
                cCount += colRepeat ? 1 : 0;
                cols.clear();
                rows.clear();
            }

            System.out.println(String.format("Case #%s: %s %s %s", t, sum, rCount, cCount));
        }
    }

}
