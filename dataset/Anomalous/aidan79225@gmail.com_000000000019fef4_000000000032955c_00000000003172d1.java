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

    public void processCase(int caseNum, Scanner scanner) {
        int n = scanner.nextInt();
        int d = scanner.nextInt();
        long[] a = new long[n];
        for (int i = 0; i < n; ++i) {
            a[i] = scanner.nextLong();
        }
        Arrays.sort(a);

        @SuppressWarnings("unchecked")
        Pair<List<Integer>, List<Integer>>[] cnt = new Pair[n];
        for (int i = 0; i < n; ++i) {
            cnt[i] = new Pair<>(new ArrayList<>(), new ArrayList<>());
            for (int j = i + 1; j < n; ++j) {
                if (a[j] % a[i] == 0) {
                    cnt[i].first.add(j);
                } else {
                    cnt[i].second.add(j);
                }
            }
        }

        int[] answers = new int[n];
        Arrays.fill(answers, -1);

        for (int i = 0; i < n; ++i) {
            int current = 1;
            int cut = 0;

            for (int s : cnt[i].first) {
                long ns = a[s] / a[i];
                if (current + ns < d) {
                    cut += ns - 1;
                    current += ns;
                } else {
                    cut += Math.min(ns - 1, d - current);
                    answers[i] = cut;
                    break;
                }
            }

            if (answers[i] == -1) {
                int cycles = d / current;
                int remainder = d % current;
                if (remainder > 0) {
                    ++cycles;
                }
                cut += (cycles - 1) * (current - 1) + (remainder > 0 ? remainder : current);
                answers[i] = cut;
            }
        }

        int minCuts = Arrays.stream(answers).filter(ans -> ans != -1).min().orElse(d - 1);
        System.out.printf(OUTPUT_FORMAT, caseNum, minCuts);
        System.out.println();
    }

    static class Pair<F, S> {
        final F first;
        final S second;

        Pair(F first, S second) {
            this.first = first;
            this.second = second;
        }
    }
}