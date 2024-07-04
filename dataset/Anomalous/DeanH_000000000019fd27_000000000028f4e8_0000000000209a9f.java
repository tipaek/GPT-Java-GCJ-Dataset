import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int i = 1; i <= testCases; ++i) {
            String number = scanner.next();
            StringBuilder result = new StringBuilder();
            
            int previousDigit = 0;
            
            for (char ch : number.toCharArray()) {
                int currentDigit = Character.getNumericValue(ch);
                
                while (previousDigit < currentDigit) {
                    result.append("(");
                    previousDigit++;
                }
                
                while (previousDigit > currentDigit) {
                    result.append(")");
                    previousDigit--;
                }
                
                result.append(currentDigit);
            }
            
            while (previousDigit > 0) {
                result.append(")");
                previousDigit--;
            }
            
            System.out.println("Case #" + i + ": " + result.toString());
        }
        
        scanner.close();
    }
}