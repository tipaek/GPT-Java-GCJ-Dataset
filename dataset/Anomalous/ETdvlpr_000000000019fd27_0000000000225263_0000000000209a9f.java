import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numCases = Integer.parseInt(scanner.nextLine());
        String[] inputLines = new String[numCases];
        
        for (int i = 0; i < numCases; i++) {
            inputLines[i] = scanner.nextLine();
        }
        
        Solution solution = new Solution();
        for (int i = 0; i < numCases; i++) {
            System.out.println(solution.formatOutput(inputLines[i], i + 1));
        }
    }

    public String formatOutput(String input, int caseNumber) {
        StringBuilder formattedString = new StringBuilder();
        int currentDepth = 0;
        
        for (char ch : input.toCharArray()) {
            int digit = Character.getNumericValue(ch);
            
            while (currentDepth > digit) {
                formattedString.append(")");
                currentDepth--;
            }
            
            while (currentDepth < digit) {
                formattedString.append("(");
                currentDepth++;
            }
            
            formattedString.append(ch);
        }
        
        while (currentDepth > 0) {
            formattedString.append(")");
            currentDepth--;
        }
        
        return String.format("Case #%d: %s", caseNumber, formattedString.toString());
    }
}