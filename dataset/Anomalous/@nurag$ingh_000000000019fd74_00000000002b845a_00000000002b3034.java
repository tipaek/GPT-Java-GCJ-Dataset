import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        
        for (int k = 0; k < t; k++) {
            int n = in.nextInt();
            List<String> reversedStrings = new ArrayList<>();
            int maxLength = 0;
            
            for (int i = 0; i < n; i++) {
                String reversed = new StringBuilder(in.next()).reverse().toString();
                maxLength = Math.max(maxLength, reversed.length());
                reversedStrings.add(reversed);
            }
            
            StringBuilder result = new StringBuilder();
            int count = 0;
            boolean mismatchFound = false;
            
            while (!reversedStrings.isEmpty()) {
                char currentChar = '8';
                
                for (int j = 0; j < reversedStrings.size(); j++) {
                    String currentString = reversedStrings.get(j);
                    
                    if (currentString.length() <= count) {
                        mismatchFound = true;
                        break;
                    }
                    
                    char charAtCount = currentString.charAt(count);
                    
                    if (charAtCount == '*') {
                        reversedStrings.remove(j);
                        j--; // Adjust index after removal
                    } else if (currentChar == '8') {
                        currentChar = charAtCount;
                    } else if (currentChar != charAtCount) {
                        mismatchFound = true;
                        break;
                    }
                }
                
                if (mismatchFound || count == maxLength || result.length() == 10000) {
                    break;
                }
                
                result.append(currentChar);
                count++;
            }
            
            if (mismatchFound) {
                System.out.println("Case #" + (k + 1) + ": *");
            } else {
                System.out.println("Case #" + (k + 1) + ": " + result.reverse().toString());
            }
        }
        
        in.close();
    }
}