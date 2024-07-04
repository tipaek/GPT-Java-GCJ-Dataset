import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    private static Scanner scanner;

    public static void main(String[] args) {
        scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = scanner.nextInt();
        for (int i = 1; i <= t; ++i) {
            System.out.println("Case #" + i + ": " + solve());
        }
    }

    private static String solve() {
        int n = scanner.nextInt();

        List<Set<Integer>> rows = new ArrayList<>(n);
        List<Set<Integer>> cols = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            rows.add(new HashSet<>());
            cols.add(new HashSet<>());
        }

        int traceSum = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                int m = scanner.nextInt();

                if (i == j) {
                    traceSum += m;
                }
                rows.get(i).add(m);
                cols.get(j).add(m);
            }
        }

        int repeatRows = (int) rows.stream()
                .filter(ms -> ms.size() < n)
                .count();
        int repeatCols = (int) cols.stream()
                .filter(ms -> ms.size() < n)
                .count();

        return String.format("%s %s %s", traceSum, repeatRows, repeatCols);
    }

    private static int sumFat(int n) {
        if (n <= 1) {
            return n;
        }
        return n + sumFat(n - 1);
    }

}