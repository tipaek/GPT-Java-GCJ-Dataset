import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Solution {
    private static final String OUTPUT_FORMAT = "Case #%d: %d";

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int t = scanner.nextInt();
            for (int caseNum = 1; caseNum <= t; ++caseNum) {
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
        for (int i = 0; i < n; ++i) {
            a[i] = scanner.nextLong();
        }
        Arrays.sort(a);

        List<Integer>[] divisors = new List[n];
        for (int i = 0; i < n; ++i) {
            divisors[i] = new ArrayList<>();
            for (int j = i + 1; j < n; ++j) {
                if (a[j] % a[i] == 0) {
                    divisors[i].add(j);
                }
            }
        }

        int[] minCuts = new int[n];
        for (int i = 0; i < n; ++i) {
            int currentCount = 1;
            int cuts = 0;
            minCuts[i] = -1;
            for (int index : divisors[i]) {
                long quotient = a[index] / a[i];
                if (currentCount + quotient < d) {
                    cuts += quotient - 1;
                    currentCount += quotient;
                } else {
                    cuts += Math.min(quotient - 1, d - currentCount);
                    minCuts[i] = cuts;
                    break;
                }
            }
        }

        int minimumCuts = d - 1;
        for (int cut : minCuts) {
            if (cut != -1) {
                minimumCuts = Math.min(minimumCuts, cut);
            }
        }
        System.out.printf(OUTPUT_FORMAT, caseNum, minimumCuts);
        System.out.println();
    }

    private static class Pair<F, S> {
        final F first;
        final S second;

        Pair(F first, S second) {
            this.first = first;
            this.second = second;
        }
    }
}