import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

class Solution {
    public static void main(String[] args) throws Exception {
        int t = sc.nextInt();
        for (int i = 1; i <= t; i++) {
            isPossible = false;
            System.out.print("Case #" + i + ": ");
            solve();
        }
    }

    public static boolean isPossible = false;

    public static void solve() throws Exception {
        int n = sc.nextInt();
        int[] who = new int[n];
        Arrays.fill(who, -1);

        Pair[] pairs = new Pair[n];
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            pairs[i] = new Pair(a, b);
        }

        Arrays.sort(pairs);

        HashSet<Integer> dp = new HashSet<>();
        rec(0, pairs, 0, 0, who, dp);

        if (!isPossible) {
            System.out.println("IMPOSSIBLE");
        }
    }

    private static boolean rec(int idx, Pair[] pairs, int C, int J, int[] who, HashSet<Integer> dp) {
        if (idx >= who.length) {
            if (isPossible) return true;
            for (int i = 0; i < who.length; i++)
                System.out.print(who[i] == 0 ? "C" : "J");
            System.out.println();
            isPossible = true;
            return true;
        }
        int key = C * 2000 + J;

        if (dp.contains(key)) return false;
        if (isPossible) return true;

        boolean a = false, b = false;

        if (C <= pairs[idx].s) {
            who[idx] = 0;
            a = rec(idx + 1, pairs, pairs[idx].e, J, who, dp);
            who[idx] = -1;
        }

        if (isPossible) return true;

        if (J <= pairs[idx].s) {
            who[idx] = 1;
            b = rec(idx + 1, pairs, C, pairs[idx].e, who, dp);
            who[idx] = -1;
        }

        if (isPossible) return true;

        dp.add(key);

        return a || b;
    }

    public static class Pair implements Comparable<Pair> {
        int s, e;

        Pair(int s, int e) {
            this.s = s;
            this.e = e;
        }

        @Override
        public int compareTo(Pair o) {
            int a = this.s - o.s;
            return a == 0 ? this.e - o.e : a;
        }

        @Override
        public String toString() {
            return "{" + this.s + " " + this.e + "}";
        }
    }

    public static InputStreamReader r = new InputStreamReader(System.in);
    public static BufferedReader br = new BufferedReader(r);
    public static Scanner sc = new Scanner(System.in);
}