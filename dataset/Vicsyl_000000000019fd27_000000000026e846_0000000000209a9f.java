import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Solution {

    public static void solve(String s, int caze) {

        char[] ls = new char[10];
        char[] rs = new char[10];
        Arrays.fill(ls, '(');
        Arrays.fill(rs, ')');
        String leftPars = String.valueOf(ls);
        String rightPars = String.valueOf(rs);

        int left_counter = 0;
        String solution = "";
        for (int i = 0; i < s.length(); i++) {
            int parsed = Integer.parseInt(s.substring(i, i + 1));
            if (left_counter < parsed) {
                solution += leftPars.substring(0, parsed - left_counter) + parsed;
                left_counter = parsed;
            } else if (left_counter > parsed) {
                solution += rightPars.substring(0, left_counter - parsed) + parsed;
                left_counter = parsed;
            } else {
                solution += parsed;
            }
        }
        if (left_counter > 0) {
            solution += rightPars.substring(0, left_counter);
        }

        System.out.println("Case #" + caze + ": " + String.valueOf(solution));
    }

    public static void main(String... args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String line = reader.readLine();
        int cases = Integer.parseInt(line.trim());
        for (int i = 0; i < cases; i++) {
            line = reader.readLine().trim();
            solve(line, i + 1);
        }

    }
}
