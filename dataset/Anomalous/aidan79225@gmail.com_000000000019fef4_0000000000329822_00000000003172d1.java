import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Solution {
    private static final String OUTPUT_FORMAT = "Case #%d: %d";

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int testCases = scanner.nextInt();
            for (int caseNum = 1; caseNum <= testCases; caseNum++) {
                new Solution().processCase(caseNum, scanner);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void processCase(int caseNum, Scanner scanner) {
        int n = scanner.nextInt();
        int d = scanner.nextInt();
        long[] array = new long[n];
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextLong();
        }
        Arrays.sort(array);
        
        Pair<List<Integer>, List<Integer>>[] counts = new Pair[n];
        for (int i = 0; i < n; i++) {
            counts[i] = new Pair<>(new ArrayList<>(), new ArrayList<>());
            for (int j = i + 1; j < n; j++) {
                if (array[j] % array[i] == 0) {
                    counts[i].first.add(j);
                } else {
                    counts[i].second.add(j);
                }
            }
        }

        int[] results = new int[n];
        for (int i = 0; i < n; i++) {
            results[i] = calculateMinimumCuts(array, counts[i], d, i);
        }

        int minCuts = d - 1;
        for (int result : results) {
            if (result != -1) {
                minCuts = Math.min(minCuts, result);
            }
        }

        System.out.printf(OUTPUT_FORMAT, caseNum, minCuts);
        System.out.println();
    }

    private int calculateMinimumCuts(long[] array, Pair<List<Integer>, List<Integer>> count, int d, int index) {
        int current = 1;
        int cuts = 0;

        for (int i : count.first) {
            long factor = array[i] / array[index];
            if (current + factor < d) {
                cuts += factor - 1;
                current += factor;
            } else {
                cuts += Math.min(factor - 1, d - current);
                return cuts;
            }
        }

        for (int i : count.second) {
            long factor = array[i] / array[index];
            if (current + factor < d) {
                cuts += factor;
                current += factor;
            } else {
                cuts += Math.min(factor, d - current);
                return cuts;
            }
        }

        int quotient = d / current;
        int remainder = d % current;
        if (remainder > 0) {
            cuts += (quotient - 1) * (current - 1) + remainder;
        } else {
            cuts += (quotient - 1) * current;
        }
        return cuts;
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