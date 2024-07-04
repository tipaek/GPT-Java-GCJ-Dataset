import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            compute(in, i);
        }
    }

    private static void compute(Scanner in, int test) {
        int k = 0;
        int r = 0;
        int c = 0;
        Set<Integer> rowTracker = new HashSet<>();
        Map<Integer, Set<Integer>> columnTracker = new HashMap<>();
        int N = in.nextInt();
        for (int rowNumber = 0; rowNumber < N; rowNumber++) {
            for (int columnNumber = 0; columnNumber < N; columnNumber++) {
                Set<Integer> column = columnTracker.getOrDefault(columnNumber, new HashSet<>());
                int value = in.nextInt();
                rowTracker.add(value);
                column.add(value);
                if (rowNumber == columnNumber) {
                    k = k + value;
                }

                if (rowNumber == N - 1) {
                    if (column.size() != N) {
                        c++;
                    }
                }
                columnTracker.put(columnNumber, column);
            }
            if (rowTracker.size() != N) {
                r++;
            }
            rowTracker.clear();
        }
        System.out.printf("Case #%d: %d %d %d\n", test + 1, k, r, c);
    }
}
