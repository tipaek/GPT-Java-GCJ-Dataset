import java.util.*;
import java.io.*;

class Solution {
        public static void main(String[] args) {
            Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
            int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
            for (int i = 1; i <= t; ++i) {
                int n = in.nextInt();
                String ans = solve(n, in);
                System.out.println("Case #" + i + ": " + ans);
            }
        }

        public static String solve(int n, Scanner in) {
            String ans = "";
            int sum = 0;
            int row = 0;
            int col = 0;
            int[][] input = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    input[i][j] = in.nextInt();
                }
            }
            for (int i = 0; i < n; i++) {
                sum += input[i][i];
            }
            for (int i = 0; i < n; i++) {
                HashSet<Integer> rSet = new HashSet();
                HashSet<Integer> cSet = new HashSet();
                for (int j = 0; j < n; j++) {
                    rSet.add(input[i][j]);
                    cSet.add(input[j][i]);
                }
                row += rSet.size() == n ? 0 : 1;
                col += cSet.size() == n ? 0 : 1;
            }
            return sum + " " + row + " " + col;
        }
    }