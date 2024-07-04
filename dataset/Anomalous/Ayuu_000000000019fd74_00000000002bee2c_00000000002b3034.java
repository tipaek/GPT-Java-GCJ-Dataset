import java.util.*;
import java.util.regex.*;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            int n = scanner.nextInt();
            String result = "";
            
            for (int i = 0; i < n / 2; i++) {
                String pattern1 = "." + scanner.next();
                String pattern2 = "." + scanner.next();
                boolean matches = Pattern.matches(pattern1, pattern2);
                
                if (matches) {
                    result = pattern2;
                }
            }
            
            if (result.isEmpty()) {
                System.out.println("Case #" + caseNum + ": *");
            } else {
                System.out.println("Case #" + caseNum + ": " + result.substring(1));
            }
        }
        
        scanner.close();
    }
}