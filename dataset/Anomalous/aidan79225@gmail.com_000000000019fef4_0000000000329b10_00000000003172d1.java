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
            int cuts = 0;

            for (int s : cnt[i].first) {
                long ns = a[s] / a[i];
                if (current + ns < d) {
                    cuts += ns - 1;
                    current += ns;
                } else {
                    cuts += Math.min(ns - 1, d - current);
                    answers[i] = cuts;
                    break;
                }
            }

            if (answers[i] != -1) continue;

            for (int s : cnt[i].second) {
                long ns = a[s] / a[i];
                if (current + ns < d) {
                    cuts += ns;
                    current += ns;
                } else {
                    cuts += Math.min(ns, d - current);
                    answers[i] = cuts;
                    break;
                }
            }

            if (answers[i] == -1) {
                int cycles = d / current;
                int remainder = d % current;
                cuts += (cycles - 1) * (current - 1) + (remainder > 0 ? remainder : current);
                answers[i] = cuts;
            }
        }

        int minCuts = d - 1;
        for (int answer : answers) {
            if (answer > 0) {
                minCuts = Math.min(minCuts, answer);
            }
        }

        println(String.format(OUTPUT_FORMAT, caseNum, minCuts));
    }

    private static void print(Object o) {
        System.out.print(o);
    }

    private static void println(Object o) {
        System.out.println(o);
    }

    private static void println() {
        System.out.println();
    }

    private static void printErr(Object o) {
        System.err.print(o);
    }

    private static void printErrln(Object o) {
        System.err.println(o);
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