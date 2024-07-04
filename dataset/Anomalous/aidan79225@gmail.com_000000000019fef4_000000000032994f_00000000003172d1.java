import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Solution {
    private static final String OUTPUT_FORMAT = "Case #%d: %d";

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int t = scanner.nextInt();
            for (int caseNum = 1; caseNum <= t; caseNum++) {
                new Solution().processCase(caseNum, scanner);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void processCase(int caseNum, Scanner scanner) {
        int n = scanner.nextInt();
        int d = scanner.nextInt();
        long[] a = new long[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextLong();
        }
        Arrays.sort(a);
        Pair<List<Integer>, List<Integer>>[] divisors = new Pair[n];

        for (int i = 0; i < n; i++) {
            divisors[i] = new Pair<>(new ArrayList<>(), new ArrayList<>());
            for (int j = i + 1; j < n; j++) {
                if (a[j] % a[i] == 0) {
                    divisors[i].first.add(j);
                } else {
                    divisors[i].second.add(j);
                }
            }
        }

        int[] results = new int[n];
        for (int i = 0; i < n; i++) {
            results[i] = calculateCuts(d, a, divisors[i], i);
        }

        int minimumCuts = calculateMinimumCuts(d, results);
        System.out.printf(OUTPUT_FORMAT, caseNum, minimumCuts);
    }

    private int calculateCuts(int d, long[] a, Pair<List<Integer>, List<Integer>> divisors, int index) {
        int current = 1;
        int cuts = 0;
        for (int divisibleIndex : divisors.first) {
            long quotient = a[divisibleIndex] / a[index];
            if (current + quotient < d) {
                cuts += quotient - 1;
                current += quotient;
            } else {
                cuts += Math.min(quotient - 1, d - current);
                return cuts;
            }
        }

        for (int nonDivisibleIndex : divisors.second) {
            long quotient = a[nonDivisibleIndex] / a[index];
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
        if (remainder > 0) {
            fullCycles++;
        }
        cuts += (fullCycles - 1) * (current - 1) + remainder;
        return cuts;
    }

    private int calculateMinimumCuts(int d, int[] results) {
        int minimumCuts = d - 1;
        for (int result : results) {
            if (result > 0 && result < minimumCuts) {
                minimumCuts = result;
            }
        }
        return minimumCuts;
    }

    static class Pair<F, S> {
        F first;
        S second;

        Pair(F first, S second) {
            this.first = first;
            this.second = second;
        }
    }
}