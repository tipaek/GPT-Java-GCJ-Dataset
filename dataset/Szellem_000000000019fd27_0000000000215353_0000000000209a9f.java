import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    static class TestCase {
        final int index;
        StringBuilder sb = new StringBuilder();

        TestCase(int index) {
            this.index = index;
        }

        void solve() {

            System.out.println("Case #" + index + " " + sb.toString());
        }
    }

    Solution.TestCase readTestCase(Scanner in, int index) {
        Solution.TestCase tc = new Solution.TestCase(index);

        int[] input = in.nextLine().chars().map(Character::getNumericValue).toArray();

        int currentLevel = 0;

        for (int i : input) {
            while (currentLevel < i) {
                tc.sb.append('(');
                currentLevel++;
            }

            while (currentLevel > i) {
                tc.sb.append(')');
                currentLevel--;
            }
            tc.sb.append(i);
        }

        while (currentLevel > 0) {
            tc.sb.append(')');
            currentLevel--;
        }

        return tc;
    }

    void run() {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        in.nextLine();
        for (int i = 1; i <= t; ++i) {
            readTestCase(in, i).solve();
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.run();
    }
}
