import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 0; t < T; t++) {
            System.out.println(insertParenthesis(sc.next()));
        }
        sc.close();
    }

    static String insertParenthesis(String S) {
        StringBuilder sb = new StringBuilder();
        int currentDepth = 0;

        for (char ch : S.toCharArray()) {
            int digit = ch - '0';
            while (currentDepth < digit) {
                sb.append('(');
                currentDepth++;
            }
            while (currentDepth > digit) {
                sb.append(')');
                currentDepth--;
            }
            sb.append(ch);
        }

        while (currentDepth > 0) {
            sb.append(')');
            currentDepth--;
        }

        return sb.toString();
    }
}