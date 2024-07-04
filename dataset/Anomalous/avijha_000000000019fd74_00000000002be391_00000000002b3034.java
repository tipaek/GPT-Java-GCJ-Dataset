import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int testCase = 1; testCase <= testCases; testCase++) {
            int n = scanner.nextInt();
            StringBuilder start = new StringBuilder();
            StringBuilder end = new StringBuilder();
            StringBuilder mid = new StringBuilder();
            boolean isImpossible = false;
            
            for (int i = 0; i < n; i++) {
                String s = scanner.next();
                if (isImpossible) continue;
                
                int len = s.length();
                int left = 0;
                while (left < len && s.charAt(left) != '*') {
                    if (start.length() > left && start.charAt(left) != s.charAt(left)) {
                        isImpossible = true;
                        break;
                    }
                    if (start.length() <= left) {
                        start.append(s.charAt(left));
                    }
                    left++;
                }
                
                if (isImpossible) continue;
                
                int right = len - 1;
                while (right >= 0 && s.charAt(right) != '*') {
                    int endPos = len - 1 - right;
                    if (end.length() > endPos && end.charAt(endPos) != s.charAt(right)) {
                        isImpossible = true;
                        break;
                    }
                    if (end.length() <= endPos) {
                        end.append(s.charAt(right));
                    }
                    right--;
                }
                
                if (isImpossible) continue;
                
                for (int j = left; j <= right; j++) {
                    if (s.charAt(j) != '*') {
                        mid.append(s.charAt(j));
                    }
                }
            }
            
            String result;
            if (isImpossible) {
                result = "*";
            } else {
                result = start.toString() + mid.toString() + end.reverse().toString();
            }
            
            System.out.println("Case #" + testCase + ": " + result);
        }
        
        scanner.close();
    }
}