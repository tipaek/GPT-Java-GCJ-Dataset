import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int test = 1; test <= testCases; test++) {
            int n = scanner.nextInt();
            String[] patterns = new String[n];
            
            for (int i = 0; i < n; i++) {
                patterns[i] = scanner.next();
            }
            
            System.out.println("Case #" + test + ": " + findPattern(patterns));
        }
        
        scanner.close();
    }

    public static String findPattern(String[] patterns) {
        String left = "";
        String right = "";
        
        for (String pattern : patterns) {
            if (left.equals("*") || right.equals("*")) {
                return "*";
            }
            
            int starIndex = pattern.indexOf('*');
            String currentLeft = pattern.substring(0, starIndex);
            String currentRight = pattern.substring(starIndex + 1);
            
            if (left.length() < currentLeft.length()) {
                if (currentLeft.startsWith(left)) {
                    left = currentLeft;
                } else {
                    return "*";
                }
            } else if (!left.startsWith(currentLeft)) {
                return "*";
            }
            
            if (right.length() < currentRight.length()) {
                if (currentRight.endsWith(right)) {
                    right = currentRight;
                } else {
                    return "*";
                }
            } else if (!right.endsWith(currentRight)) {
                return "*";
            }
        }
        
        return left + right;
    }
}