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
            List<String> s = solve2(N);
            //System.out.println("Case #" + i + ": " + s.size());
            for (String step : s) {
                System.out.println(step);
            }
        }
    }

    private static List<String> solve2(int N) {
        List<String> res = new ArrayList<>();
        res.add("1 1");
        if (N == 1) return res;
        if (N == 2) {
            res.add("2 1");
            return res;
        }

        int base = (int)Math.sqrt(N);
        if (Math.pow(2, base) + base > N) {
            base--;
        }

        //go down to our row
        int r = 2;
        int sum = 1;
        while (r < base + 1 && sum < N) {
            res.add(String.format("%s %s", r, 1));
            r++;
            sum++;
        }

        //process our row
        sum += (int)Math.pow(2, base);
        int col = 1;
        while (col < r + 1) {
            res.add(String.format("%s %s", r, col));
            col++;
        }

        while (sum < N) {
            res.add(String.format("%s %s", ++r, col));
            col++;
            sum++;
        }

        return res;
    }
}
