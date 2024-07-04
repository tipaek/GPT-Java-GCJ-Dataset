import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Solution {
    private static final String OUTPUT_FORMAT = "Case #%d: %d";

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int testCases = scanner.nextInt();
            for (int caseNum = 1; caseNum <= testCases; ++caseNum) {
                new Solution().solveCase(caseNum, scanner);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void solveCase(int caseNum, Scanner scanner) {
        int n = scanner.nextInt();
        int d = scanner.nextInt();
        long[] array = new long[n];
        for (int i = 0; i < n; ++i) {
            array[i] = scanner.nextLong();
        }
        Arrays.sort(array);

        Pair<List<Integer>, List<Integer>>[] divisiblePairs = new Pair[n];
        for (int i = 0; i < n; ++i) {
            divisiblePairs[i] = new Pair<>(new ArrayList<>(), new ArrayList<>());
            for (int j = i + 1; j < n; ++j) {
                if (array[j] % array[i] == 0) {
                    divisiblePairs[i].first.add(j);
                } else {
                    divisiblePairs[i].second.add(j);
                }
            }
        }

        int[] results = new int[n];
        for (int i = 0; i < n; ++i) {
            results[i] = calculateMinimumCuts(array, divisiblePairs[i], d, i);
        }

        int minimumCuts = Arrays.stream(results).filter(result -> result != -1).min().orElse(d - 1);
        println(String.format(OUTPUT_FORMAT, caseNum, minimumCuts));
    }

    private int calculateMinimumCuts(long[] array, Pair<List<Integer>, List<Integer>> pairs, int d, int i) {
        int current = 1;
        int cuts = 0;
        for (int index : pairs.first) {
            long quotient = array[index] / array[i];
            if (current + quotient < d) {
                cuts += quotient - 1;
                current += quotient;
            } else {
                cuts += Math.min(quotient - 1, d - current);
                return cuts;
            }
        }

        for (int index : pairs.second) {
            long quotient = array[index] / array[i];
            if (current + quotient < d) {
                cuts += quotient;
                current += quotient;
            } else {
                cuts += Math.min(quotient, d - current);
                return cuts;
            }
        }

        int fullCycles = d / current;
        int remainder = d % current;
        cuts += (fullCycles - 1) * (current - 1) + (remainder > 0 ? remainder : current);
        return cuts;
    }

    private static void println(Object o) {
        System.out.println(o);
    }

    private static class Pair<F, S> {
        F first;
        S second;

        Pair(F first, S second) {
            this.first = first;
            this.second = second;
        }
    }
}