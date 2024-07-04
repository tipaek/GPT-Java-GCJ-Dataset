import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        
        for (int testCase = 1; testCase <= T; testCase++) {
            String s = scanner.next();
            List<Character> result = new ArrayList<>();
            int currentOpenBrackets = 0;
            
            for (char ch : s.toCharArray()) {
                int digit = Character.getNumericValue(ch);
                int openBracketsToAdd = Math.max(0, digit - currentOpenBrackets);
                int closeBracketsToAdd = Math.max(0, currentOpenBrackets - digit);
                
                for (int i = 0; i < openBracketsToAdd; i++) {
                    result.add('(');
                }
                for (int i = 0; i < closeBracketsToAdd; i++) {
                    result.add(')');
                }
                
                result.add(ch);
                currentOpenBrackets = digit;
            }
            
            for (int i = 0; i < currentOpenBrackets; i++) {
                result.add(')');
            }
            
            System.out.print("Case #" + testCase + ": ");
            for (char ch : result) {
                System.out.print(ch);
            }
            System.out.println();
        }
        
        scanner.close();
    }
}