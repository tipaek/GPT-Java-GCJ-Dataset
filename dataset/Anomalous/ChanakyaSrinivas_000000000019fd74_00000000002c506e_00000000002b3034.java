import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int t = 1; t <= testCases; t++) {
            System.out.print("Case #" + t + ": ");
            int n = scanner.nextInt();
            String[] patterns = new String[n];
            String leftPattern = "";
            String rightPattern = "";
            boolean isValid = true;
            
            for (int i = 0; i < n; i++) {
                patterns[i] = scanner.next();
                int asteriskIndex = patterns[i].indexOf('*');
                
                String leftPart = patterns[i].substring(0, asteriskIndex);
                if (isValid) {
                    int minLength = Math.min(leftPart.length(), leftPattern.length());
                    if (leftPart.substring(0, minLength).equals(leftPattern.substring(0, minLength))) {
                        if (leftPart.length() > leftPattern.length()) {
                            leftPattern = leftPart;
                        }
                    } else {
                        isValid = false;
                    }
                }
                
                String rightPart = patterns[i].substring(asteriskIndex + 1);
                if (isValid) {
                    int minLength = Math.min(rightPart.length(), rightPattern.length());
                    if (rightPart.substring(rightPart.length() - minLength).equals(rightPattern.substring(rightPattern.length() - minLength))) {
                        if (rightPart.length() > rightPattern.length()) {
                            rightPattern = rightPart;
                        }
                    } else {
                        isValid = false;
                    }
                }
            }
            
            if (isValid) {
                System.out.println(leftPattern + rightPattern);
            } else {
                System.out.println("*");
            }
        }
        
        scanner.close();
    }
}