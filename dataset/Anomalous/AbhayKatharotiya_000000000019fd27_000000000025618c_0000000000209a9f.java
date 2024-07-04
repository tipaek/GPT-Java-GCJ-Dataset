import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        List<String> results = new ArrayList<>();
        int testCases = scanner.nextInt();
        scanner.nextLine();
        
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            String input = scanner.nextLine();
            StringBuilder resultBuilder = new StringBuilder();
            int currentDepth = 0;
            
            for (char ch : input.toCharArray()) {
                int digit = Character.getNumericValue(ch);
                
                while (currentDepth < digit) {
                    resultBuilder.append('(');
                    currentDepth++;
                }
                while (currentDepth > digit) {
                    resultBuilder.append(')');
                    currentDepth--;
                }
                
                resultBuilder.append(ch);
            }
            
            while (currentDepth > 0) {
                resultBuilder.append(')');
                currentDepth--;
            }
            
            results.add("Case #" + caseNumber + ": " + resultBuilder.toString());
        }
        
        for (String result : results) {
            System.out.println(result);
        }
    }
}