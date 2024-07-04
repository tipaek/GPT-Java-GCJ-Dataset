import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCaseCount = scanner.nextInt();
        
        for (int caseNumber = 1; caseNumber <= testCaseCount; caseNumber++) {
            String inputString = scanner.next();
            StringBuilder output = new StringBuilder();
            
            List<Integer> digits = new ArrayList<>();
            for (char ch : inputString.toCharArray()) {
                digits.add(Character.getNumericValue(ch));
            }
            
            int currentDepth = 0;
            for (int digit : digits) {
                while (currentDepth < digit) {
                    output.append('(');
                    currentDepth++;
                }
                while (currentDepth > digit) {
                    output.append(')');
                    currentDepth--;
                }
                output.append(digit);
            }
            
            while (currentDepth > 0) {
                output.append(')');
                currentDepth--;
            }
            
            System.out.println("Case #" + caseNumber + ": " + output.toString());
        }
    }
}