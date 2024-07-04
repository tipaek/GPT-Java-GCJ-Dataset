import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int i = 1; i <= testCases; i++) {
            int N = scanner.nextInt();
            scanner.nextLine(); // Consume the remaining newline
            String[] patterns = new String[N];
            
            for (int j = 0; j < N; j++) {
                patterns[j] = scanner.nextLine();
            }
            
            String longestPattern = "";
            for (String pattern : patterns) {
                if (pattern.length() > longestPattern.length()) {
                    longestPattern = pattern;
                }
            }
            
            for (int j = 0; j < N; j++) {
                patterns[j] = patterns[j].substring(1);
            }
            
            longestPattern = longestPattern.substring(1);
            boolean isMatch = true;
            String result = longestPattern;
            
            for (String pattern : patterns) {
                if (!longestPattern.contains(pattern)) {
                    isMatch = false;
                    break;
                }
            }
            
            if (!isMatch) {
                result = "*";
            }
            
            System.out.println("Case #" + i + ": " + result);
        }
        
        scanner.close();
    }
}