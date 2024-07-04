//package codejam.y2020.qualification;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        Solution solution = new Solution();
        for (int i = 1; i <= T ; i++) {
            String S = scanner.next();
            String nestedMatch = solution.getNestedMatch(S);
            System.out.println("Case #"+i+": "+nestedMatch);
        }
    }

    private String getNestedMatch(String s) {
        String nested = "";
        int opening = 0;
        for (int i = 0; i < s.length(); i++) {
            int number = s.charAt(i) - '0';
            if (opening > number) {
                int closing = opening - number;
                for (int j = 0; j < closing; j++) {
                    nested += ')';
                }
                opening = number;
            } else if (opening < number) {
                int remaining = number - opening;
                for (int j = 0; j < remaining; j++) {
                    nested += '(';
                }
                opening += remaining;
            }
            nested += number;
        }
        for (int i = 0; i < opening; i++) {
            nested += ')';
        }
        return nested;
    }
}
