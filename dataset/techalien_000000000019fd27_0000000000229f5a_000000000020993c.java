import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = in.nextInt();
        for (int t = 1; t <= T; ++t) {
            int n = in.nextInt();

            Map<Integer, Set<Integer>> rows = new HashMap<>();
            Map<Integer, Set<Integer>> columns = new HashMap<>();

            Set<Integer> badR = new HashSet<>();
            Set<Integer> badC = new HashSet<>();

            int trace = 0;
            int badRows = 0;
            int badColumns = 0;

            for (int i = 0;i<n;i++) {
                for (int j = 0;j<n;j++) {
                    int num = in.nextInt();
                    if (i == j) {
                        trace += num;
                    }

                    if (!rows.containsKey(i)) {
                        rows.put(i, new HashSet<>());
                    }

                    if (!columns.containsKey(j)) {
                        columns.put(j, new HashSet<>());
                    }

                    if (!rows.get(i).add(num) && badR.add(i)) {
                        badRows++;
                    }

                    if (!columns.get(j).add(num) && badC.add(j)) {
                        badColumns++;
                    }
                }
            }

            System.out.println(String.format("Case #%d: %d %d %d", t, trace, badRows, badColumns));
        }
    }
}
