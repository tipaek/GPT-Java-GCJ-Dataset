import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int numberOfStrings = scanner.nextInt();
            String[] strings = new String[numberOfStrings];
            String longestWord = "";
            int maxLength = 0;
            
            for (int i = 0; i < numberOfStrings; i++) {
                strings[i] = removeCharAt(scanner.next(), 0);
                if (strings[i].length() > maxLength) {
                    longestWord = strings[i];
                    maxLength = strings[i].length();
                }
            }
            
            boolean isMatch = true;
            for (String str : strings) {
                if (!isSuffix(longestWord, str)) {
                    longestWord = "*";
                    isMatch = false;
                    break;
                }
            }
            
            System.out.println("Case #" + caseNumber + ": " + longestWord);
        }
        
        scanner.close();
    }
    
    private static boolean isSuffix(String longer, String shorter) {
        int longerLength = longer.length();
        int shorterLength = shorter.length();
        
        if (shorterLength > longerLength) {
            return false;
        }
        
        for (int i = 1; i <= shorterLength; i++) {
            if (longer.charAt(longerLength - i) != shorter.charAt(shorterLength - i)) {
                return false;
            }
        }
        
        return true;
    }

    private static String removeCharAt(String str, int index) {
        return str.substring(0, index) + str.substring(index + 1);
    }
}