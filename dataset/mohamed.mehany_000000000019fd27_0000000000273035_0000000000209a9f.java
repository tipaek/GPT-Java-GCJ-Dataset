import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static String genChar(int num, char c) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < num; ++i) {
            sb.append(c);
        }
        return sb.toString();
    }
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; ++t) {
            String s = br.readLine();
            StringBuffer solution = new StringBuffer();
            solution.append(genChar(Integer.parseInt("" + s.charAt(0)), '('));
            for (int i = 0; i < s.length() - 1; ++i) {
                char brack = '(';
                if (s.charAt(i) > s.charAt(i + 1)) {
                    brack = ')';
                }
                solution.append(s.charAt(i));
                solution.append(genChar(Math.abs(s.charAt(i) - s.charAt(i + 1)), brack));
            }
            solution.append(s.charAt(s.length() - 1));
            solution.append(genChar(Integer.parseInt("" + s.charAt(s.length() - 1)), ')'));
            System.out.println("Case #" + (t + 1) + ": " + solution.toString());
        }
    }
}
