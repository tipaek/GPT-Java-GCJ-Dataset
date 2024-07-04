import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        StringBuilder result = new StringBuilder();
        
        for (int i = 1; i <= testCases; i++) {
            char[] inputChars = scanner.next().toCharArray();
            LinkedList<Character> outputList = new LinkedList<>();
            int currentDepth = 0;
            
            for (char ch : inputChars) {
                int targetDepth = ch - '0';
                
                while (currentDepth < targetDepth) {
                    outputList.add('(');
                    currentDepth++;
                }
                while (currentDepth > targetDepth) {
                    outputList.add(')');
                    currentDepth--;
                }
                
                outputList.add(ch);
            }
            
            while (currentDepth > 0) {
                outputList.add(')');
                currentDepth--;
            }
            
            result.append("Case #").append(i).append(": ");
            for (char ch : outputList) {
                result.append(ch);
            }
            result.append("\n");
        }
        
        System.out.print(result.toString());
    }
}