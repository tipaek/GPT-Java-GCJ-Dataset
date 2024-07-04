import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        
        for (int k = 0; k < t; k++) {
            int n = scanner.nextInt();
            List<String> reversedStrings = new ArrayList<>();
            int maxLength = 0;
            
            for (int i = 0; i < n; i++) {
                String reversed = new StringBuilder(scanner.next()).reverse().toString();
                maxLength = Math.max(maxLength, reversed.length());
                reversedStrings.add(reversed);
            }
            
            StringBuilder result = new StringBuilder();
            int position = 0;
            boolean isMismatch = false;
            
            while (!reversedStrings.isEmpty()) {
                char currentChar = '8';
                
                for (int j = 0; j < reversedStrings.size(); j++) {
                    String currentString = reversedStrings.get(j);
                    
                    if (position >= currentString.length() || currentString.charAt(position) == '*') {
                        reversedStrings.remove(j);
                        j--; // Adjust index after removal
                    } else {
                        char charAtPosition = currentString.charAt(position);
                        
                        if (currentChar == '8') {
                            currentChar = charAtPosition;
                        } else if (currentChar != charAtPosition) {
                            isMismatch = true;
                            break;
                        }
                    }
                }
                
                if (isMismatch || position == maxLength) {
                    break;
                }
                
                result.append(currentChar);
                position++;
            }
            
            if (isMismatch) {
                System.out.println("Case #" + (k + 1) + ": *");
            } else {
                System.out.println("Case #" + (k + 1) + ": " + result.reverse().toString());
            }
        }
        
        scanner.close();
    }
}