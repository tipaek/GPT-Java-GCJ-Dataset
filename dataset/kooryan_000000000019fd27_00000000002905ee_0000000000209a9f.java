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
                    for (int a = 0; a < max; a++) {
                        s1.append("(");
                    }
                    s1.append(s.charAt(j));
                } else if (s.charAt(j) > s.charAt(j - 1)) {
                    for (int b = 0; b < s.charAt(j) - s.charAt(j-1); b++) {
                        s1.append("(");
                    }
                    s1.append(s.charAt(j));
                } else if (s.charAt(j) < s.charAt(j - 1)) {
                    for (int c = 0; c  < s.charAt(j-1) - s.charAt(j); c++) {
                        s1.append(")");
                    }
                    s1.append(s.charAt(j));
                } else if (s.charAt(j) == s.charAt(j-1)) {
                    s1.append(s.charAt(j));
                }

                if (j == s.length() - 1) {
                    for (int d = 0; d < s.charAt(j) - '0'; d++) {
                        s1.append(")");
                    }
                }
            }

            System.out.println("case #" + i + ": " + s1.toString());
        }
    }
}
