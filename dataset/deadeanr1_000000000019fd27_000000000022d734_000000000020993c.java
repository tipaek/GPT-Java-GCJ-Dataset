
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.

        int[][] M;
        boolean[] visited;
        int k, r, c;
        Set<Integer> s1 = new HashSet<>();

        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            M = new int[n][n];
            k = 0;
            r = 0;
            c = 0;
            visited = new boolean[n];
            for (int y = 0; y < n; y++) {
                for (int x = 0; x < n; x++) {
                    M[y][x] = in.nextInt();
                }
                k += M[y][y];
            }
            for (int y = 0; y < n; y++) {
                Arrays.fill(visited, false);
                for (int x = 0; x < n; x++) {
                    final int v = M[x][y]-1;
                    if (visited[v]) {
                        r++;
                        break;
                    }
                    visited[v]=true;
                }
            }
            for (int x = 0; x < n; x++) {
                Arrays.fill(visited, false);
                for (int y = 0; y < n; y++) {
                    final int v = M[x][y]-1;
                    if (visited[v]) {
                        c++;
                        break;
                    }
                    visited[v]=true;
                }
            }


            System.out.println("Case #" + i + ": " + k + " " + r + " " + c);
        }
    }
}
