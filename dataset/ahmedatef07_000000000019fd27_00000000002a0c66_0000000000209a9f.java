import java.util.BitSet;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int testCases = Integer.parseInt(sc.nextLine());
        int caseCounter = 0;

        while (caseCounter++ < testCases) {
            String s = sc.nextLine();
            s = sanitaize(s);

            StringBuilder sb = new StringBuilder();
            int open = 0;

            for(char c : s.toCharArray()) {
                int n = c - '0';

                for (int i = 0; i < n - open; i++) sb.append('(');
                for (int i = 0; i < open - n; i++) sb.append(')');
                sb.append(c);

                open = n;
            }

            for (int i = 0; i < open; i++) sb.append(')');

            System.out.printf("Case #%d: %s\n", caseCounter, sb.toString());
        }
    }

    private static String sanitaize(String s) {
        StringBuilder sb = new StringBuilder();
        for(char c : s.toCharArray()) {
            if (Character.isDigit(c)) sb.append(c);
        }
        return sb.toString();
    }
}
