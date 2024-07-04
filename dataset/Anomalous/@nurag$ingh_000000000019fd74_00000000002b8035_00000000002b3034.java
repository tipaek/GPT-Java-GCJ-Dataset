import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        
        for (int k = 0; k < t; k++) {
            int n = scanner.nextInt();
            List<String> words = new ArrayList<>();
            int maxLength = 0;
            
            for (int i = 0; i < n; i++) {
                String reversedWord = new StringBuilder(scanner.next()).reverse().toString();
                maxLength = Math.max(maxLength, reversedWord.length());
                words.add(reversedWord);
            }
            
            StringBuilder result = new StringBuilder();
            int position = 0;
            boolean isMismatch = false;
            
            while (!words.isEmpty()) {
                char currentChar = '8';
                
                for (int j = 0; j < words.size(); j++) {
                    String word = words.get(j);
                    
                    if (word.length() <= position || word.charAt(position) == '*') {
                        words.remove(j);
                        j--;
                    } else {
                        char charAtPos = word.charAt(position);
                        
                        if (currentChar == '8') {
                            currentChar = charAtPos;
                        } else if (currentChar != charAtPos) {
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
                
                if (result.length() == 10000) {
                    break;
                }
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