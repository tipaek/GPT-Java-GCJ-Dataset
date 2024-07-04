import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        int t = sc.nextInt();
        for (int i = 1; i <= t; i++) {
            System.out.print("Case #" + i + ": ");
            solve();
        }
    }

    public static void solve() throws Exception {
        int n = sc.nextInt();
        Pair[] pairs = new Pair[n];

        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            pairs[i] = new Pair(a, b, i);
        }

        for (int sub = 0; sub < (1 << n); sub++) {
            String s = Integer.toBinaryString(sub);
            while (s.length() < n) {
                s = "0" + s;
            }

            int[] C = new int[1500];
            int[] J = new int[1500];

            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '0') {
                    C[pairs[i].s]++;
                    C[pairs[i].e]--;
                } else {
                    J[pairs[i].s]++;
                    J[pairs[i].e]--;
                }
            }

            int c = 0, j = 0;
            boolean valid = true;
            for (int i = 0; i < C.length; i++) {
                c += C[i];
                j += J[i];
                if (c > 1 || j > 1) {
                    valid = false;
                    break;
                }
            }

            if (valid) {
                for (int i = 0; i < s.length(); i++) {
                    System.out.print(s.charAt(i) == '0' ? "C" : "J");
                }
                System.out.println();
                return;
            }
        }

        System.out.println("IMPOSSIBLE");
    }

    public static class Pair implements Comparable<Pair> {
        int s, e, id;

        Pair(int s, int e, int id) {
            this.s = s;
            this.e = e;
            this.id = id;
        }

        @Override
        public int compareTo(Pair o) {
            if (this.s != o.s) {
                return this.s - o.s;
            }
            return this.e - o.e;
        }

        @Override
        public String toString() {
            return "{" + this.s + " " + this.e + "}";
        }
    }
}