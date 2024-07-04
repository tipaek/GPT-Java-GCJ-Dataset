import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Solution {
    public static void main(String[] args) {
        Scanner s = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = s.nextInt();
        s.nextLine();
        for (int t = 1; t <= testCases; t++) {
            String str = s.nextLine();
            String result = solve(str);

            System.out.format("Case #%d: %s\n", t, result);
        }
    }

    private static String solve(String str) {
        StringBuilder result = new StringBuilder();
        int cur = 0;
        for (char c : str.toCharArray()) {
            int desired = c - '0';
            IntStream.range(cur, desired).forEach(i -> result.append('('));
            IntStream.range(desired, cur).forEach(i -> result.append(')'));
            result.append(c);
            cur = desired;
        }
        IntStream.range(0, cur).forEach(i -> result.append(')'));
        return result.toString();
    }


}