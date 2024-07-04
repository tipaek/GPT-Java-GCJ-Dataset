import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int T = scanner.nextInt();
        for (int i = 0; i < T; i++) {
            String S = scanner.next();
            String result = processString(S);
            System.out.printf("Case #%d: %s\n", i + 1, result);
        }
    }
    
    public static String processString(String S) {
        int n = S.length();
        int[] digits = new int[n];
        
        for (int i = 0; i < n; i++) {
            digits[i] = Character.getNumericValue(S.charAt(i));
        }
        
        StringBuilder sb = new StringBuilder();
        int openBrackets = digits[0];
        
        for (int i = 0; i < openBrackets; i++) {
            sb.append('(');
        }
        sb.append(digits[0]);
        
        for (int i = 1; i < n; i++) {
            if (digits[i] > digits[i - 1]) {
                int diff = digits[i] - digits[i - 1];
                for (int j = 0; j < diff; j++) {
                    sb.append('(');
                }
                openBrackets += diff;
            } else if (digits[i] < digits[i - 1]) {
                int diff = digits[i - 1] - digits[i];
                for (int j = 0; j < diff; j++) {
                    sb.append(')');
                }
                openBrackets -= diff;
            }
            sb.append(digits[i]);
        }
        
        for (int i = 0; i < openBrackets; i++) {
            sb.append(')');
        }
        
        return sb.toString();
    }
}