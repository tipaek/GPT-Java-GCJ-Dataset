import java.util.*;

public class Solution {
    
    static Scanner scanner = new Scanner(System.in);
    
    static String findCommonSuffix(String[] arr) {
        int maxLength = 0;
        String longestString = "";
        String result = "";
        
        // Find the longest string in the array
        for (String s : arr) {
            if (s.length() > maxLength) {
                maxLength = s.length();
                longestString = s;
            }
        }
        
        char[] longestArr = longestString.toCharArray();
        
        // Check if all strings have the same suffix as the longest string
        for (String s : arr) {
            char[] currentArr = s.toCharArray();
            int currentLength = currentArr.length;
            
            for (int i = 1; i < currentLength; ++i) {
                if (currentArr[i] != longestArr[i + maxLength - currentLength]) {
                    return "*";
                }
            }
        }
        
        // Construct the result string which is the common suffix
        for (int i = 1; i < maxLength; ++i) {
            result += longestArr[i];
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        int testCases = scanner.nextInt();
        
        for (int i = 1; i <= testCases; ++i) {
            int numStrings = scanner.nextInt();
            String[] arr = new String[numStrings];
            
            for (int j = 0; j < numStrings; ++j) {
                arr[j] = scanner.next();
            }
            
            String result = findCommonSuffix(arr);
            System.out.printf("Case #%d: %s\n", i, result);
        }
        
        scanner.close();
    }
}