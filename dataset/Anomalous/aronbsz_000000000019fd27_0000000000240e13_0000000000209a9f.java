import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        sc.nextLine();
        
        for (int i = 0; i < testCases; i++) {
            String num = sc.nextLine();
            StringBuilder result = new StringBuilder();
            int openParentheses = 0;
            
            for (int j = 0; j < num.length(); j++) {
                int currDigit = num.charAt(j) - '0';
                int prevDigit = j > 0 ? num.charAt(j - 1) - '0' : 0;
                
                if (currDigit > prevDigit) {
                    for (int k = 0; k < currDigit - prevDigit; k++) {
                        result.append('(');
                        openParentheses++;
                    }
                } else if (currDigit < prevDigit) {
                    for (int k = 0; k < prevDigit - currDigit; k++) {
                        result.append(')');
                        openParentheses--;
                    }
                }
                
                result.append(currDigit);
            }
            
            while (openParentheses > 0) {
                result.append(')');
                openParentheses--;
            }
            
            System.out.println("Case #" + (i + 1) + ": " + result);
        }
        
        sc.close();
    }
}