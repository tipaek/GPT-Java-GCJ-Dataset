import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int testCase = 1; testCase <= T; testCase++) {
            String input = scanner.next();
            StringBuilder result = new StringBuilder();
            int currentOpen = 0;
            
            for (char ch : input.toCharArray()) {
                int digit = Character.getNumericValue(ch);
                while (currentOpen < digit) {
                    result.append("(");
                    currentOpen++;
                }
                while (currentOpen > digit) {
                    result.append(")");
                    currentOpen--;
                }
                result.append(digit);
            }
            
            while (currentOpen > 0) {
                result.append(")");
                currentOpen--;
            }
            
            System.out.println("Case #" + testCase + ": " + result.toString());
        }
    }
}