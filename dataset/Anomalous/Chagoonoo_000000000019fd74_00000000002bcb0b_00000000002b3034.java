import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int testCases = scanner.nextInt();
        for (int i = 0; i < testCases; i++) {
            int n = scanner.nextInt();
            String[] substrings = new String[n];
            String longestSubstring = "";
            
            for (int j = 0; j < n; j++) {
                String substring = scanner.next().substring(1);
                substrings[j] = substring;
                if (substring.length() > longestSubstring.length()) {
                    longestSubstring = substring;
                }
            }
            
            boolean isValid = true;
            for (String substring : substrings) {
                if (!longestSubstring.endsWith(substring)) {
                    isValid = false;
                    break;
                }
            }
            
            if (isValid) {
                System.out.println("Case #" + (i + 1) + ": " + longestSubstring);
            } else {
                System.out.println("Case #" + (i + 1) + ": *");
            }
        }
        
        scanner.close();
    }
}