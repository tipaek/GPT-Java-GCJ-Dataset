
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Solution {
    private static String output1 = "Case #%d: %d";


    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            int t = scanner.nextInt();
            for (int caseNum = 1; caseNum <= t; ++caseNum) {
                new Solution().getAnswer(caseNum, scanner);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getAnswer(int caseNum, Scanner scanner) {
        int n = scanner.nextInt();
        int d = scanner.nextInt();
        long[] a = new long[n];
        for (int i = 0; i < n; ++i) {
            a[i] = scanner.nextLong();
        }
        Arrays.sort(a);
        List<Integer>[] cnt = new List[n];

        for (int i = 0; i < n; ++i) {
            cnt[i] = new ArrayList<>();
            for (int j = i+1; j < n; ++j) {
                if (a[j] % a[i] == 0) {
                    cnt[i].add(j);
                }
            }
        }
        int[] ans = new int[n];
        for (int i = 0; i < n; ++i) {
            int cur = 1;
            int cut = 0;
            ans[i] = -1;
            for (int s: cnt[i]) {
                long ns = a[s]/a[i];
                if (cur + ns < d) {
                    cut += ns-1;
                    cur += ns;
                } else {
                    cut += Math.min(ns-1, d-cur);
                    ans[i] = cut;
                    break;
                }
            }
        }
        int min = d-1;
        for (int i : ans) {
            if (i == -1) {
                continue;
            }
            min = Math.min(min, i);
        }
        println(String.format(output1, caseNum, min));
    }

    public static void print(Object o) {
        System.out.print(o);
    }
    public static void println(Object o) {
        System.out.println(o);
    }
    public static void println() {
        System.out.println();
    }
    public static void printErr(Object o) {
        System.err.print(o);
    }
    public static void printErrln(Object o) {
        System.err.println(o);
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