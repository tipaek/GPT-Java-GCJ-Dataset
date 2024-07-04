import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int testCase = 1; testCase <= testCases; testCase++) {
            int numLines = scanner.nextInt();
            String[] conditions = new String[numLines];
            
            for (int i = 0; i < numLines; i++) {
                conditions[i] = scanner.next();
            }
            
            int maxLengthIndex = 0;
            int maxLength = conditions[0].length();
            
            for (int i = 1; i < numLines; i++) {
                if (conditions[i].length() > maxLength) {
                    maxLengthIndex = i;
                    maxLength = conditions[i].length();
                }
            }
            
            boolean isValid = true;
            
            for (String condition : conditions) {
                if (!conditions[maxLengthIndex].contains(condition.substring(1))) {
                    isValid = false;
                    break;
                }
            }
            
            if (isValid) {
                System.out.println("Case #" + testCase + ": " + conditions[maxLengthIndex].substring(1));
            } else {
                System.out.println("Case #" + testCase + ": *");
            }
        }
        
        scanner.close();
    }
}