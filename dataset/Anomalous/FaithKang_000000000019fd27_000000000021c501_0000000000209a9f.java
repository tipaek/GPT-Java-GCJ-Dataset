import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        for (int testCase = 1; testCase <= T; testCase++) {
            String s = sc.next();
            StringBuilder answer = new StringBuilder();
            int openBrackets = 0;
            
            int[] digits = new int[s.length()];
            for (int i = 0; i < s.length(); i++) {
                digits[i] = Character.getNumericValue(s.charAt(i));
            }
            
            for (int i = 0; i < s.length(); i++) {
                int currentDigit = digits[i];
                
                if (i == 0) {
                    for (int j = 0; j < currentDigit; j++) {
                        answer.append("(");
                        openBrackets++;
                    }
                    answer.append(s.charAt(i));
                } else {
                    int previousDigit = digits[i - 1];
                    
                    if (previousDigit < currentDigit) {
                        for (int j = 0; j < currentDigit - previousDigit; j++) {
                            answer.append("(");
                            openBrackets++;
                        }
                    } else if (previousDigit > currentDigit) {
                        for (int j = 0; j < previousDigit - currentDigit; j++) {
                            answer.append(")");
                            openBrackets--;
                        }
                    }
                    answer.append(s.charAt(i));
                }
            }
            
            for (int j = 0; j < openBrackets; j++) {
                answer.append(")");
            }
            
            System.out.println("Case #" + testCase + ": " + answer.toString());
        }
        
        sc.close();
    }
}