import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Solution {
    public static final int LEN = 600;
    public static long[][] pascal;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int i = 1; i <= t; i++) {
            System.out.println("Case #" + i + ": ");
            solve(br);
        }
    }

    public static void solve(BufferedReader br) throws Exception {
        int n = Integer.parseInt(br.readLine());

        if (n == 501) {
            System.out.println("1 1");
            System.out.println("2 1");
            System.out.println("3 2");
            System.out.println("3 1");
            int t = n - 5;
            for (int i = 4; t > 0; i++, t--) {
                System.out.println(i + " 1");
            }
        } else {
            for (int i = 1; i <= n; i++) {
                System.out.println(i + " 1");
            }
        }
    }

    // Placeholder for Pascal's Triangle generation (commented out in original)
    private static void generatePascalTriangle() {
        pascal = new long[LEN][];
        for (int r = 0; r < pascal.length; r++) {
            pascal[r] = new long[r + 1];
            for (int i = 0; i < r + 1; i++) {
                if (i == 0 || i == r) {
                    pascal[r][i] = 1;
                } else {
                    pascal[r][i] = pascal[r - 1][i - 1] + pascal[r - 1][i];
                }
            }
        }
    }

    private static void rec(int r, int c, long sum, HashSet<Integer> hs, ArrayList<Integer> al, int step, int N) {
        int len = LEN + 10;
        if (step > 500) return;
        if (sum == N) {
            for (int x : al) {
                System.out.println((x / len + 1) + " " + ((x % len) + 1));
            }
            return;
        }
        if (r < 0 || r >= pascal.length || c < 0 || c >= pascal[r].length) return;

        int key = len * r + c;
        if (hs.contains(key)) return;

        hs.add(key);
        al.add(key);
        sum += pascal[r][c];
        step++;

        rec(r + 1, c, sum, hs, al, step, N);
        rec(r + 1, c + 1, sum, hs, al, step, N);
        rec(r, c - 1, sum, hs, al, step, N);
        rec(r, c + 1, sum, hs, al, step, N);
        rec(r - 1, c - 1, sum, hs, al, step, N);
        rec(r - 1, c, sum, hs, al, step, N);

        hs.remove(key);
        al.remove(al.size() - 1);
    }
}