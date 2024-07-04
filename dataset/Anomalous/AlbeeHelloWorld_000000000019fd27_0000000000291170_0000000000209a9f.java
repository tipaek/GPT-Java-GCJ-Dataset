import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        String[] leftBrackets = {"", "(", "((", "(((", "((((", "(((((", "((((((", "(((((((", "((((((((", "((((((((("};
        String[] rightBrackets = {"", ")", "))", ")))", "))))", ")))))", "))))))", ")))))))", "))))))))", ")))))))))"};
        
        Scanner scanner = createScanner();
        int testCases = Integer.parseInt(scanner.nextLine());
        
        for (int i = 0; i < testCases; i++) {
            String line = scanner.nextLine();
            StringBuilder output = new StringBuilder();
            int previous = 0;
            
            for (int j = 0; j < line.length(); j++) {
                int current = Character.getNumericValue(line.charAt(j));
                
                if (current > previous) {
                    output.append(leftBrackets[current - previous]);
                } else if (current < previous) {
                    output.append(rightBrackets[previous - current]);
                }
                
                output.append(current);
                
                if (j == line.length() - 1) {
                    output.append(rightBrackets[current]);
                }
                
                previous = current;
            }
            
            System.out.println("Case #" + (i + 1) + ": " + output.toString());
        }
    }
    
    static Scanner createScanner() throws Exception {
        return new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        // return new Scanner(new File("input.txt"));
    }
}