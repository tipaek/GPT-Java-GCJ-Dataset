import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine());
        
        for (int i = 1; i <= testCases; i++) {
            System.out.print("Case #" + i + ": ");
            String input = reader.readLine();
            int currentDepth = 0;
            StringBuilder output = new StringBuilder();
            
            for (char ch : input.toCharArray()) {
                int digit = Character.getNumericValue(ch);
                
                while (currentDepth < digit) {
                    output.append("(");
                    currentDepth++;
                }
                while (currentDepth > digit) {
                    output.append(")");
                    currentDepth--;
                }
                
                output.append(digit);
            }
            
            while (currentDepth > 0) {
                output.append(")");
                currentDepth--;
            }
            
            System.out.println(output.toString());
        }
    }
}