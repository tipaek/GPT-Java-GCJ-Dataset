import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = in.nextInt();
        for (int i = 1; i <= T; ++i) {
            solveMatrix(in, i);
        }
    }

    private static void solveMatrix(Scanner scanner, int T) {
        int N = scanner.nextInt();
        int trace = 0;
        Map<Integer, Set<Integer>> rows = new HashMap<>();
        Map<Integer, Set<Integer>> columns = new HashMap<>();
        for (int i = 0; i < N; i++) {
            columns.put(i, new HashSet<>());
            rows.put(i, new HashSet<>());
        }
        for (int i = 0; i < N; ++i) {
            Set<Integer> row = rows.get(i);
            for (int j = 0; j < N; ++j) {
                int a = scanner.nextInt();
                row.add(a);
                columns.get(j).add(a);
                if (i == j) {
                    trace += a;
                }
            }
        }

        long r = rows.values().stream().filter(v -> (v.size() < N)).count();
        long c = columns.values().stream().filter(v -> (v.size() < N)).count();
        System.out.println("Case #" + T + ": " + trace + " " + r + " " + c);
    }
}