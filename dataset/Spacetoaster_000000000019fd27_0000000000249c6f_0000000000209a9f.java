import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static String parantheses(String S, int depth) {
        StringBuilder S2 = new StringBuilder();
        int i = 0;
        while (i < S.length()) {
            if (S.charAt(i) != Character.forDigit(depth, 10)) {
                int j = i;
                while (j + 1 < S.length() && S.charAt(j + 1) != Character.forDigit(depth, 10)) {
                    j++;
                }
                S2.append("(" + parantheses(S.substring(i, j + 1), depth + 1) + ")");
                i = j + 1;
            } else {
                S2.append(Character.forDigit(depth, 10));
                i++;
            }
        }
        return S2.toString();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = Integer.parseInt(in.nextLine());
        for (int i = 1; i <= t; ++i) {
            String S = in.nextLine();
            String S2 = parantheses(S, 0);
            System.out.println("Case #" + i + ": " + S2);
        }
    }
}
