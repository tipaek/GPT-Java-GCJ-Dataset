import java.util.Scanner;

public class Solution {
    
    private static String getNestedString(String S) {
        StringBuilder builder = new StringBuilder();
        int firstDigit = Character.getNumericValue(S.charAt(0));
        int N = S.length();
        for(int i = 0; i < firstDigit; i++) {
            builder.append("(");   
        }
        builder.append(S.charAt(0));
        for (int i = 1; i < N; i++) {
            int prev = Character.getNumericValue(S.charAt(i-1));
            int cur = Character.getNumericValue(S.charAt(i));
            int numClosingParens = Math.max(prev - cur, 0);
            int numOpenParens = Math.max(cur - prev, 0);
            for(int j = 0; j < numClosingParens; j++) {
                builder.append(")");
            }
            for(int j = 0; j < numOpenParens; j++) {
                builder.append("(");
            }
            builder.append(S.charAt(i));
        }
        int lastDigit = Character.getNumericValue(S.charAt(N-1));
        for(int j = 0; j < lastDigit; j++) {
            builder.append(")");
        }
        return builder.toString();
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine();
        for (int test = 1; test <= T; test++) {
            String S = sc.nextLine();
            System.out.printf("Case #%d: %s\n", test, getNestedString(S));
        }
        sc.close();
    }
}