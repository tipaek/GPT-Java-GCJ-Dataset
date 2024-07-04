import java.util.Scanner;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int t = 0; t < testCases; t++) {
            int n = scanner.nextInt();
            String matchingResult = "";
            
            for (int i = 0; i < n / 2; i++) {
                String patternStr = "." + scanner.next();
                String textStr = "." + scanner.next();
                
                if (Pattern.matches(patternStr, textStr)) {
                    matchingResult = textStr;
                }
            }
            
            if (matchingResult.isEmpty()) {
                System.out.println("*");
            } else {
                System.out.println(matchingResult.substring(1));
            }
        }
        
        scanner.close();
    }
}