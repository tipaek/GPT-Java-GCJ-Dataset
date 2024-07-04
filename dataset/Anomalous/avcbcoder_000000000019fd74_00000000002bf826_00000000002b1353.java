import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Solution {
    private static final int LEN = 500;
    private static long[][] pascal;
    private static int N;
    private static boolean done;
    private static final InputStreamReader r = new InputStreamReader(System.in);
    private static final BufferedReader br = new BufferedReader(r);
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        initializePascalTriangle();

        int t = Integer.parseInt(br.readLine());
        for (int i = 1; i <= t; i++) {
            System.out.println("Case #" + i + ": ");
            solve();
        }
    }

    private static void initializePascalTriangle() {
        pascal = new long[LEN][];
        for (int r = 0; r < LEN; r++) {
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

    private static void solve() throws Exception {
        N = Integer.parseInt(br.readLine());
        done = false;
        HashSet<Integer> visited = new HashSet<>();
        ArrayList<Integer> path = new ArrayList<>();
        findPath(0, 0, 0, visited, path, 0);
    }

    private static void findPath(int r, int c, long sum, HashSet<Integer> visited, ArrayList<Integer> path, int step) {
        final int len = LEN + 10;
        if (step > 500 || done) return;

        if (sum == N) {
            done = true;
            for (int pos : path) {
                System.out.println((pos / len + 1) + " " + ((pos % len) + 1));
            }
            return;
        }

        if (r < 0 || r >= pascal.length || c < 0 || c >= pascal[r].length || visited.contains(r * len + c)) return;

        visited.add(r * len + c);
        path.add(r * len + c);

        sum += pascal[r][c];
        step++;

        findPath(r + 1, c, sum, visited, path, step);
        findPath(r + 1, c + 1, sum, visited, path, step);
        findPath(r, c - 1, sum, visited, path, step);
        findPath(r, c + 1, sum, visited, path, step);
        findPath(r - 1, c - 1, sum, visited, path, step);
        findPath(r - 1, c, sum, visited, path, step);

        visited.remove(r * len + c);
        path.remove(path.size() - 1);
    }
}