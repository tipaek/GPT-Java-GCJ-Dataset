import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    static class TestCase {
        final int index;
        int x;
        int y;
        String m;
        String result;
        TestCase(int index) {
            this.index = index;
        }



        void solve() {
            int t = 0;
            int currX = x;
            int currY = y;

            for (char c : m.toCharArray()) {
                switch (c) {
                    case 'N':
                        currY++;
                        break;
                    case 'S':
                        currY--;
                        break;
                    case 'E':
                        currX++;
                        break;
                    case 'W':
                        currX--;
                        break;
                    default:
                        break;
                }

                if (Math.abs(currX) + Math.abs(currY) <= t) {
                    result = Integer.toString(t);
                    break;
                }
                t++;
            }

            if (result == null) {
                result = "IMPOSSIBLE";
            }

            System.out.println("Case #" + index + ": " + result);
        }
    }

    Solution.TestCase readTestCase(Scanner in, int index) {
        Solution.TestCase tc = new Solution.TestCase(index);
        tc.x = in.nextInt();
        tc.y = in.nextInt();
        tc.m = in.nextLine();
        return tc;
    }

    void run() {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            readTestCase(in, i).solve();
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.run();
    }
}
