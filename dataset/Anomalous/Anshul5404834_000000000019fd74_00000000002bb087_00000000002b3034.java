import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCaseCount = sc.nextInt();
        
        for (int test = 1; test <= testCaseCount; test++) {
            int n = sc.nextInt();
            String[] patterns = new String[n];
            
            for (int i = 0; i < n; i++) {
                patterns[i] = sc.next();
            }
            
            System.out.println("Case #" + test + ": " + findPattern(patterns));
        }
        
        sc.close();
    }
    
    public static String findPattern(String[] patterns) {
        String leftPart = "";
        String rightPart = "";
        
        for (String pattern : patterns) {
            if (leftPart.equals("*") || rightPart.equals("*")) {
                return "*";
            }
            
            int starIndex = pattern.indexOf('*');
            String leftSegment = pattern.substring(0, starIndex);
            String rightSegment = pattern.substring(starIndex + 1);
            
            if (leftPart.length() < leftSegment.length()) {
                if (leftSegment.startsWith(leftPart)) {
                    leftPart = leftSegment;
                } else {
                    return "*";
                }
            } else if (!leftPart.startsWith(leftSegment)) {
                return "*";
            }
            
            if (rightPart.length() < rightSegment.length()) {
                if (rightSegment.endsWith(rightPart)) {
                    rightPart = rightSegment;
                } else {
                    return "*";
                }
            } else if (!rightPart.endsWith(rightSegment)) {
                return "*";
            }
        }
        
        return leftPart + rightPart;
    }
}