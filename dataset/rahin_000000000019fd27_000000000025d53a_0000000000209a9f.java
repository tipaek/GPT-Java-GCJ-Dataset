import java.util.Scanner;

public class Solution {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String args[]) {

        int testCase = scanner.nextInt();

        for (int i = 1; i <= testCase; i++) {
            String s = scanner.next();
            solution(s, testCase);
        }

    }

    public static void solution(String s, int testCase) {

        boolean temp = false;

        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == '1') {
                if (!temp) {
                    temp = true;
                    ans.append("(");
                }
                ans.append(s.charAt(i));
            } else if (s.charAt(i) == '0') {
                if (temp) {
                    temp = false;
                    ans.append(")");
                }
                ans.append(s.charAt(i));
            }
        }
        if (s.charAt(s.length() - 1) == '1')
            ans.append(")");

        System.out.println("Case #" + testCase + ": " + ans);

    }

}
