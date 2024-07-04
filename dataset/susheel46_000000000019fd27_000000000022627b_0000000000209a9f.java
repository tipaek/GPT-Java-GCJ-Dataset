import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        String[] solutions = new String[T];
        for (int i = 0; i < T; i++) {

            String s = sc.next();
            solutions[i] = addParenthesis(s);
        }

        for (int i = 0; i < T; i++) {
            System.out.println("Case #" + (i + 1) + ": " + solutions[i]);
        }
    }

    private static String addParenthesis(String s) {
        int left = 0, right = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            int n = Integer.parseInt(String.valueOf(s.charAt(i)));
            if (n - left > 0) {
                for (int j = 0; j < n - left; j++) sb.append("(");
                left = n;
            } else if (n - left < 0) {
                for (int j = 0; j < left - n; j++) sb.append(")");
                left = n;
            }
            sb.append(s.charAt(i));
        }
        if(left>0){
            for (int j = 0; j < left; j++) sb.append(")");
        }
        return sb.toString();
    }
}
