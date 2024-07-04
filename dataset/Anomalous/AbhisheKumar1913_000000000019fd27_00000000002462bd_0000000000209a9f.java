import java.util.Scanner;

public class Solution {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int t = sc.nextInt();
        sc.nextLine();

        for (int i = 1; i <= t; i++) {
            solve(i);
        }
    }

    public static void solve(int caseNumber) {
        String S = sc.nextLine();
        StringBuilder sb = new StringBuilder();
        char[] chars = S.toCharArray();

        int openBrackets = 0;

        for (char c : chars) {
            int digit = Character.getNumericValue(c);

            while (openBrackets < digit) {
                sb.append('(');
                openBrackets++;
            }

            while (openBrackets > digit) {
                sb.append(')');
                openBrackets--;
            }

            sb.append(digit);
        }

        while (openBrackets > 0) {
            sb.append(')');
            openBrackets--;
        }

        System.out.println("Case #" + caseNumber + ": " + sb.toString());
    }
}