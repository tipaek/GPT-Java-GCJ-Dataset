import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfCases = Integer.parseInt(scanner.nextLine());
        
        for (int caseIndex = 0; caseIndex < numberOfCases; caseIndex++) {
            int numberOfStrings = Integer.parseInt(scanner.nextLine());
            Map<Integer, String> stringMap = new HashMap<>();
            
            for (int stringIndex = 0; stringIndex < numberOfStrings; stringIndex++) {
                String inputString = scanner.nextLine();
                stringMap.put(inputString.length(), inputString.replace("*", ""));
            }
            
            int maxLength = 0;
            for (int length : stringMap.keySet()) {
                if (length > maxLength) {
                    maxLength = length;
                }
            }
            
            String longestString = stringMap.get(maxLength);
            boolean isMatch = true;
            
            for (String value : stringMap.values()) {
                int matchCounter = 1;
                for (int charIndex = value.length() - 1; charIndex >= 0; charIndex--) {
                    if (value.charAt(charIndex) != longestString.charAt(longestString.length() - matchCounter)) {
                        isMatch = false;
                        break;
                    }
                    matchCounter++;
                }
                if (!isMatch) {
                    break;
                }
            }
            
            if (isMatch) {
                System.out.println("Case #" + (caseIndex + 1) + ": " + longestString);
            } else {
                System.out.println("Case #" + (caseIndex + 1) + ": " + "*");
            }
        }
        
        scanner.close();
    }
}