import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int T = in.nextInt();

        for (int i = 1; i <= T; i++) {
            String s = in.next();

            StringBuilder s1 = new StringBuilder();

            for (int j = 0; j < s.length(); j++) {
                int max = Math.max(0, s.charAt(j) - '0');

                if (j == 0) {
                    s1.append("(".repeat(max));
                    s1.append(s.charAt(j));
                } else if (s.charAt(j) > s.charAt(j - 1)) {
                    s1.append("(".repeat(s.charAt(j) - s.charAt(j - 1)));
                    s1.append(s.charAt(j));
                } else if (s.charAt(j) < s.charAt(j - 1)) {
                    s1.append(")".repeat(s.charAt(j -1 ) - s.charAt(j)));
                    s1.append(s.charAt(j));
                } else if (s.charAt(j) == s.charAt(j-1)) {
                    s1.append(s.charAt(j));
                }

                if (j == s.length() - 1) {
                    s1.append(")".repeat(s.charAt(j) - '0'));
                }
            }

            System.out.println(s1.toString());
        }
    }
}
