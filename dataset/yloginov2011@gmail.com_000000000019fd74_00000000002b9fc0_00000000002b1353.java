import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int N = in.nextInt();

            System.out.println("Case #" + i + ": ");
            List<String> s = solve(N);
            for (String step : s) {
                System.out.println(step);
            }
        }
    }

    private static List<String> solve(int N) {
        int p = 0;
        int sum = (int)Math.pow(2, p);
        boolean go_right = true;
        List<String> res = new ArrayList<>();
        res.add("1 1");
        while (sum < N) {
            p++;
            int next = (int)Math.pow(2, p);
            int col = go_right ? 1 : p + 1;
            int row = p + 1;
            if (sum + next > N) {
                while (sum < N) {
                    res.add(String.format("%s %s", row, col));
                    sum++;
                    row++;
                    if (!go_right) {
                        col++;
                    }
                }
            } else {
                if (go_right) {
                    while (col <= p + 1) {
                        res.add(String.format("%s %s", row, col));
                        col++;
                    }
                } else {
                    while (col >= 1) {
                        res.add(String.format("%s %s", row, col));
                        col--;
                    }
                }
                go_right = !go_right;
            }
            sum += next;
        }

        return res;
    }
}
