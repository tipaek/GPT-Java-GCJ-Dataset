import java.io.*;
import java.util.*;

public class Solution {
    static BufferedReader in;
    public static void main(String[] args) throws Exception {
        in = new BufferedReader(
                new InputStreamReader(System.in)
        );
        int T = Integer.parseInt(in.readLine());
        for (int x = 0; x++ < T;) {
            int N = Integer.parseInt(in.readLine());
            List<String> steps = solve(N);
            System.out.printf("Case #%d:\n", x);
            for (String step : steps) {
                System.out.println(step);
            }
        }
    }

    static List<String> solve(int N) {
        List<String> steps = new ArrayList<>();
        int r = 2, k = 2, v = 1, sum = 1;
        steps.add("1 1");
        while (sum + v <= N && steps.size() < 500) {
            steps.add(r + " " + k);
            sum += v;
            r++;
            v++;
        }
        r--;
        k--;
        while (sum < N && steps.size() < 500) {
            steps.add(r + " " + k);
            sum++;
            r++;
        }
        return steps;
    }
}