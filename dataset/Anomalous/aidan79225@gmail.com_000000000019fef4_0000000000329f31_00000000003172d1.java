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
                new Solution().solveCase(caseNum, scanner);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void solveCase(int caseNum, Scanner scanner) {
        int n = scanner.nextInt();
        int d = scanner.nextInt();
        long[] a = new long[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextLong();
        }
        Arrays.sort(a);
        List<Pair<List<Integer>, List<Integer>>> cnt = new ArrayList<>(n);

        for (int i = 0; i < n; i++) {
            List<Integer> divisible = new ArrayList<>();
            List<Integer> notDivisible = new ArrayList<>();
            for (int j = i + 1; j < n; j++) {
                if (a[j] % a[i] == 0) {
                    divisible.add(j);
                } else {
                    notDivisible.add(j);
                }
            }
            cnt.add(new Pair<>(divisible, notDivisible));
        }

        int[] ans = new int[n];
        Arrays.fill(ans, -1);

        for (int i = 0; i < n; i++) {
            int current = 1;
            int cut = 0;

            for (int s : cnt.get(i).first) {
                long quotient = a[s] / a[i];
                if (current + quotient < d) {
                    cut += quotient - 1;
                    current += quotient;
                } else {
                    cut += Math.min(quotient - 1, d - current);
                    ans[i] = cut;
                    break;
                }
            }
            if (ans[i] != -1) continue;

            for (int s : cnt.get(i).second) {
                long quotient = a[s] / a[i];
                if (current + quotient < d) {
                    cut += quotient;
                    current += quotient;
                } else {
                    cut += Math.min(quotient, d - current);
                    ans[i] = cut;
                    break;
                }
            }

            if (ans[i] == -1) {
                int cycles = d / current;
                int remainder = d % current;
                if (remainder > 0) cycles++;
                cut += (cycles - 1) * (current - 1) + remainder;
                ans[i] = cut;
            }
        }

        int minCuts = d - 1;
        for (int i : ans) {
            if (i > 0) {
                minCuts = Math.min(minCuts, i);
            }
        }
        System.out.println(String.format(OUTPUT_FORMAT, caseNum, minCuts));
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